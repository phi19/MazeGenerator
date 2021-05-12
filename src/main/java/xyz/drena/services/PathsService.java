package xyz.drena.services;

import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class PathsService {

    public boolean canUseDataFolder() {
        return canUseFolder(Constants.DATA_DIRECTORY);
    }

    public boolean canUseDefaultsFolder() {
        return canUseFolder(Constants.DEFAULTS_DIRECTORY);
    }

    private boolean canUseFolder(File file) {
        return file.exists() || file.mkdir();
    }

    private boolean canUseFile(File file) {
        try {
            return file.exists() || file.createNewFile();
        } catch (IOException e) {
            System.out.println(Messages.SYSTEM_ERROR);
            return false;
        }
    }

    public boolean writeToFile(String text, File file) {
        if (!canUseFile(file)) {
            return false;
        }
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.write(text);
            printWriter.flush();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(Messages.SYSTEM_ERROR);
            return false;
        }
    }

    public String readFromFile(File file) {
        if (!canUseFile(file)) {
            return null;
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            StringBuilder fileData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileData.append(line).append("\n");
            }
            return fileData.toString();
        } catch (IOException ex) {
            System.out.println(Messages.SYSTEM_ERROR);
            return null;
        }
    }

}
