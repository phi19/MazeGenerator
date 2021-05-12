package xyz.drena.exports;

import xyz.drena.services.PathsService;

public abstract class AbstractExportable implements Exportable {

    protected PathsService pathsService;

    public void setPathsService(PathsService pathsService) { this.pathsService = pathsService; }

}
