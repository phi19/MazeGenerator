package xyz.drena;

import org.academiadecodigo.bootcamp.Prompt;
import xyz.drena.controllers.Controller;
import xyz.drena.controllers.defaultChanges.ChangeColumnsController;
import xyz.drena.controllers.defaultChanges.ChangeRowsController;
import xyz.drena.controllers.menus.DefaultsController;
import xyz.drena.controllers.menus.EditController;
import xyz.drena.controllers.menus.GenerationController;
import xyz.drena.controllers.menus.MainController;
import xyz.drena.exports.exportables.*;
import xyz.drena.exports.utils.ExportTypes;
import xyz.drena.services.PathsService;
import xyz.drena.maze.MazeAPI;
import xyz.drena.services.EditService;
import xyz.drena.services.ExportService;
import xyz.drena.view.changeDefaults.ChangeColumnsView;
import xyz.drena.view.changeDefaults.ChangeRowsView;
import xyz.drena.view.menuOptions.DefaultsOptions;
import xyz.drena.view.menuOptions.MainOptions;
import xyz.drena.view.menus.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        bootStrap().init();
    }

    private static Controller bootStrap() {

        // some initial independent properties && services
        Prompt prompt = new Prompt(System.in, System.out);
        MazeAPI mazeAPI = new MazeAPI();
        PathsService pathsService = new PathsService();
        ExportService exportService = new ExportService();
        EditService editService = new EditService();
        AbstractExportable exportToImage = new ExportToImage();
        AbstractExportable exportToJson = new ExportToJson();
        AbstractExportable exportToMaze = new ExportToMaze();
        AbstractExportable exportToSeed = new ExportToSeed();

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
        changeRowsController.setChangeDefaultsService(pathsService);
        // independent properties to changeColumnsVC
        changeColumnsView.setPrompt(prompt);
        changeColumnsController.setChangeDefaultsService(pathsService);
        // independent properties to editVC
        editView.setPrompt(prompt);
        editController.setEditService(editService);
        // independent properties to generationVC
        generationView.setPrompt(prompt);
        generationController.setMazeGenService(exportService);

        //independent properties to mazeGenService
        exportService.setPathsService(pathsService);
        exportService.setMazeGeneration(mazeAPI);

        //independent properties to editService
        editService.setMazeGeneration(mazeAPI);

        //independent properties to exportToImage
        exportToImage.setPathsService(pathsService);
        exportToImage.setMazeAPI(mazeAPI);
        exportToImage.setExportType(ExportTypes.TO_IMAGE);

        //independent properties to exportToJson
        exportToJson.setPathsService(pathsService);
        exportToJson.setMazeAPI(mazeAPI);
        exportToJson.setExportType(ExportTypes.TO_JSON);

        //independent properties to exportToMaze
        exportToMaze.setPathsService(pathsService);
        exportToMaze.setMazeAPI(mazeAPI);
        exportToMaze.setExportType(ExportTypes.TO_MAZE);

        //independent properties to exportToSeed
        exportToSeed.setPathsService(pathsService);
        exportToMaze.setMazeAPI(mazeAPI);
        exportToSeed.setExportType(ExportTypes.TO_SEED);

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
        Map<Integer, AbstractExportable> exportableMap = new HashMap<>();
        exportableMap.put(ExportTypes.TO_IMAGE.getOption(), exportToImage);
        exportableMap.put(ExportTypes.TO_JSON.getOption(), exportToJson);
        exportableMap.put(ExportTypes.TO_MAZE.getOption(), exportToMaze);
        exportableMap.put(ExportTypes.TO_SEED.getOption(), exportToSeed);

        generationController.setExportTypesMap(exportableMap);

        return mainController;
    }
}
