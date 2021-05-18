package xyz.drena.services;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import xyz.drena.exports.utils.ExportUnits;
import xyz.drena.maze.MazeAPI;
import xyz.drena.view.tools.Constants;

import java.io.File;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class EditService {

    private MazeAPI mazeAPI;
    private PathsService pathsService;

    public void setMazeGeneration(MazeAPI mazeAPI) { this.mazeAPI = mazeAPI; }

    public void setPathsService(PathsService pathsService) { this.pathsService = pathsService; }

    public void init() {
        // getFile -> rows, columns, seed
        double s = System.nanoTime();
        mazeAPI.init();
        System.out.println(s - System.nanoTime());
        view(getExportUnits());

        //pathsService.readFromJson();

    }

    private LinkedList<ExportUnits> getExportUnits() {

        return mazeAPI.getMazeCells().entrySet().parallelStream()
                .filter(entry -> Constants.GROUND_TYPE_HASH_SET.contains(entry.getValue()))
                .map(entry -> new ExportUnits(entry.getKey().getPosition(), entry.getValue()))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private void view(LinkedList<ExportUnits> exportUnits) {
        exportUnits.forEach(exportUnit -> {
            Rectangle rectangle = new Rectangle(
                    Constants.VIEWER_BORDER_PADDING + exportUnit.getCol()*getViewerUnitSize(),
                    Constants.VIEWER_BORDER_PADDING + exportUnit.getRow()*getViewerUnitSize(),
                    getViewerUnitSize(),
                    getViewerUnitSize()
            );
            rectangle.setColor(exportUnit.getGroundType().getColor());
            rectangle.fill();
        });
    }

    private int getViewerUnitSize() {
        boolean isMazeBiggerThanWindow = Constants.VIEWER_UNIT_SIZE * mazeAPI.getRows() > Constants.VIEWER_MAXIMUM_HEIGHT;
        int divideFactor = isMazeBiggerThanWindow ? mazeAPI.getRows() : 1;
        return Constants.VIEWER_UNIT_SIZE / divideFactor;
    }
}
