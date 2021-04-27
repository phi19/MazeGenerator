package xyz.drena.view;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import xyz.drena.controllers.MainController;

public class MainView extends AbstractView {

    private MainController mainController;

    public void setMainController(MainController mainController) { this.mainController = mainController; }

    @Override
    public void show() {
        showMenu();
    }

    private void showMenu() {
        MenuInputScanner mainMenu = new MenuInputScanner(MainOptions.getMessages());
        mainMenu.setMessage(Messages.VIEW_MAIN_MESSAGE);
        mainMenu.setError(Messages.VIEW_MAIN_ERROR);
        mainController.handleOption(prompt.getUserInput(mainMenu));
    }
}
