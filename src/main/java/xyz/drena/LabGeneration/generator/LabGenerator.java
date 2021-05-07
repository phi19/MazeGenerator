package xyz.drena.LabGeneration.generator;

import xyz.drena.LabGeneration.Position;
import xyz.drena.view.tools.Constants;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LabGenerator {

    private LinkedHashMap<Cell, GroundType> labCells;
    private Cell currentCell;

    public void refreshCurrentCell(Cell currentCell) { this.currentCell = currentCell; }

    public void init() {
        populateLabCells();
        currentCell = null;
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

    public HashMap<Cell, GroundType> getLabCells() { return labCells; }
}
