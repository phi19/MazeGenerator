package xyz.drena.LabGeneration.exports;

import xyz.drena.LabGeneration.MazeExport;
import xyz.drena.view.tools.Constants;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class ExportToImage extends AbstractExportable {

    @Override
    public void export(LinkedList<MazeExport.ExportUnits> exportUnits, String fileName) {

        BufferedImage bufferedImage = new BufferedImage(
                Constants.GENERATOR_LAB_COLUMNS*Constants.EXPORT_VIEW_UNIT_SIZE,
                Constants.GENERATOR_LAB_ROWS*Constants.EXPORT_VIEW_UNIT_SIZE,
                BufferedImage.TYPE_INT_RGB
        );

        Graphics2D g2d = bufferedImage.createGraphics();

        for (MazeExport.ExportUnits exportUnit : exportUnits) {

            g2d.setColor(exportUnit.getGroundType().toJavaColor());
            g2d.fillRect(
                    exportUnit.getCol() * Constants.EXPORT_VIEW_UNIT_SIZE,
                    exportUnit.getRow() * Constants.EXPORT_VIEW_UNIT_SIZE,
                    Constants.EXPORT_VIEW_UNIT_SIZE,
                    Constants.EXPORT_VIEW_UNIT_SIZE
            );
        }

        g2d.dispose();

        try {

            ImageIO.write(
                    bufferedImage,
                    Constants.EXPORT_IMAGE_EXTENSION.substring(1),
                    new File(Constants.FILES_MAZES_IMAGES_PATH + fileName + Constants.EXPORT_IMAGE_EXTENSION)
            );

        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }
}
