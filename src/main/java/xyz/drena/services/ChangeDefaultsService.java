package xyz.drena.services;

import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

import java.io.*;

public class ChangeDefaultsService {

    private PrintWriter printWriter;

    public void changeDefault(double lengthValue, String file) {
        try {
            printWriter = new PrintWriter(Constants.FILES_DEFAULTS_PATH + file + Constants.FILES_DEFAULTS_EXTENSION);
        } catch (FileNotFoundException exception) {
            System.out.println(Messages.SYSTEM_ERROR);
            return;
        }

        String valueToWrite = String.valueOf(lengthValue);
        printWriter.write(valueToWrite);
        printWriter.flush();
        printWriter.close();
    }
}
