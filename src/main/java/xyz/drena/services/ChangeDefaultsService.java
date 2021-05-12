package xyz.drena.services;

import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

import java.io.*;

public class ChangeDefaultsService {

    public void changeDefault(double lengthValue, String fileName) {

        PrintWriter printWriter;

        try {
            printWriter = new PrintWriter(fileName);
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
