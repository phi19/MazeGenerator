package xyz.drena.exports;

import org.json.JSONArray;
import org.json.JSONObject;
import xyz.drena.Main;
import xyz.drena.view.Constants;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ExportToJson implements Exportable {

    @Override
    public void export(LinkedList<Main.ExportUnits> exportUnits) {

        JSONArray jsonUnitsArray = new JSONArray();

        exportUnits.forEach(exportUnit -> {

            JSONObject jsonUnit = new JSONObject();
            jsonUnit.put("row", exportUnit.getRow());
            jsonUnit.put("col", exportUnit.getCol());
            jsonUnit.put("GroundType", exportUnit.getGroundType());

            jsonUnitsArray.put(jsonUnit);
        });

        try {

            FileWriter file = new FileWriter(Constants.FILES_EXPORT_PATH + Constants.FILE_EXPORT_NAME + Constants.EXPORT_JSON_EXTENSION);
            file.write(jsonUnitsArray.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
