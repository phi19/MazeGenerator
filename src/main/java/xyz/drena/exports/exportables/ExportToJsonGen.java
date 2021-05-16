package xyz.drena.exports.exportables;

public class ExportToJsonGen extends AbstractExportable {

    @Override
    public void export(String fileName) {
        pathsService.writeToFile(getFile(fileName), String.valueOf(mazeAPI.getSeed()));
    }
}
