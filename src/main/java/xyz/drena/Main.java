package xyz.drena;

import org.academiadecodigo.bootcamp.Prompt;
import xyz.drena.controllers.ExportController;
import xyz.drena.controllers.DefaultOptionsController;
import xyz.drena.controllers.MainController;
import xyz.drena.services.ChangeDefaultsService;
import xyz.drena.services.LabGenService;
import xyz.drena.view.ExportView;
import xyz.drena.view.DefaultOptionsView;
import xyz.drena.view.MainView;

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

        // independent properties to mainVC
        mainController.setLabGenService(labGenService);
        mainView.setPrompt(prompt);

        // changeDefaultsVC
        DefaultOptionsView defaultOptionsView = new DefaultOptionsView();
        DefaultOptionsController defaultOptionsController = new DefaultOptionsController();
        defaultOptionsView.setMainController(defaultOptionsController);
        defaultOptionsController.setView(defaultOptionsView);

        // independent properties to changeDefaultsVC
        defaultOptionsController.setChangeDefaultsService(changeDefaultsService);
        defaultOptionsView.setPrompt(prompt);

        // mainVC to defaultOptionsController
        mainController.setDefaultOptionsController(defaultOptionsController);

        /*
        // exportVC

        ExportView exportView = new ExportView();
        ExportController exportController = new ExportController();
        exportController.setView(exportView);
        exportView.setExportController(exportController);

        // independent properties to exportVC

        exportController.setLabGenService(labGenService);
         */

        //mainController.init();
        mainController.init();
    }
}
