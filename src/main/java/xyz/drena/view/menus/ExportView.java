package xyz.drena.view.menus;

import xyz.drena.controllers.menus.ExportController;
import xyz.drena.view.AbstractView;
import xyz.drena.view.tools.Messages;

public class ExportView extends AbstractView {

    private ExportController exportController;

    public void setExportController(ExportController exportController) { this.exportController = exportController; }

    @Override
    public void show() {
        showMenu();
    }

    private void showMenu() {
        System.out.println(Messages.MAINTENANCE_ERROR);
    }

}
