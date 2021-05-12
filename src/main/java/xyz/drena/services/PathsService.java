package xyz.drena.services;

import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class PathsService {

    public boolean canUseDataFolder() {
        return Constants.DATA_DIRECTORY.exists() || Constants.DATA_DIRECTORY.mkdir();
    }

    public boolean canUseDefaultsFolder() {
        return Constants.DEFAULTS_DIRECTORY.exists() || Constants.DEFAULTS_DIRECTORY.mkdir();
    }

    public boolean canUseRowsFile() {
        try {
            return Constants.DEFAULT_ROWS_FILE.exists() || Constants.DEFAULT_ROWS_FILE.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public boolean canUseColumnsFile() {
        try {
            return Constants.DEFAULT_COLUMNS_FILE.exists() || Constants.DEFAULT_COLUMNS_FILE.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public boolean setDefaultRows(double value) {
        if (!canUseRowsFile()) {
            return false;
        }
        return setDefaultLength(value, Constants.DEFAULT_ROWS_FILE);
    }

    public boolean setDefaultColumns(double value) {
        if (!canUseColumnsFile()) {
            return false;
        }
        return setDefaultLength(value, Constants.DEFAULT_COLUMNS_FILE);
    }

    private boolean setDefaultLength(double value, File file) {
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.write(Double.toString(value));
            printWriter.flush();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(Messages.SYSTEM_ERROR);
            return false;
        }
    }
}
