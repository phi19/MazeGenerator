package xyz.drena.maze;

import xyz.drena.maze.algorithm.Block;
import xyz.drena.maze.algorithm.Algorithm;
import xyz.drena.maze.transducer.Cell;
import xyz.drena.maze.transducer.GroundType;
import xyz.drena.maze.transducer.Transducer;
import xyz.drena.view.tools.Constants;

import java.util.ArrayList;
import java.util.HashMap;

public class MazeGeneration {

    private final Transducer transducer;
    private final Algorithm algorithm;
    private final PseudoRandomizer pseudoRandomizer;

    public MazeGeneration() {

        algorithm = new Algorithm();
        transducer = new Transducer();
        pseudoRandomizer = new PseudoRandomizer();
    }

    public void init(int rows, int columns) {
        pseudoRandomizer.generateRandomSeed();
        startFlow(rows, columns);
    }

    public void init(int rows, int columns, long seed) {
        pseudoRandomizer.setSeed(seed);
        startFlow(rows, columns);
    }

    private void startFlow(int rows, int columns) {

        algorithm.init(rows, columns);
        transducer.init(rows*2+1, columns*2+1);

        firstBlock(rows);

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

    public HashMap<Cell, GroundType> getLabCells() { return transducer.getLabCells(); }
}
