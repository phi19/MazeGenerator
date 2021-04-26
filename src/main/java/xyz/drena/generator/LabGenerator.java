package xyz.drena.generator;

import xyz.drena.view.Constants;

import java.util.LinkedHashMap;

public class LabGenerator {

    private LinkedHashMap<Cell, GroundType> labCells;

    private Cell currentCell;

    public void refreshCurrentCell(Cell currentCell) { this.currentCell = currentCell; }

    public LabGenerator() {
        populateLabCells();
    }

    private void populateLabCells() {
        labCells = new LinkedHashMap<>();

        for (int y = 0; y < Constants.GENERATOR_LAB_ROWS; y++) {

            for (int x = 0; x < Constants.GENERATOR_LAB_COLUMNS; x++) {

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

    public LinkedHashMap<Cell, GroundType> getLabCells() { return labCells; }
}
