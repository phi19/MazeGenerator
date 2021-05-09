package xyz.drena.controllers.menus;

import xyz.drena.exports.ExportTypes;
import xyz.drena.exports.Exportable;
import xyz.drena.controllers.AbstractController;
import xyz.drena.services.MazeExportService;
import xyz.drena.view.tools.Messages;

import java.util.Map;

public class GenerationController extends AbstractController {

    private MazeExportService mazeExportService;
    private Map<Integer, Exportable> exportableMap;

    public void setMazeGenService(MazeExportService mazeExportService) { this.mazeExportService = mazeExportService; }

    public void setExportTypesMap(Map<Integer, Exportable> exportableMap) { this.exportableMap = exportableMap; }

    public void handleInput(String fileNamePrefix, int value, int exportOption) {

        if (exportOption == ExportTypes.CANCEL.getOption()) {
            return;
        }

        if (!exportableMap.containsKey(exportOption)) {
            throw new IllegalStateException(Messages.SYSTEM_ERROR);
        }

        mazeExportService.export(fileNamePrefix, value, exportableMap.get(exportOption));
    }
}
