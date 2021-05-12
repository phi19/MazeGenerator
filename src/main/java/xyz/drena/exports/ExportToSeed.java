package xyz.drena.exports;

import xyz.drena.view.tools.Constants;
import java.io.*;
import java.util.LinkedList;

public class ExportToSeed implements Exportable {

    @Override
    public void export(LinkedList<ExportUnits> exportUnits, String fileName) {
        try {
            PrintWriter printWriter = new PrintWriter(Constants.EXPORT_SEEDS_PATH + fileName + Constants.EXPORT_SEED_EXTENSION);
            printWriter.write(Constants.RANDOMIZER_DEFAULT_SEED);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getExportExtension() {
        return Constants.EXPORT_SEED_EXTENSION;
    }

}
