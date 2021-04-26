package xyz.drena.exports;

import xyz.drena.controllers.MainController;
import xyz.drena.view.Constants;
import java.io.*;
import java.util.LinkedList;

public class ExportToSeed implements Exportable {

    @Override
    public void export(LinkedList<MainController.ExportUnits> exportUnits) {

        try {

            PrintWriter printWriter = new PrintWriter(Constants.FILES_EXPORT_PATH + Constants.FILE_EXPORT_NAME + Constants.EXPORT_SEED_EXTENSION);
            printWriter.write(Constants.RANDOMIZER_DEFAULT_SEED);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
