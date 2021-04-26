package xyz.drena.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import xyz.drena.controllers.MainController;

public class MainView extends AbstractView {

    private MainController mainController;
    private IntegerInputScanner integerScanner = new IntegerInputScanner();

    public void setMainController(MainController mainController) { this.mainController = mainController; }

    @Override
    public void show() {
        showMenu();
    }

    private void showMenu() {
        MenuInputScanner mainMenu = new MenuInputScanner(MainOptions.getMessages());
        mainMenu.setMessage(Messages.VIEW_MAIN_MESSAGE);
        mainMenu.setError(Messages.VIEW_MAIN_ERROR);
        handleOption(prompt.getUserInput(mainMenu));
    }

    private void handleOption(int option) {

        switch(MainOptions.values()[option - 1]) {
            case SET_ROWS:
                askForRows();
                break;
            case SET_COLUMNS:
                askForColumns();
                break;
            case SET_SEED:
                askForSeed();
                break;
            case GENERATE_MAZE:
                generateMaze();
                break;
        }
    }

    private String getLengthMessage(String length) {
        return Messages.VIEW_MAIN_LENGTH_MESSAGE_PREFIX + length + Messages.VIEW_MAIN_LENGTH_MESSAGE_SUFFIX;
    }

    private void askForRows() {
        integerScanner.setMessage(getLengthMessage(Messages.VIEW_MAIN_LENGTH_MESSAGE_ROWS));
        int totalRows = askForLength();
        mainController.init();
    }

    private void askForColumns() {
        integerScanner.setMessage(getLengthMessage(Messages.VIEW_MAIN_LENGTH_MESSAGE_COLUMNS));
        int totalColumns = askForLength();
        mainController.init();
    }

    private int askForLength() {
        integerScanner.setError(Messages.VIEW_MAIN_LENGTH_ERROR);
        int result = prompt.getUserInput(integerScanner);

        if (result % 2 == 1) { return result; }

        System.out.println(Messages.VIEW_MAIN_LENGTH_ERROR);
        return askForLength();
    }

    private void askForSeed() {
        integerScanner.setMessage(Messages.VIEW_MAIN_SEED_MESSAGE);
        integerScanner.setError(Messages.VIEW_MAIN_SEED_ERROR);
        int seed = prompt.getUserInput(integerScanner);
        mainController.init();
    }

    private void generateMaze() {
        mainController.generateLab();
    }
}
