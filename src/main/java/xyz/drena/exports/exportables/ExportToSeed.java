package xyz.drena.exports.exportables;

import xyz.drena.view.tools.Constants;
import java.io.*;

public class ExportToSeed extends AbstractExportable {

    @Override
    public void export(String fileName) {
        try {
            PrintWriter printWriter = new PrintWriter(getFile(fileName));
            printWriter.write(Constants.RANDOMIZER_DEFAULT_SEED);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
