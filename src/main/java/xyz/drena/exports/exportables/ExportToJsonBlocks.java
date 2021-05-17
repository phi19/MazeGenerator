package xyz.drena.exports.exportables;

import org.json.JSONArray;
import org.json.JSONObject;
import xyz.drena.exports.utils.ExportUnits;
import xyz.drena.view.tools.Constants;

public class ExportToJsonBlocks extends AbstractExportable {

    @Override
    public void export(String fileName) {

        pathsService.writeToFile(getFile(fileName), getJsonUnits());
    }

    private String getJsonUnits() {
        JSONArray jsonUnitsArray = new JSONArray();

        for (ExportUnits exportUnit : getExportUnits()) {
            JSONObject jsonUnit = new JSONObject();
            jsonUnit.put(Constants.EXPORT_JSON_BLOCKS_ROW_OBJECT, exportUnit.getRow());
            jsonUnit.put(Constants.EXPORT_JSON_BLOCKS_COLUMN_OBJECT, exportUnit.getCol());
            jsonUnit.put(Constants.EXPORT_JSON_BLOCKS_GROUND_TYPE_OBJECT, exportUnit.getGroundType());

            jsonUnitsArray.put(jsonUnit);
        }

        return jsonUnitsArray.toString();
    }
}
