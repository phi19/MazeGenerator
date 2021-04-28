package xyz.drena.services;

import xyz.drena.view.tools.Constants;

import java.io.*;

public class ChangeDefaultsService {

    private PrintWriter printWriter;

    public void changeDefault(double lengthValue, String file) {
        writeIn(file);
        String valueToWrite = String.valueOf(lengthValue);
        printWriter.write(valueToWrite);
        printWriter.flush();
        printWriter.close();
    }

    private void writeIn(String path) {
        try {
            printWriter = new PrintWriter(Constants.FILES_DEFAULTS_PATH + path + Constants.FILES_DEFAULTS_EXTENSION);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
