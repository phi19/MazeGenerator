package xyz.drena.LabGeneration.algorithm;

import xyz.drena.LabGeneration.Position;
import xyz.drena.view.Constants;

import java.util.LinkedList;

public class LabAlgorithm {

    private LinkedList<Block> remainingBlocks;

    private final LinkedList<Block> currentPath;

    private Block currentBlock;

    public LabAlgorithm() {
        populateBlocks();
        currentPath = new LinkedList<>();
    }

    private void populateBlocks() {
        remainingBlocks = new LinkedList<>();

        for (int y = 0; y < Constants.ALGORITHM_LAB_DEFAULT_ROWS; y++) {

            for (int x = 0; x < Constants.ALGORITHM_LAB_DEFAULT_COLUMNS; x++) {

                remainingBlocks.add(new Block(new Position(y, x)));
            }
        }
    }

    public void markAsVisited(Block block) {
        currentBlock = block;

        currentPath.add(block);
        remainingBlocks.remove(block);
    }

    public boolean hasNext() {
        return remainingBlocks.size() != 0;
    }

    public LinkedList<Block> sideBlocks() {

        LinkedList<Block> sideBlocks = new LinkedList<>();

        for (Direction direction : Direction.values()) {

            Block sideBlock = sideBlock(direction);

            if (remainingBlocks.contains(sideBlock)) {
                sideBlocks.add(sideBlock);
            }
        }

        return sideBlocks;
    }

    private Block sideBlock(Direction direction) {
        int sideBlockRow = currentBlock.getPosition().getRow() + direction.getDy();
        int sideBlockCol = currentBlock.getPosition().getCol() + direction.getDx();

        return new Block (new Position(sideBlockRow, sideBlockCol));
    }

    public Block goBackwards() {

        currentBlock = currentPath.getLast();
        currentPath.removeLast();
        return currentBlock;
    }
}
