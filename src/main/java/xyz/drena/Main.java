package xyz.drena;

import org.academiadecodigo.bootcamp.Prompt;
import xyz.drena.controllers.MainController;
import xyz.drena.generator.GroundType;
import xyz.drena.generator.Position;
import xyz.drena.view.Constants;
import xyz.drena.view.MainView;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.bootStrap();

    }

    private void bootStrap() {
        MainView mainView = new MainView();
        MainController mainController = new MainController();
        mainController.setView(mainView);
        mainView.setMainController(mainController);
        mainView.setPrompt(new Prompt(System.in, System.out));
        mainController.init();
    }
}
