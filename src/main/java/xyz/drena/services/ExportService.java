package xyz.drena.services;

import xyz.drena.exports.ExportUnits;
import xyz.drena.LabGeneration.MazeGeneration;
import xyz.drena.LabGeneration.generator.Cell;
import xyz.drena.LabGeneration.generator.GroundType;
import xyz.drena.exports.Exportable;
import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class ExportService {

    private MazeGeneration mazeGeneration;

    public void setMazeGeneration(MazeGeneration mazeGeneration) { this.mazeGeneration = mazeGeneration; }

    public void export(String fileNamePrefix, int mazesNumber, Exportable exportable) {

        int start = 1 + getFinalImage(fileNamePrefix, exportable);

        if (start < 1) { return; }

        for (int i = start; i < start + mazesNumber; i++) {
            mazeGeneration.init();
            exportable.export(getExportUnits(mazeGeneration.getLabCells()), fileNamePrefix + i);
        }
    }

    private int getFinalImage(String fileNamePrefix, Exportable exportable) {

        String[] filesArray = doesDirectoryExist();

        if (filesArray == null) {
            System.out.println(Messages.SYSTEM_ERROR);
            return -1;
        }

        return Arrays.stream(filesArray)
                .filter(file -> file.matches(fileNamePrefix + "[0-9]+" + exportable.getExportExtension()))
                .map(file -> file.replace(fileNamePrefix, ""))
                .map(file -> file.replace(exportable.getExportExtension(), ""))
                .map(Integer::parseInt)
                .max(Integer::compare)
                .orElse(0);
    }

    private String[] doesDirectoryExist() {

        if (!Constants.DIRECTORY_MAZES_EXPORT.exists() && !Constants.DIRECTORY_MAZES_EXPORT.mkdir()) {
            System.out.println(Messages.SYSTEM_ERROR);
            return null;
        }

        return Constants.DIRECTORY_MAZES_EXPORT.list();
    }

    private LinkedList<ExportUnits> getExportUnits(HashMap<Cell, GroundType> cells) {

        return cells.entrySet().parallelStream()
                .filter(entry -> Constants.GROUND_TYPE_HASH_SET.contains(entry.getValue()))
                .map(entry -> new ExportUnits(entry.getKey().getPosition(), entry.getValue()))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
