package xyz.drena.controllers.menus;

import xyz.drena.exports.ExportTypes;
import xyz.drena.exports.Exportable;
import xyz.drena.controllers.AbstractController;
import xyz.drena.services.MazeGenService;
import xyz.drena.view.tools.Messages;

import java.util.Map;

public class GenerationController extends AbstractController {

    private MazeGenService mazeGenService;
    private Map<Integer, Exportable> exportableMap;

    public void setMazeGenService(MazeGenService mazeGenService) { this.mazeGenService = mazeGenService; }

    public void setExportTypesMap(Map<Integer, Exportable> exportableMap) { this.exportableMap = exportableMap; }

    public void handleInput(String fileNamePrefix, int value, int exportOption) {

        if (exportOption == ExportTypes.CANCEL.getOption()) {
            return;
        }

        if (!exportableMap.containsKey(exportOption)) {
            throw new IllegalStateException(Messages.SYSTEM_ERROR);
        }

        mazeGenService.generate(fileNamePrefix, value, exportableMap.get(exportOption));
    }
}
