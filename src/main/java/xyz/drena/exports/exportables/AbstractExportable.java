package xyz.drena.exports.exportables;

import xyz.drena.exports.utils.ExportTypes;
import xyz.drena.exports.utils.ExportUnits;
import xyz.drena.maze.MazeAPI;
import xyz.drena.services.PathsService;
import xyz.drena.view.tools.Constants;

import java.io.File;
import java.util.LinkedList;
import java.util.stream.Collectors;

public abstract class AbstractExportable implements Exportable {

    protected PathsService pathsService;
    protected ExportTypes exportType;
    protected MazeAPI mazeAPI;

    public void setPathsService(PathsService pathsService) { this.pathsService = pathsService; }

    public void setExportType(ExportTypes exportType) { this.exportType = exportType; }

    public void setMazeAPI(MazeAPI mazeAPI) { this.mazeAPI = mazeAPI; }

    protected File getFile(String fileName) { return new File(exportType.getPath() + fileName + exportType.getExtension()); }

    protected LinkedList<ExportUnits> getExportUnits() {
        return mazeAPI.getMazeCells().entrySet().parallelStream()
                .filter(entry -> Constants.GROUND_TYPE_HASH_SET.contains(entry.getValue()))
                .map(entry -> new ExportUnits(entry.getKey().getPosition(), entry.getValue()))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public ExportTypes getExportType() { return exportType; }
}
