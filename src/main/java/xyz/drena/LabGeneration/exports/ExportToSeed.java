package xyz.drena.LabGeneration.exports;

import xyz.drena.LabGeneration.MazeExport;
import xyz.drena.view.tools.Constants;
import java.io.*;
import java.util.LinkedList;

public class ExportToSeed extends AbstractExportable {

    @Override
    public void export(LinkedList<MazeExport.ExportUnits> exportUnits, String fileName) {
        try {
            PrintWriter printWriter = new PrintWriter(Constants.FILES_MAZES_COORDINATES_PATH + fileName + Constants.EXPORT_SEED_EXTENSION);
            printWriter.write(Constants.RANDOMIZER_DEFAULT_SEED);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
