package xyz.drena.view.menus;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import xyz.drena.controllers.menus.GenerationController;
import xyz.drena.view.AbstractView;
import xyz.drena.view.tools.Messages;

public class GenerationView extends AbstractView {

    private GenerationController generationController;

    public void setGenerationController(GenerationController generationController) { this.generationController = generationController; }

    @Override
    public void show() {
        askForInput();
    }

    private void askForInput() {
        IntegerInputScanner scanner = new IntegerInputScanner();
        scanner.setMessage(Messages.VIEW_NUMBER_MAZES_MESSAGE);
        scanner.setError(Messages.VIEW_NUMBER_MAZES_ERROR);
        generationController.handleValue(prompt.getUserInput(scanner));

    }

}
