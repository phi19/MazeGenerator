package xyz.drena.maze.algorithm;

import xyz.drena.maze.Position;
import xyz.drena.view.tools.Constants;
import java.util.ArrayList;

public class Algorithm {

    private ArrayList<Block> remainingBlocks;
    private ArrayList<Block> currentPath;
    private Block currentBlock;

    public void init(int rows, int columns) {
        populateBlocks(rows, columns);
        currentPath = new ArrayList<>();
        currentBlock = null;
    }

    private void populateBlocks(int rows, int columns) {
        remainingBlocks = new ArrayList<>();

        for (int y = 0; y < rows; y++) {

            for (int x = 0; x < columns; x++) {

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
