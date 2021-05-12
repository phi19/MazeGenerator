package xyz.drena;

import xyz.drena.services.PathsService;
import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

import java.io.File;
import java.io.PrintWriter;

public class Setup {

    public static void main(String[] args) {
        PathsService pathsService = new PathsService();
        if (!pathsService.canUseDataFolder() || !pathsService.canUseDefaultsFolder()) {
            System.out.println(Messages.SYSTEM_ERROR);
        }

        System.out.println(Double.parseDouble(pathsService.readFromFile(Constants.DEFAULT_ROWS_FILE)));
    }
}
