package xyz.drena.exports;

import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class ExportToImage implements Exportable {

    @Override
    public void export(LinkedList<ExportUnits> exportUnits, String fileName) {

        BufferedImage bufferedImage = new BufferedImage(
                (int) Constants.GENERATOR_LAB_COLUMNS*Constants.EXPORT_VIEW_UNIT_SIZE,
                (int) Constants.GENERATOR_LAB_ROWS*Constants.EXPORT_VIEW_UNIT_SIZE,
                BufferedImage.TYPE_INT_RGB
        );

        paintUnit(bufferedImage, exportUnits);

        try {

            ImageIO.write(
                    bufferedImage,
                    Constants.EXPORT_IMAGE_EXTENSION.substring(1),
                    new File(Constants.FILES_MAZES_IMAGES_PATH + fileName + Constants.EXPORT_IMAGE_EXTENSION)
            );

        } catch (IOException ex) {

            System.out.println(Messages.SYSTEM_ERROR);
        }
    }

    private void paintUnit(BufferedImage bufferedImage, LinkedList<ExportUnits> exportUnits) {

        Graphics2D g2d = bufferedImage.createGraphics();

        for (ExportUnits exportUnit : exportUnits) {
            g2d.setColor(exportUnit.getGroundType().toJavaColor());
            g2d.fillRect(
                    exportUnit.getCol() * Constants.EXPORT_VIEW_UNIT_SIZE,
                    exportUnit.getRow() * Constants.EXPORT_VIEW_UNIT_SIZE,
                    Constants.EXPORT_VIEW_UNIT_SIZE,
                    Constants.EXPORT_VIEW_UNIT_SIZE
            );
        }

        g2d.dispose();

    }

    @Override
    public String getExportExtension() {
        return Constants.EXPORT_IMAGE_EXTENSION;
    }
}
