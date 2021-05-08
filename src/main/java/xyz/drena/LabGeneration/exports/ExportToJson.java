package xyz.drena.LabGeneration.exports;

import org.json.JSONArray;
import org.json.JSONObject;
import xyz.drena.LabGeneration.MazeExport;
import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ExportToJson extends AbstractExportable {

    @Override
    public void export(LinkedList<MazeExport.ExportUnits> exportUnits, String fileName) {

        JSONArray jsonUnitsArray = new JSONArray();

        for (MazeExport.ExportUnits exportUnit : exportUnits) {
            JSONObject jsonUnit = new JSONObject();
            jsonUnit.put(Constants.EXPORT_JSON_ROW_OBJECT, exportUnit.getRow());
            jsonUnit.put(Constants.EXPORT_JSON_COLUMN_OBJECT, exportUnit.getCol());
            jsonUnit.put(Constants.EXPORT_JSON_GROUND_TYPE_OBJECT, exportUnit.getGroundType());

            jsonUnitsArray.put(jsonUnit);
        }

        try {

            FileWriter file = new FileWriter(
                    Constants.FILES_MAZES_COORDINATES_PATH + fileName + Constants.EXPORT_JSON_EXTENSION);
            file.write(jsonUnitsArray.toString());
            file.flush();

        } catch (IOException e) {
            System.out.println(Messages.SYSTEM_ERROR);
        }
    }
}
