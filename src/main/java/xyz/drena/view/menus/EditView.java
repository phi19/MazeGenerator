package xyz.drena.view.menus;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import xyz.drena.controllers.menus.EditController;
import xyz.drena.services.PathsService;
import xyz.drena.view.AbstractView;
import xyz.drena.view.tools.Messages;

public class EditView extends AbstractView {

    private EditController editController;

    public void setEditController(EditController editController) { this.editController = editController; }

    @Override
    public void show() {
        showMenu();
    }

    private void showMenu() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(Messages.VIEW_FILENAME_MESSAGE);
        scanner.setError(Messages.VIEW_FILENAME_ERROR);
        editController.start(prompt.getUserInput(scanner));
    }
}
