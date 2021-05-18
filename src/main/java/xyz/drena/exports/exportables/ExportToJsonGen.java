package xyz.drena.exports.exportables;

import xyz.drena.view.tools.Constants;
import java.util.HashMap;

public class ExportToJsonGen extends AbstractExportable {

    @Override
    public void export(String fileName) {
        pathsService.writeToJsonGen(getFile(fileName), getJsonUnit());
    }

    private HashMap<String, Double> getJsonUnit() {
        HashMap<String, Double> jsonUnit = new HashMap<>();
        jsonUnit.put(Constants.EXPORT_JSON_GEN_ROWS_OBJECT, (double) mazeAPI.getRows());
        jsonUnit.put(Constants.EXPORT_JSON_GEN_COLUMNS_OBJECT, (double) mazeAPI.getColumns());
        jsonUnit.put(Constants.EXPORT_JSON_GEN_SEED_OBJECT, (double) mazeAPI.getSeed());
        return jsonUnit;
    }
}
