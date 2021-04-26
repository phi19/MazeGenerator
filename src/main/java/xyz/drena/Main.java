package xyz.drena;

import org.academiadecodigo.bootcamp.Prompt;
import xyz.drena.controllers.ExportController;
import xyz.drena.controllers.MainController;
import xyz.drena.generator.GroundType;
import xyz.drena.generator.Position;
import xyz.drena.view.Constants;
import xyz.drena.view.ExportView;
import xyz.drena.view.MainView;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.bootStrap();

    }

    private void bootStrap() {

        // some initial independent properties

        Prompt prompt = new Prompt(System.in, System.out);
        Flow flow = new Flow();

        // main VC

        MainView mainView = new MainView();
        MainController mainController = new MainController();
        mainController.setView(mainView);
        mainView.setMainController(mainController);

        // independent properties to main VC

        mainController.setFlow(flow);
        mainView.setPrompt(prompt);

        // export VC

        ExportView exportView = new ExportView();
        ExportController exportController = new ExportController();
        exportController.setView(exportView);
        exportView.setExportController(exportController);

        // independent properties to export VC

        exportController.setFlow(flow);

        // nextController from mainVC to exportVC
        mainController.setNextController(exportController);

        mainController.init();
    }
}
