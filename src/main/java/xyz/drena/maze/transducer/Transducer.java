package xyz.drena.maze.transducer;

import xyz.drena.maze.Position;
import xyz.drena.view.tools.Constants;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Transducer {

    private LinkedHashMap<Cell, GroundType> labCells;
    private Cell currentCell;

    public void refreshCurrentCell(Cell currentCell) { this.currentCell = currentCell; }

    public void init(int rows, int columns) {
        populateLabCells(rows, columns);
        currentCell = null;
    }

    private void populateLabCells(int rows, int columns) {
        labCells = new LinkedHashMap<>();

        for (int y = 0; y < rows; y++) {

            for (int x = 0; x < columns; x++) {

                labCells.put(new Cell(new Position(y, x)), GroundType.WALL);
            }
        }
    }

    public void markAsFloor(Cell cell) {
        currentCell = cell;
        labCells.put(cell, GroundType.FLOOR);
    }

    public void createPath(Cell cell) {
        markAsFloor(getMiddleCell(cell));
        markAsFloor(cell);
    }

    private Cell getMiddleCell(Cell cell) {
        int middleCellRow = (currentCell.getPosition().getRow() + cell.getPosition().getRow()) / 2;
        int middleCellCol = (currentCell.getPosition().getCol() + cell.getPosition().getCol()) / 2;

        return new Cell(new Position(middleCellRow, middleCellCol));
    }

    public HashMap<Cell, GroundType> getLabCells() { return labCells; }
}
