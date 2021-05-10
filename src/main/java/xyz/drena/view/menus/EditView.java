package xyz.drena.view.menus;

import xyz.drena.controllers.menus.EditController;
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
        editController.start();
    }
}
