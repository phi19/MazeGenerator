package xyz.drena.services;

import xyz.drena.view.tools.Messages;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class PathsService {

    private boolean canUseFolder(File file) {
        while (!(file.exists() || file.mkdir())) {
            canUseFolder(new File(file.getParent()));
        }
        return true;
    }

    private boolean canUseFile(File file) {
        while (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    canUseFolder(new File(file.getParent()));
                }
            } catch (IOException e) {
                canUseFolder(new File(file.getParent()));
            }
        }
        return true;
    }

    public boolean writeToFile(File file, String text) {
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

    public boolean writeToImage(BufferedImage bufferedImage, String formatName, File file) {
        if (!canUseFile(file)) {
            return false;
        }
        try {
            ImageIO.write(bufferedImage, formatName, file);
            return true;
        } catch (IOException ex) {
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

    public String[] getDirectoryList(File directory) {
        if (!canUseFolder(directory)) {
            return null;
        }
        return directory.list();
    }

}
