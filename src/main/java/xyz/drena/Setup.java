package xyz.drena;

import xyz.drena.services.PathsService;
import xyz.drena.services.PathsService.*;
import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

public class Setup {

    public static void main(String[] args) {
        PathsService pathsService = new PathsService();
        if (!pathsService.canUseDataFolder() || !pathsService.canUseDefaultsFolder()) {
            System.out.println(Messages.SYSTEM_ERROR);
            return;
        }

        if (pathsService.canUseRowsFile()) {
            System.out.println("You can use rows file!");
        }

        if (pathsService.canUseColumnsFile()) {
            System.out.println("You can use columns file!");
        }
    }
}
