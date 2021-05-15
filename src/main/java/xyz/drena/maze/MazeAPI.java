package xyz.drena.maze;

import xyz.drena.maze.algorithm.Block;
import xyz.drena.maze.algorithm.Algorithm;
import xyz.drena.maze.transducer.Cell;
import xyz.drena.maze.transducer.GroundType;
import xyz.drena.maze.transducer.Transducer;
import xyz.drena.view.tools.Constants;

import java.util.ArrayList;
import java.util.HashMap;

import static xyz.drena.maze.PseudoRandomizer.generateRandomSeed;

public class MazeAPI {

    private final MazeGeneration mazeGeneration;
    private int rows;
    private int columns;
    private long seed;

    public MazeAPI() {
        mazeGeneration = new MazeGeneration();
    }

    public void init(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        mazeGeneration.startFlow(rows, columns, generateRandomSeed());
    }

    public void init(int rows, int columns, long seed) {
        this.rows = rows;
        this.columns = columns;
        this.seed = seed;
        mazeGeneration.startFlow(rows, columns, seed);
    }

    public HashMap<Cell, GroundType> getMazeCells() {
        return mazeGeneration.transducer.getLabCells();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public long getSeed() {
        return seed;
    }

    private static class MazeGeneration {

        private final Transducer transducer;
        private final Algorithm algorithm;
        private final PseudoRandomizer pseudoRandomizer;

        public MazeGeneration() {

            algorithm = new Algorithm();
            transducer = new Transducer();
            pseudoRandomizer = new PseudoRandomizer();
        }

        private void startFlow(int rows, int columns, long seed) {

            pseudoRandomizer.setSeed(seed);

            algorithm.init((rows - 1) / 2, (columns - 1) / 2);
            transducer.init(rows, columns);

            firstBlock((rows - 1) / 2);

            while(algorithm.hasNext()) {
                nextBlock();
            }
        }

        private void firstBlock(int rows) {
            // randomizer
            int firstBlockRow = pseudoRandomizer.random(rows).intValue();
            Block firstBlock = new Block(new Position(firstBlockRow, 0));

            // algorithm position
            algorithm.markAsVisited(firstBlock);

            // generator position
            transducer.markAsFloor(blockToCell(firstBlock));
        }

        private void nextBlock() {
            ArrayList<Block> nextPossibleBlocks = algorithm.sideBlocks();

            if (nextPossibleBlocks.size() != 0) {

                // randomizer
                int randomDirectionIndex = pseudoRandomizer.random(nextPossibleBlocks.size()).intValue();
                Block forwardBlock = nextPossibleBlocks.get(randomDirectionIndex);

                // algorithm position
                algorithm.markAsVisited(forwardBlock);

                // generator position
                transducer.createPath(blockToCell(forwardBlock));

            } else {

                // block picker
                Block backBlock = algorithm.goBackwards();

                // generator refresh position
                transducer.refreshCurrentCell(blockToCell(backBlock));
            }
        }

        private Cell blockToCell(Block block) {
            return new Cell(new Position(block.getPosition().getRow()*2 + 1, block.getPosition().getCol()*2 + 1));
        }

    }
}
