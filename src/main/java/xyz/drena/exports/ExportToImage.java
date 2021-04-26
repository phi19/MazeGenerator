package xyz.drena.exports;

import xyz.drena.controllers.ExportController;
import xyz.drena.controllers.MainController;
import xyz.drena.view.Constants;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class ExportToImage implements Exportable {

    @Override
    public void export(LinkedList<ExportController.ExportUnits> exportUnits) {

        BufferedImage bufferedImage = new BufferedImage(
                Constants.GENERATOR_LAB_COLUMNS*Constants.EXPORT_VIEW_UNIT_SIZE,
                Constants.GENERATOR_LAB_ROWS*Constants.EXPORT_VIEW_UNIT_SIZE,
                BufferedImage.TYPE_INT_RGB
        );

        Graphics2D g2d = bufferedImage.createGraphics();

        exportUnits.forEach(exportUnit -> {
            g2d.setColor(exportUnit.getGroundType().toJavaColor());
            g2d.fillRect(
                    exportUnit.getCol()*Constants.EXPORT_VIEW_UNIT_SIZE,
                    exportUnit.getRow()*Constants.EXPORT_VIEW_UNIT_SIZE,
                    Constants.EXPORT_VIEW_UNIT_SIZE,
                    Constants.EXPORT_VIEW_UNIT_SIZE
            );
        });

        g2d.dispose();

        try {

            ImageIO.write(
                    bufferedImage,
                    Constants.EXPORT_IMAGE_EXTENSION.substring(1),
                    new File(Constants.FILES_EXPORT_PATH + Constants.FILE_EXPORT_NAME + Constants.EXPORT_IMAGE_EXTENSION)
            );

        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }
}
