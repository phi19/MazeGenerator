package xyz.drena.controllers.menus;

import xyz.drena.maze.MazeGeneration;
import xyz.drena.maze.transducer.Cell;
import xyz.drena.maze.transducer.GroundType;
import xyz.drena.controllers.AbstractController;
import xyz.drena.exports.ExportUnits;
import xyz.drena.services.EditService;
import xyz.drena.view.tools.Constants;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class EditController extends AbstractController {

    private EditService editService;
    private MazeGeneration mazeGeneration;

    public void setEditService(EditService editService) { this.editService = editService; }

    public void setMazeGeneration(MazeGeneration mazeGeneration) { this.mazeGeneration = mazeGeneration; }

    public void start() {
        mazeGeneration.init();
        editService.export(getExportUnits(mazeGeneration.getLabCells()));
    }

    private LinkedList<ExportUnits> getExportUnits(HashMap<Cell, GroundType> cells) {

        return cells.entrySet().parallelStream()
                .filter(entry -> Constants.GROUND_TYPE_HASH_SET.contains(entry.getValue()))
                .map(entry -> new ExportUnits(entry.getKey().getPosition(), entry.getValue()))
                .collect(Collectors.toCollection(LinkedList::new));
    }

}
