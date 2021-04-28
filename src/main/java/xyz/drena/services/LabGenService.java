package xyz.drena.services;

import xyz.drena.LabGeneration.Position;
import xyz.drena.LabGeneration.algorithm.Block;
import xyz.drena.LabGeneration.algorithm.LabAlgorithm;
import xyz.drena.LabGeneration.algorithm.PseudoRandomizer;
import xyz.drena.LabGeneration.generator.Cell;
import xyz.drena.LabGeneration.generator.GroundType;
import xyz.drena.LabGeneration.generator.LabGenerator;
import xyz.drena.view.tools.Constants;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LabGenService {

    private final PseudoRandomizer randomizer;
    private final LabGenerator labGenerator;
    private final LabAlgorithm labAlgorithm;

    public LabGenService() {

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
