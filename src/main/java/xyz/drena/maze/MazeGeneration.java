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

    public MazeGeneration() {

        algorithm = new Algorithm();
        transducer = new Transducer();
    }

    public void init() {
        algorithm.init();
        transducer.init();

        firstBlock();

        while(algorithm.hasNext()) {
            nextBlock();
        }
    }

    private void firstBlock() {
        // randomizer
        int firstBlockRow = PseudoRandomizer.random(Constants.ALGORITHM_LAB_DEFAULT_ROWS);
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
            int randomDirectionIndex = PseudoRandomizer.random(nextPossibleBlocks.size());
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
