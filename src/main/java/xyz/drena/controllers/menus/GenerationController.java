package xyz.drena.controllers.menus;

import xyz.drena.LabGeneration.exports.Exportable;
import xyz.drena.controllers.AbstractController;
import xyz.drena.services.MazeGenService;
import xyz.drena.view.menuOptions.MainOptions;
import xyz.drena.view.tools.Messages;

import java.util.Map;

public class GenerationController extends AbstractController {

    private MazeGenService mazeGenService;
    private Map<Integer, Exportable> exportableMap;

    public void setMazeGenService(MazeGenService mazeGenService) { this.mazeGenService = mazeGenService; }

    public void setExportTypesMap(Map<Integer, Exportable> exportableMap) { this.exportableMap = exportableMap; }

    public void handleValue(String fileNamePrefix, int value, int exportOption) {

        if (exportOption == MainOptions.QUIT.getOption()) {
            return;
        }

        if (!exportableMap.containsKey(exportOption)) {
            throw new IllegalStateException(Messages.SYSTEM_ERROR);
        }

        init();

        mazeGenService.generate(fileNamePrefix, value, exportableMap.get(exportOption));
    }
}
