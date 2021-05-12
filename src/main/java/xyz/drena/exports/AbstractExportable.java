package xyz.drena.exports;

import xyz.drena.services.PathsService;

import java.io.File;

public abstract class AbstractExportable implements Exportable {

    protected PathsService pathsService;
    protected ExportTypes exportType;

    public void setPathsService(PathsService pathsService) { this.pathsService = pathsService; }

    public void setExportType(ExportTypes exportType) { this.exportType = exportType; }

    public ExportTypes getExportType() { return exportType; }

    protected File getFile(String fileName) {
        return new File(exportType.getPath() + fileName + exportType.getExtension());
    }

}
