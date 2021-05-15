package xyz.drena.exports.exportables;

public class ExportToSeed extends AbstractExportable {

    @Override
    public void export(String fileName) {
        pathsService.writeToFile(getFile(fileName), String.valueOf(mazeAPI.getSeed()));
    }
}
