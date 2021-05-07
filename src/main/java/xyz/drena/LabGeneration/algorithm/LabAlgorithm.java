package xyz.drena.LabGeneration.algorithm;

import xyz.drena.LabGeneration.Position;
import xyz.drena.view.tools.Constants;

import java.util.ArrayList;
import java.util.LinkedList;

public class LabAlgorithm {

    private ArrayList<Block> remainingBlocks;
    private ArrayList<Block> currentPath;
    private Block currentBlock;

    public void init() {
        populateBlocks();
        currentPath = new ArrayList<>();
        currentBlock = null;
    }

    private void populateBlocks() {
        remainingBlocks = new ArrayList<>();

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

    public ArrayList<Block> sideBlocks() {

        ArrayList<Block> sideBlocks = new ArrayList<>();

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

        currentBlock = currentPath.get(currentPath.size() - 1);
        currentPath.remove(currentPath.size() - 1);
        return currentBlock;
    }
}
