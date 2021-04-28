package xyz.drena;

import org.academiadecodigo.bootcamp.Prompt;
import xyz.drena.controllers.Controller;
import xyz.drena.controllers.defaultChanges.ChangeColumnsController;
import xyz.drena.controllers.defaultChanges.ChangeRowsController;
import xyz.drena.controllers.defaultChanges.ChangeSeedController;
import xyz.drena.controllers.menus.DefaultsController;
import xyz.drena.controllers.menus.EditController;
import xyz.drena.controllers.menus.ExportController;
import xyz.drena.controllers.menus.MainController;
import xyz.drena.services.ChangeDefaultsService;
import xyz.drena.services.LabGenService;
import xyz.drena.view.changeDefaults.ChangeColumnsView;
import xyz.drena.view.changeDefaults.ChangeRowsView;
import xyz.drena.view.changeDefaults.ChangeSeedView;
import xyz.drena.view.menuOptions.DefaultsOptions;
import xyz.drena.view.menuOptions.MainOptions;
import xyz.drena.view.menus.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.bootStrap();

    }

    private void bootStrap() {

        // some initial independent properties && services
        Prompt prompt = new Prompt(System.in, System.out);
        ChangeDefaultsService changeDefaultsService = new ChangeDefaultsService();
        LabGenService labGenService = new LabGenService();

        // mainVC
        MainView mainView = new MainView();
        MainController mainController = new MainController();
        mainView.setMainController(mainController);
        mainController.setView(mainView);

        // changeDefaultsVC
        DefaultsView defaultsMenuView = new DefaultsView();
        DefaultsController defaultsController = new DefaultsController();
        defaultsMenuView.setMainController(defaultsController);
        defaultsController.setView(defaultsMenuView);

        // changeRowsVC
        ChangeRowsView changeRowsView = new ChangeRowsView();
        ChangeRowsController changeRowsController = new ChangeRowsController();
        changeRowsView.setChangeLengthController(changeRowsController);
        changeRowsController.setView(changeRowsView);

        // changeColumnsVC
        ChangeColumnsView changeColumnsView = new ChangeColumnsView();
        ChangeColumnsController changeColumnsController = new ChangeColumnsController();
        changeColumnsView.setChangeLengthController(changeColumnsController);
        changeColumnsController.setView(changeColumnsView);

        // changeSeedVC
        ChangeSeedView changeSeedView = new ChangeSeedView();
        ChangeSeedController changeSeedController = new ChangeSeedController();
        changeSeedView.setChangeSeedController(changeSeedController);
        changeSeedController.setView(changeSeedView);

        // editMazeVC
        EditView editView = new EditView();
        EditController editController = new EditController();
        editView.setEditController(editController);
        editController.setView(editView);

        // exportMazeVC
        ExportView exportView = new ExportView();
        ExportController exportController = new ExportController();
        exportView.setExportController(exportController);
        exportController.setView(exportView);

        // independent properties to mainVC
        mainView.setPrompt(prompt);
        // independent properties to changeDefaultsVC
        defaultsMenuView.setPrompt(prompt);
        // independent properties to changeRowsVC
        changeRowsView.setPrompt(prompt);
        changeRowsController.setChangeDefaultsService(changeDefaultsService);
        // independent properties to changeColumnsVC
        changeColumnsView.setPrompt(prompt);
        changeColumnsController.setChangeDefaultsService(changeDefaultsService);
        // independent properties to changeSeedVC
        changeSeedView.setPrompt(prompt);
        changeSeedController.setChangeDefaultsService(changeDefaultsService);
        // independent properties to editMazeVC
        editView.setPrompt(prompt);
        // independent properties to exportMazeVC
        editView.setPrompt(prompt);
        exportController.setLabGenService(labGenService);

        // setup the mainMenuController map
        Map<Integer, Controller> mainControllerMap = new HashMap<>();
        mainControllerMap.put(MainOptions.CHANGE_DEFAULTS.getOption(), defaultsController);
        mainControllerMap.put(MainOptions.EDIT_MAZE.getOption(), editController);
        mainControllerMap.put(MainOptions.EXPORT_MAZE.getOption(), exportController);

        mainController.setControllerMap(mainControllerMap);

        // setup the changeDefaultsController map
        Map<Integer, Controller> defaultsControllerMap = new HashMap<>();
        defaultsControllerMap.put(DefaultsOptions.SET_ROWS.getOption(), changeRowsController);
        defaultsControllerMap.put(DefaultsOptions.SET_COLUMNS.getOption(), changeColumnsController);
        defaultsControllerMap.put(DefaultsOptions.SET_SEED.getOption(), changeSeedController);

        defaultsController.setControllerMap(defaultsControllerMap);

        mainController.init();
    }
}
