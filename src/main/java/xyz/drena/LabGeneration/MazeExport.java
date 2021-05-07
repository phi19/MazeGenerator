package xyz.drena.LabGeneration;

import xyz.drena.LabGeneration.exports.ExportTypes;
import xyz.drena.LabGeneration.generator.Cell;
import xyz.drena.LabGeneration.generator.GroundType;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MazeExport {

    public void export(HashMap<Cell, GroundType> labCells, ExportTypes exportType, String fileName) {

        exportType.getExportable().export(extractExportUnits(labCells), fileName);
    }

    private LinkedList<ExportUnits> extractExportUnits(HashMap<Cell, GroundType> labCells) {

        LinkedList<ExportUnits> exportUnits = new LinkedList<>();

        for (Map.Entry<Cell, GroundType> entry : labCells.entrySet()) {
            Cell cell = entry.getKey();
            GroundType groundType = entry.getValue();
            exportUnits.add(new ExportUnits(cell.getPosition(), groundType));
        }

        return exportUnits;
    }

    public static class ExportUnits {
        private final Position position;
        private final GroundType groundType;

        public ExportUnits(Position position, GroundType groundType) {
            this.position = position;
            this.groundType = groundType;
        }

        public int getRow() {
            return position.getRow();
        }

        public int getCol() {
            return position.getCol();
        }

        public GroundType getGroundType() {
            return groundType;
        }

    }
}
