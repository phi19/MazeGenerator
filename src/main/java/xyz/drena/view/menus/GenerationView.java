package xyz.drena.view.menus;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import xyz.drena.exports.utils.ExportTypes;
import xyz.drena.controllers.menus.GenerationController;
import xyz.drena.view.AbstractView;
import xyz.drena.view.tools.Messages;

public class GenerationView extends AbstractView {

    private GenerationController generationController;

    public void setGenerationController(GenerationController generationController) { this.generationController = generationController; }

    @Override
    public void show() {
        generationController.handleInput(scanFileName(), scanAmountMazes(), scanExportType());
    }

    private int scanAmountMazes() {
        IntegerInputScanner scanner = new IntegerInputScanner();
        scanner.setMessage(Messages.VIEW_NUMBER_MAZES_MESSAGE);
        scanner.setError(Messages.VIEW_NUMBER_MAZES_ERROR);
        return prompt.getUserInput(scanner);
    }

    private String scanFileName() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(Messages.VIEW_FILENAME_MESSAGE);
        scanner.setError(Messages.VIEW_FILENAME_ERROR);
        return prompt.getUserInput(scanner);
    }

    private int scanExportType() {
        MenuInputScanner scanner = new MenuInputScanner(ExportTypes.getMessages());
        scanner.setMessage(Messages.VIEW_EXPORT_MESSAGE);
        scanner.setError(Messages.VIEW_EXPORT_ERROR);
        return prompt.getUserInput(scanner);
    }
}
