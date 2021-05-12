package xyz.drena.exports;

import org.json.JSONArray;
import org.json.JSONObject;
import xyz.drena.services.PathsService;
import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class ExportToJson extends AbstractExportable {

    @Override
    public void export(LinkedList<ExportUnits> exportUnits, String fileName) {

        pathsService.writeToFile(getUnits(exportUnits), getFile(fileName));
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
