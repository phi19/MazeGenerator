package xyz.drena.exports.exportables;

import org.json.JSONArray;
import org.json.JSONObject;
import xyz.drena.view.tools.Constants;

public class ExportToJsonGen extends AbstractExportable {

    @Override
    public void export(String fileName) {
        pathsService.writeToFile(getFile(fileName), getJsonUnit());
    }

    private String getJsonUnit() {
        JSONArray jsonUnitsArray = new JSONArray();
        JSONObject jsonUnit = new JSONObject();
        jsonUnit.put(Constants.EXPORT_JSON_GEN_ROWS_OBJECT, mazeAPI.getRows());
        jsonUnit.put(Constants.EXPORT_JSON_GEN_COLUMNS_OBJECT, mazeAPI.getColumns());
        jsonUnit.put(Constants.EXPORT_JSON_GEN_SEED_OBJECT, mazeAPI.getSeed());
        jsonUnitsArray.put(jsonUnit);
        return jsonUnitsArray.toString();
    }
}
