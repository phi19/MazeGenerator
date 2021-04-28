package xyz.drena.view.menus;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import xyz.drena.controllers.menus.DefaultsController;
import xyz.drena.view.AbstractView;
import xyz.drena.view.tools.Messages;
import xyz.drena.view.menuOptions.DefaultsOptions;

public class DefaultsView extends AbstractView {

    private DefaultsController defaultsController;

    public void setMainController(DefaultsController defaultsController) { this.defaultsController = defaultsController; }

    @Override
    public void show() {
        showMenu();
    }

    private void showMenu() {
        MenuInputScanner mainMenu = new MenuInputScanner(DefaultsOptions.getMessages());
        mainMenu.setMessage(Messages.VIEW_DEFAULTS_MESSAGE);
        mainMenu.setError(Messages.VIEW_DEFAULTS_ERROR);
        defaultsController.handleOption(prompt.getUserInput(mainMenu));
    }
}
