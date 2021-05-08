package xyz.drena.LabGeneration;

import xyz.drena.LabGeneration.exports.ExportTypes;
import xyz.drena.LabGeneration.generator.Cell;
import xyz.drena.LabGeneration.generator.GroundType;

import java.util.*;
import java.util.stream.Collectors;

public class MazeExport {

    public void export(ExportTypes exportType, HashMap<Cell, GroundType> cells, HashSet<GroundType> groundTypesToCollect, String fileName) {

        LinkedList<ExportUnits> exportUnits = cells.entrySet().parallelStream()
                .filter(entry -> groundTypesToCollect.contains(entry.getValue()))
                .map(entry -> new ExportUnits(entry.getKey().getPosition(), entry.getValue()))
                .collect(Collectors.toCollection(LinkedList::new));

        exportType.getExportable().export(exportUnits, fileName);
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
