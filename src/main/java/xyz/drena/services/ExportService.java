package xyz.drena.services;

import xyz.drena.exports.AbstractExportable;
import xyz.drena.exports.ExportUnits;
import xyz.drena.maze.MazeGeneration;
import xyz.drena.maze.transducer.Cell;
import xyz.drena.maze.transducer.GroundType;
import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class ExportService {

    private PathsService pathsService;
    private MazeGeneration mazeGeneration;

    public void setPathsService(PathsService pathsService) { this.pathsService = pathsService; }

    public void setMazeGeneration(MazeGeneration mazeGeneration) { this.mazeGeneration = mazeGeneration; }

    public void export(String fileNamePrefix, int mazesNumber, AbstractExportable exportable) {

        int start = 1 + getFinalImage(fileNamePrefix, exportable);

        if (start < 1) { return; }

        for (int i = start; i < start + mazesNumber; i++) {
            // me has to change
            mazeGeneration.init((int) Constants.ALGORITHM_LAB_DEFAULT_ROWS, (int) Constants.ALGORITHM_LAB_DEFAULT_COLUMNS);
            exportable.export(getExportUnits(mazeGeneration.getLabCells()), fileNamePrefix + i);
        }
    }

    private int getFinalImage(String fileNamePrefix, AbstractExportable exportable) {

        String[] filesArray = pathsService.getDirectoryList(new File(exportable.getExportType().getPath()));

        if (filesArray == null) {
            System.out.println(Messages.SYSTEM_ERROR);
            return -1;
        }

        return Arrays.stream(filesArray)
                .filter(file -> file.matches(fileNamePrefix + "[0-9]+" + exportable.getExportType().getExtension()))
                .map(file -> file.replace(fileNamePrefix, ""))
                .map(file -> file.replace(exportable.getExportType().getExtension(), ""))
                .map(Integer::parseInt)
                .max(Integer::compare)
                .orElse(0);
    }

    private LinkedList<ExportUnits> getExportUnits(HashMap<Cell, GroundType> cells) {

        return cells.entrySet().parallelStream()
                .filter(entry -> Constants.GROUND_TYPE_HASH_SET.contains(entry.getValue()))
                .map(entry -> new ExportUnits(entry.getKey().getPosition(), entry.getValue()))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
