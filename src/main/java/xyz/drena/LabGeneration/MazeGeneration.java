package xyz.drena.LabGeneration;

import xyz.drena.LabGeneration.algorithm.Block;
import xyz.drena.LabGeneration.algorithm.LabAlgorithm;
import xyz.drena.LabGeneration.algorithm.PseudoRandomizer;
import xyz.drena.LabGeneration.generator.Cell;
import xyz.drena.LabGeneration.generator.GroundType;
import xyz.drena.LabGeneration.generator.LabGenerator;
import xyz.drena.view.tools.Constants;

import java.util.ArrayList;
import java.util.HashMap;

public class MazeGeneration {

    private final LabGenerator labGenerator;
    private final LabAlgorithm labAlgorithm;

    public MazeGeneration() {

        labAlgorithm = new LabAlgorithm();
        labGenerator = new LabGenerator();
    }

    public void init() {
        labAlgorithm.init();
        labGenerator.init();

        firstBlock();

        while(labAlgorithm.hasNext()) {
            nextBlock();
        }
    }

    private void firstBlock() {
        // randomizer
        int firstBlockRow = PseudoRandomizer.random(Constants.ALGORITHM_LAB_DEFAULT_ROWS);
        Block firstBlock = new Block(new Position(firstBlockRow, 0));

        // algorithm position
        labAlgorithm.markAsVisited(firstBlock);

        // generator position
        labGenerator.markAsFloor(blockToCell(firstBlock));
    }

    private void nextBlock() {
        ArrayList<Block> nextPossibleBlocks = labAlgorithm.sideBlocks();

        if (nextPossibleBlocks.size() != 0) {

            // randomizer
            int randomDirectionIndex = PseudoRandomizer.random(nextPossibleBlocks.size());
            Block forwardBlock = nextPossibleBlocks.get(randomDirectionIndex);

            // algorithm position
            labAlgorithm.markAsVisited(forwardBlock);

            // generator position
            labGenerator.createPath(blockToCell(forwardBlock));

        } else {

            // block picker
            Block backBlock = labAlgorithm.goBackwards();

            // generator refresh position
            labGenerator.refreshCurrentCell(blockToCell(backBlock));
        }
    }

    private Cell blockToCell(Block block) {
        return new Cell(new Position(block.getPosition().getRow()*2 + 1, block.getPosition().getCol()*2 + 1));
    }

    public HashMap<Cell, GroundType> getLabCells() { return labGenerator.getLabCells(); }
}
