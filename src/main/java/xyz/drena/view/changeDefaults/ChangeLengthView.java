package xyz.drena.view.changeDefaults;

import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import xyz.drena.controllers.defaultChanges.ChangeLengthController;
import xyz.drena.view.AbstractView;
import xyz.drena.view.tools.Messages;

public abstract class ChangeLengthView extends AbstractView {

    private ChangeLengthController changeLengthController;

    public void setChangeLengthController(ChangeLengthController changeLengthController) { this.changeLengthController = changeLengthController; }

    protected void askForInput(String mainMessage) {
        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage(mainMessage);
        scanner.setError(Messages.VIEW_SET_LENGTH_ERROR);
        changeLengthController.handleValue(prompt.getUserInput(scanner));
    }
}
