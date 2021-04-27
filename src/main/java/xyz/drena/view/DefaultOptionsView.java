package xyz.drena.view;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import xyz.drena.controllers.DefaultOptionsController;

public class DefaultOptionsView extends AbstractView {

    private DefaultOptionsController defaultOptionsController;
    private final DoubleInputScanner scanner = new DoubleInputScanner();

    public void setMainController(DefaultOptionsController defaultOptionsController) { this.defaultOptionsController = defaultOptionsController; }

    @Override
    public void show() {
        showMenu();
    }

    private void showMenu() {
        MenuInputScanner mainMenu = new MenuInputScanner(DefaultsOptions.getMessages());
        mainMenu.setMessage(Messages.VIEW_DEFAULT_OPTIONS_MESSAGE);
        mainMenu.setError(Messages.VIEW_DEFAULT_OPTIONS_ERROR);
        handleOption(prompt.getUserInput(mainMenu));
    }

    public void handleOption(int optionNumber) {

        DefaultsOptions option = DefaultsOptions.values()[optionNumber - 1];

        switch(option) {
            case GO_BACK:
                return; // go to mainController
            case SET_ROWS:
                defaultOptionsController.changeDefault(option, true, askForLength(Messages.VIEW_SET_LENGTH_ROWS));
                break;
            case SET_COLUMNS:
                defaultOptionsController.changeDefault(option, true, askForLength(Messages.VIEW_SET_LENGTH_COLUMNS));
                break;
            case SET_SEED:
                defaultOptionsController.changeDefault(option, false, askForSeed());
                break;

        }
        defaultOptionsController.init();
    }

    private double askForLength(String lengthType) {
        scanner.setMessage(Messages.VIEW_SET_LENGTH_MESSAGE_PREFIX + lengthType + Messages.VIEW_SET_LENGTH_MESSAGE_SUFFIX);
        scanner.setError(Messages.VIEW_SET_LENGTH_ERROR);

        double result = prompt.getUserInput(scanner);

        if (result % 2 == 1) { return result; }

        System.out.println(Messages.VIEW_SET_LENGTH_ERROR);
        return askForLength(lengthType);
    }

    public double askForSeed() {
        scanner.setMessage(Messages.VIEW_MAIN_SEED_MESSAGE);
        scanner.setError(Messages.VIEW_MAIN_SEED_ERROR);
        return prompt.getUserInput(scanner);
    }
}
