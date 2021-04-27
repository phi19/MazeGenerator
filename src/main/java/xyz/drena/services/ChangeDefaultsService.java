package xyz.drena.services;

import xyz.drena.view.Constants;

import java.io.*;

public class ChangeDefaultsService {

    private PrintWriter printWriter;

    private void writeIn(String path) {
        try {
            printWriter = new PrintWriter(Constants.FILES_DEFAULTS_PATH + path + Constants.FILES_DEFAULTS_EXTENSION);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public void changeDefault(String file, boolean parsedToInt, double lengthValue) {
        writeIn(file);
        String valueToWrite = parsedToInt ? String.valueOf((int) lengthValue) : String.valueOf(lengthValue);
        printWriter.write(valueToWrite);
        printWriter.flush();
        printWriter.close();

    }
}
