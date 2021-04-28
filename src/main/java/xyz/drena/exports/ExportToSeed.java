package xyz.drena.exports;

import xyz.drena.controllers.menus.ExportController;
import xyz.drena.view.tools.Constants;
import java.io.*;
import java.util.LinkedList;

public class ExportToSeed implements Exportable {

    @Override
    public void export(LinkedList<ExportController.ExportUnits> exportUnits) {

        try {

            PrintWriter printWriter = new PrintWriter(Constants.FILES_PATH + Constants.EXPORT_FILE_NAME + Constants.EXPORT_SEED_EXTENSION);
            printWriter.write(Constants.RANDOMIZER_DEFAULT_SEED);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
