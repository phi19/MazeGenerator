package xyz.drena.services;

import xyz.drena.exports.ExportUnits;
import xyz.drena.LabGeneration.MazeGeneration;
import xyz.drena.LabGeneration.generator.Cell;
import xyz.drena.LabGeneration.generator.GroundType;
import xyz.drena.exports.Exportable;
import xyz.drena.view.tools.Constants;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class MazeExportService {

    private MazeGeneration mazeGeneration;

    public void setMazeGeneration(MazeGeneration mazeGeneration) { this.mazeGeneration = mazeGeneration; }

    public void export(String fileNamePrefix, int mazesNumber, Exportable exportable) {

        int start = 1 + getFinalImage(fileNamePrefix, exportable);

        for (int i = start; i < start + mazesNumber; i++) {
            mazeGeneration.init();
            exportable.export(getExportUnits(mazeGeneration.getLabCells(), getGroundTypes()), fileNamePrefix + i);
        }
    }

    private HashSet<GroundType> getGroundTypes() {
        HashSet<GroundType> groundTypes = new HashSet<>();
        groundTypes.add(GroundType.FLOOR);
        groundTypes.add(GroundType.WALL);
        return groundTypes;
    }

    private int getFinalImage(String fileNamePrefix, Exportable exportable) {

        new File(Constants.FILES_MAZES_COORDINATES_PATH).mkdir();
        String[] filesArray = new File(Constants.FILES_MAZES_COORDINATES_PATH).list();

        return Arrays.stream(filesArray)
                .filter(file -> file.matches(fileNamePrefix + "[0-9]+" + exportable.getExportExtension()))
                .map(file -> file.replace(fileNamePrefix, ""))
                .map(file -> file.replace(exportable.getExportExtension(), ""))
                .map(Integer::parseInt)
                .max(Integer::compare)
                .orElse(0);
    }

    private LinkedList<ExportUnits> getExportUnits(HashMap<Cell, GroundType> cells, HashSet<GroundType> groundTypesToCollect) {

        return cells.entrySet().parallelStream()
                .filter(entry -> groundTypesToCollect.contains(entry.getValue()))
                .map(entry -> new ExportUnits(entry.getKey().getPosition(), entry.getValue()))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
