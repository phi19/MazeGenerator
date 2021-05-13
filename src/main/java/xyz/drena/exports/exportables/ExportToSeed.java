package xyz.drena.exports.exportables;

import xyz.drena.exports.utils.ExportUnits;
import xyz.drena.view.tools.Constants;
import java.io.*;
import java.util.LinkedList;

public class ExportToSeed extends AbstractExportable {

    @Override
    public void export(LinkedList<ExportUnits> exportUnits, String fileName) {
        try {
            PrintWriter printWriter = new PrintWriter(getFile(fileName));
            printWriter.write(Constants.RANDOMIZER_DEFAULT_SEED);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
