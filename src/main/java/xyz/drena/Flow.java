package xyz.drena;

import xyz.drena.generator.Cell;
import xyz.drena.generator.GroundType;
import xyz.drena.generator.Position;
import xyz.drena.algorithm.Block;
import xyz.drena.algorithm.LabAlgorithm;
import xyz.drena.generator.LabGenerator;
import xyz.drena.algorithm.PseudoRandomizer;
import xyz.drena.view.Constants;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Flow {

    private final PseudoRandomizer randomizer;
    private final LabGenerator labGenerator;
    private final LabAlgorithm labAlgorithm;

    public Flow() {

        randomizer = new PseudoRandomizer();
        labAlgorithm = new LabAlgorithm();
        labGenerator = new LabGenerator();
    }

    public void init() {

        firstBlock();

        while(labAlgorithm.hasNext()) {
            nextBlock();
        }
    }

    private void firstBlock() {
        // randomizer
        int firstBlockRow = randomizer.random(Constants.ALGORITHM_LAB_DEFAULT_ROWS);
        Block firstBlock = new Block(new Position(firstBlockRow, 0));

        // algorithm position
        labAlgorithm.markAsVisited(firstBlock);

        // generator position
        labGenerator.markAsFloor(blockToCell(firstBlock));
    }

    private void nextBlock() {
        LinkedList<Block> nextPossibleBlocks = labAlgorithm.sideBlocks();

        if (nextPossibleBlocks.size() != 0) {

            // randomizer
            int randomDirectionIndex = randomizer.random(nextPossibleBlocks.size());
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

    public LinkedHashMap<Cell, GroundType> getLabCells() { return labGenerator.getLabCells(); }
}
