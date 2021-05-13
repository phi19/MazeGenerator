package xyz.drena.exports.exportables;

import org.json.JSONArray;
import org.json.JSONObject;
import xyz.drena.exports.utils.ExportUnits;
import xyz.drena.view.tools.Constants;

import java.util.LinkedList;

public class ExportToJson extends AbstractExportable {

    @Override
    public void export(LinkedList<ExportUnits> exportUnits, String fileName) {

        pathsService.writeToFile(getFile(fileName), getUnits(exportUnits));
    }

    private String getUnits(LinkedList<ExportUnits> exportUnits) {
        JSONArray jsonUnitsArray = new JSONArray();

        for (ExportUnits exportUnit : exportUnits) {
            JSONObject jsonUnit = new JSONObject();
            jsonUnit.put(Constants.EXPORT_JSON_ROW_OBJECT, exportUnit.getRow());
            jsonUnit.put(Constants.EXPORT_JSON_COLUMN_OBJECT, exportUnit.getCol());
            jsonUnit.put(Constants.EXPORT_JSON_GROUND_TYPE_OBJECT, exportUnit.getGroundType());

            jsonUnitsArray.put(jsonUnit);
        }

        return jsonUnitsArray.toString();
    }
}
