package xyz.drena.services;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import xyz.drena.exports.utils.ExportUnits;
import xyz.drena.maze.MazeAPI;
import xyz.drena.maze.transducer.Cell;
import xyz.drena.maze.transducer.GroundType;
import xyz.drena.view.tools.Constants;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class EditService {

    private MazeAPI mazeAPI;

    public void setMazeGeneration(MazeAPI mazeAPI) { this.mazeAPI = mazeAPI; }

    public void init() {
        // for now, this is a "generate a random lab and edit it"
        mazeAPI.init(Constants.ALGORITHM_LAB_DEFAULT_ROWS, Constants.ALGORITHM_LAB_DEFAULT_COLUMNS);
        view(getExportUnits());

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
                    Constants.VIEWER_PADDING + exportUnit.getCol()*getViewerUnitSize(),
                    Constants.VIEWER_PADDING + exportUnit.getRow()*getViewerUnitSize(),
                    getViewerUnitSize(),
                    getViewerUnitSize()
            );
            rectangle.setColor(exportUnit.getGroundType().getColor());
            rectangle.fill();
        });
    }

    private int getViewerUnitSize() {
        if (Constants.VIEWER_DEFAULT_UNIT_SIZE * Constants.GENERATOR_LAB_ROWS > Constants.VIEWER_MAXIMUM_HEIGHT) {
            return (Constants.VIEWER_MAXIMUM_HEIGHT / Constants.GENERATOR_LAB_ROWS);
        } else {
            return Constants.VIEWER_DEFAULT_UNIT_SIZE;
        }
    }
}
