package xyz.drena.exports;

import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class ExportToImage extends AbstractExportable {

    @Override
    public void export(LinkedList<ExportUnits> exportUnits, String fileName) {

        BufferedImage bufferedImage = getImage();

        paintUnits(bufferedImage, exportUnits);

        pathsService.writeToImage(bufferedImage, getFormatName(), getFile(fileName));
    }

    private BufferedImage getImage() {
        return new BufferedImage(
                (int) Constants.GENERATOR_LAB_COLUMNS*Constants.EXPORT_VIEW_UNIT_SIZE,
                (int) Constants.GENERATOR_LAB_ROWS*Constants.EXPORT_VIEW_UNIT_SIZE,
                BufferedImage.TYPE_INT_RGB
        );
    }

    private void paintUnits(BufferedImage bufferedImage, LinkedList<ExportUnits> exportUnits) {

        Graphics2D g2d = bufferedImage.createGraphics();

        exportUnits.forEach(exportUnit -> {
            g2d.setColor(exportUnit.getGroundType().toJavaColor());
            g2d.fillRect(
                    exportUnit.getCol() * Constants.EXPORT_VIEW_UNIT_SIZE,
                    exportUnit.getRow() * Constants.EXPORT_VIEW_UNIT_SIZE,
                    Constants.EXPORT_VIEW_UNIT_SIZE,
                    Constants.EXPORT_VIEW_UNIT_SIZE
            );
        });

        g2d.dispose();
    }

    private String getFormatName() {
        return exportType.getExtension().substring(1);
    }
}
