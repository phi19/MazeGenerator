package xyz.drena.controllers.menus;

import xyz.drena.exports.exportables.AbstractExportable;
import xyz.drena.exports.utils.ExportTypes;
import xyz.drena.controllers.AbstractController;
import xyz.drena.services.ExportService;
import xyz.drena.view.tools.Messages;

import java.util.Map;

public class GenerationController extends AbstractController {

    private ExportService exportService;
    private Map<Integer, AbstractExportable> exportableMap;

    public void setMazeGenService(ExportService exportService) { this.exportService = exportService; }

    public void setExportTypesMap(Map<Integer, AbstractExportable> exportableMap) { this.exportableMap = exportableMap; }

    public void handleInput(String fileNamePrefix, int value, int exportOption) {

        if (exportOption == ExportTypes.CANCEL.getOption()) {
            return;
        }

        if (!exportableMap.containsKey(exportOption)) {
            throw new IllegalStateException(Messages.SYSTEM_ERROR);
        }

        exportService.export(fileNamePrefix, value, exportableMap.get(exportOption));
    }
}
