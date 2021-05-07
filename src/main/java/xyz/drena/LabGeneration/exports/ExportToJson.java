package xyz.drena.LabGeneration.exports;

import org.json.JSONArray;
import org.json.JSONObject;
import xyz.drena.LabGeneration.MazeExport;
import xyz.drena.view.tools.Constants;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ExportToJson extends AbstractExportable {

    @Override
    public void export(LinkedList<MazeExport.ExportUnits> exportUnits, String fileName) {

        JSONArray jsonUnitsArray = new JSONArray();

        for (MazeExport.ExportUnits exportUnit : exportUnits) {
            JSONObject jsonUnit = new JSONObject();
            jsonUnit.put("row", exportUnit.getRow());
            jsonUnit.put("col", exportUnit.getCol());
            jsonUnit.put("GroundType", exportUnit.getGroundType());

            jsonUnitsArray.put(jsonUnit);
        }

        try {

            FileWriter file = new FileWriter(Constants.FILES_MAZES_COORDINATES_PATH + fileName + Constants.EXPORT_JSON_EXTENSION);
            file.write(jsonUnitsArray.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
