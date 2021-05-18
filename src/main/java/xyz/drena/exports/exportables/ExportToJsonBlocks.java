package xyz.drena.exports.exportables;

public class ExportToJsonBlocks extends AbstractExportable {

    @Override
    public void export(String fileName) {

        pathsService.writeToJsonBlocks(getFile(fileName), getExportUnits());
    }
}
