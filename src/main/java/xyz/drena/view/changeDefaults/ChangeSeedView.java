package xyz.drena.view.changeDefaults;

import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import xyz.drena.controllers.defaultChanges.ChangeSeedController;
import xyz.drena.view.AbstractView;
import xyz.drena.view.tools.Messages;

public class ChangeSeedView extends AbstractView {

    private ChangeSeedController changeSeedController;

    public void setChangeSeedController(ChangeSeedController changeSeedController) { this.changeSeedController = changeSeedController; }

    @Override
    public void show() {
        askForInput();
    }

    private void askForInput() {
        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage(Messages.VIEW_SET_SEED_MESSAGE);
        scanner.setError(Messages.VIEW_SET_SEED_ERROR);
        changeSeedController.handleValue(prompt.getUserInput(scanner));
    }
}
