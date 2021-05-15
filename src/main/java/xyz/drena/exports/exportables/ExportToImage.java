package xyz.drena.exports.exportables;

import xyz.drena.view.tools.Constants;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ExportToImage extends AbstractExportable {

    @Override
    public void export(String fileName) {

        BufferedImage bufferedImage = getImage();

        paintUnits(bufferedImage);

        pathsService.writeToImage(bufferedImage, getFormatName(), getFile(fileName));
    }

    private BufferedImage getImage() {
        return new BufferedImage(
                mazeAPI.getColumns()*Constants.EXPORT_IMAGE_UNIT_SIZE,
                mazeAPI.getRows()*Constants.EXPORT_IMAGE_UNIT_SIZE,
                BufferedImage.TYPE_INT_RGB
        );
    }

    private void paintUnits(BufferedImage bufferedImage) {

        Graphics2D g2d = bufferedImage.createGraphics();

        getExportUnits().forEach(exportUnit -> {
            g2d.setColor(exportUnit.getGroundType().toJavaColor());
            g2d.fillRect(
                    exportUnit.getCol() * Constants.EXPORT_IMAGE_UNIT_SIZE,
                    exportUnit.getRow() * Constants.EXPORT_IMAGE_UNIT_SIZE,
                    Constants.EXPORT_IMAGE_UNIT_SIZE,
                    Constants.EXPORT_IMAGE_UNIT_SIZE
            );
        });

        g2d.dispose();
    }

    private String getFormatName() {
        return exportType.getExtension().substring(1);
    }
}
