package xyz.drena.services;

import xyz.drena.exports.exportables.AbstractExportable;
import xyz.drena.exports.utils.ExportUnits;
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

        int start = 1 + getStartFile(fileNamePrefix, exportable);

        if (start < 1) { return; }

        int rows = getRows();
        int columns = getColumns();

        for (int i = start; i < start + mazesNumber; i++) {
            // me has to change
            mazeGeneration.init(rows, columns);
            exportable.export(getExportUnits(mazeGeneration.getLabCells()), fileNamePrefix + i);
        }
    }

    private int getStartFile(String fileNamePrefix, AbstractExportable exportable) {

        String[] filesArray = pathsService.getDirectoryList(new File(exportable.getExportType().getPath()));

        if (filesArray == null) {
            System.out.println(Messages.SYSTEM_ERROR);
            return -1;
        }

        return Arrays.stream(filesArray).parallel()
                .filter(file -> file.matches(fileNamePrefix + "[0-9]+" + exportable.getExportType().getExtension()))
                .map(file -> file.replace(fileNamePrefix, ""))
                .map(file -> file.replace(exportable.getExportType().getExtension(), ""))
                .map(Integer::parseInt)
                .max(Integer::compare)
                .orElse(0);
    }

    private int getRows() {
        File rowsFile = new File(Constants.DEFAULT_ROWS_PATH);
        try {
            return (int) Double.parseDouble(pathsService.readFromFile(rowsFile));
        } catch (NumberFormatException ex) {
            pathsService.writeToFile(rowsFile, String.valueOf(Constants.GENERATOR_LAB_ROWS));
            return Constants.GENERATOR_LAB_ROWS;
        }
    }

    private int getColumns() {
        File columnsFile = new File(Constants.DEFAULT_COLUMNS_PATH);
        try {
            return (int) Double.parseDouble(pathsService.readFromFile(columnsFile));
        } catch (NumberFormatException ex) {
            pathsService.writeToFile(columnsFile, String.valueOf(Constants.GENERATOR_LAB_COLUMNS));
            return Constants.GENERATOR_LAB_COLUMNS;
        }
    }

    private LinkedList<ExportUnits> getExportUnits(HashMap<Cell, GroundType> cells) {

        return cells.entrySet().parallelStream()
                .filter(entry -> Constants.GROUND_TYPE_HASH_SET.contains(entry.getValue()))
                .map(entry -> new ExportUnits(entry.getKey().getPosition(), entry.getValue()))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
