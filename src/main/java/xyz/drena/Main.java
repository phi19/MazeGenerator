package xyz.drena;

import org.academiadecodigo.bootcamp.Prompt;
import xyz.drena.controllers.Controller;
import xyz.drena.controllers.defaultChanges.ChangeColumnsController;
import xyz.drena.controllers.defaultChanges.ChangeRowsController;
import xyz.drena.controllers.menus.DefaultsController;
import xyz.drena.controllers.menus.EditController;
import xyz.drena.controllers.menus.GenerationController;
import xyz.drena.controllers.menus.MainController;
import xyz.drena.exports.*;
import xyz.drena.services.ChangeDefaultsService;
import xyz.drena.LabGeneration.MazeGeneration;
import xyz.drena.services.MazeExportService;
import xyz.drena.view.changeDefaults.ChangeColumnsView;
import xyz.drena.view.changeDefaults.ChangeRowsView;
import xyz.drena.view.menuOptions.DefaultsOptions;
import xyz.drena.view.menuOptions.MainOptions;
import xyz.drena.view.menus.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Controller mainController = main.bootStrap();
        mainController.init();

    }

    private Controller bootStrap() {

        // some initial independent properties && services
        Prompt prompt = new Prompt(System.in, System.out);
        ChangeDefaultsService changeDefaultsService = new ChangeDefaultsService();
        MazeExportService mazeExportService = new MazeExportService();
        MazeGeneration mazeGeneration = new MazeGeneration();

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

        // editMazeVC
        EditView editView = new EditView();
        EditController editController = new EditController();
        editView.setEditController(editController);
        editController.setView(editView);

        // exportMazeVC
        GenerationView generationView = new GenerationView();
        GenerationController generationController = new GenerationController();
        generationView.setGenerationController(generationController);
        generationController.setView(generationView);

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
        // independent properties to editVC
        editView.setPrompt(prompt);
        // independent properties to generationVC
        generationView.setPrompt(prompt);
        generationController.setMazeGenService(mazeExportService);

        //independent properties to mazeGenService
        mazeExportService.setMazeGeneration(mazeGeneration);

        // setup the mainMenuController map
        Map<Integer, Controller> mainControllerMap = new HashMap<>();
        mainControllerMap.put(MainOptions.CHANGE_DEFAULTS.getOption(), defaultsController);
        mainControllerMap.put(MainOptions.GENERATE_MAZES.getOption(), generationController);
        mainControllerMap.put(MainOptions.EDIT_MAZE.getOption(), editController);

        mainController.setControllerMap(mainControllerMap);

        // setup the changeDefaultsController map
        Map<Integer, Controller> defaultsControllerMap = new HashMap<>();
        defaultsControllerMap.put(DefaultsOptions.SET_ROWS.getOption(), changeRowsController);
        defaultsControllerMap.put(DefaultsOptions.SET_COLUMNS.getOption(), changeColumnsController);

        defaultsController.setControllerMap(defaultsControllerMap);

        // setup the exportTypes map
        Map<Integer, Exportable> exportableMap = new HashMap<>();
        exportableMap.put(ExportTypes.TO_JSON.getOption(), new ExportToJson());
        exportableMap.put(ExportTypes.TO_IMAGE.getOption(), new ExportToImage());
        exportableMap.put(ExportTypes.TO_LAB.getOption(), new ExportToLab());
        exportableMap.put(ExportTypes.TO_SEED.getOption(), new ExportToSeed());

        generationController.setExportTypesMap(exportableMap);

        return mainController;
    }
}
