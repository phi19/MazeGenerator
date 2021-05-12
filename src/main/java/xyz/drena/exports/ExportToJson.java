package xyz.drena.exports;

import org.json.JSONArray;
import org.json.JSONObject;
import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ExportToJson implements Exportable {

    @Override
    public void export(LinkedList<ExportUnits> exportUnits, String fileName) {

        JSONArray jsonUnitsArray = new JSONArray();

        for (ExportUnits exportUnit : exportUnits) {
            JSONObject jsonUnit = new JSONObject();
            jsonUnit.put(Constants.EXPORT_JSON_ROW_OBJECT, exportUnit.getRow());
            jsonUnit.put(Constants.EXPORT_JSON_COLUMN_OBJECT, exportUnit.getCol());
            jsonUnit.put(Constants.EXPORT_JSON_GROUND_TYPE_OBJECT, exportUnit.getGroundType());

            jsonUnitsArray.put(jsonUnit);
        }

        try {

            FileWriter file = new FileWriter(
                    Constants.EXPORT_JSON_PATH + fileName + Constants.EXPORT_JSON_EXTENSION);
            file.write(jsonUnitsArray.toString());
            file.flush();

        } catch (IOException e) {
            System.out.println(Messages.SYSTEM_ERROR);
        }
    }

    @Override
    public String getExportExtension() {
        return Constants.EXPORT_JSON_EXTENSION;
    }
}
