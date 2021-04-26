package xyz.drena.exports;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import xyz.drena.controllers.ExportController;
import xyz.drena.controllers.MainController;
import xyz.drena.view.Constants;

import java.util.LinkedList;

public class ExportToView implements Exportable {

    @Override
    public void export(LinkedList<ExportController.ExportUnits> exportUnits) {

        exportUnits.forEach(exportUnit -> {
            Rectangle rectangle = new Rectangle(
                    Constants.VIEWER_PADDING + exportUnit.getCol()*getViewerUnitSize(),
                    Constants.VIEWER_PADDING + exportUnit.getRow()*getViewerUnitSize(),
                    getViewerUnitSize(),
                    getViewerUnitSize()
            );
            rectangle.setColor(exportUnit.getGroundType().getColor());
            rectangle.fill();
        });
    }

    private int getViewerUnitSize() {
        if (Constants.VIEWER_DEFAULT_UNIT_SIZE * Constants.GENERATOR_LAB_ROWS > Constants.VIEWER_MAXIMUM_HEIGHT) {
            return Constants.VIEWER_MAXIMUM_HEIGHT / Constants.GENERATOR_LAB_ROWS;
        } else {
            return Constants.VIEWER_DEFAULT_UNIT_SIZE;
        }
    }
}
