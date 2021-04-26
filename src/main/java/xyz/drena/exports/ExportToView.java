package xyz.drena.exports;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import xyz.drena.Main;
import xyz.drena.view.Constants;

import java.util.LinkedList;

public class ExportToView implements Exportable {

    @Override
    public void export(LinkedList<Main.ExportUnits> exportUnits) {

        exportUnits.forEach(exportUnit -> {
            Rectangle rectangle = new Rectangle(
                    Constants.VIEWER_PADDING + exportUnit.getCol()*Constants.VIEWER_UNIT_SIZE,
                    Constants.VIEWER_PADDING + exportUnit.getRow()*Constants.VIEWER_UNIT_SIZE,
                    Constants.VIEWER_UNIT_SIZE,
                    Constants.VIEWER_UNIT_SIZE
            );
            rectangle.setColor(exportUnit.getGroundType().getColor());
            rectangle.fill();
        });
    }
}
