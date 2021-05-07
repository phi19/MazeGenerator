package xyz.drena.LabGeneration.exports;

import xyz.drena.LabGeneration.MazeExport;
import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ExportToLab extends AbstractExportable {

    @Override
    public void export(LinkedList<MazeExport.ExportUnits> exportUnits, String fileName) {

        test(fileName);
    }

    private void test(String fileName) {
        List<String> srcFiles = Arrays.asList(
                Constants.FILES_MAZES_COORDINATES_PATH + fileName + Constants.EXPORT_SEED_EXTENSION,
                Constants.FILES_MAZES_COORDINATES_PATH + fileName + Constants.EXPORT_JSON_EXTENSION
        );

        try {

            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(fileName + Constants.EXPORT_LAB_EXTENSION));

            for (String srcFile : srcFiles) {
                File fileToZip = new File(srcFile);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                fis.close();
            }

        } catch (IOException ex) {
            System.out.println(Messages.SYSTEM_ERROR);
        }
    }
}
