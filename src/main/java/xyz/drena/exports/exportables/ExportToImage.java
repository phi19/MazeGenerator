package xyz.drena.exports.exportables;

import xyz.drena.exports.utils.ExportUnits;
import xyz.drena.view.tools.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class ExportToImage extends AbstractExportable {

    @Override
    public void export(String fileName) {

        BufferedImage bufferedImage = getImage();

        paintUnits(bufferedImage, exportUnits);

        pathsService.writeToImage(bufferedImage, getFormatName(), getFile(fileName));
    }

    private BufferedImage getImage() {
        return new BufferedImage(
                getCols()*Constants.EXPORT_VIEW_UNIT_SIZE,
                getRows()*Constants.EXPORT_VIEW_UNIT_SIZE,
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

    private int getRows() {
        return -1;
    }

    private int getCols() {
        return -1;
    }

    private String getFormatName() {
        return exportType.getExtension().substring(1);
    }
}
