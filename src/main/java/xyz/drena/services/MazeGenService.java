package xyz.drena.services;

import xyz.drena.LabGeneration.MazeExport;
import xyz.drena.LabGeneration.MazeGeneration;
import xyz.drena.LabGeneration.exports.ExportTypes;
import xyz.drena.view.tools.Constants;
import java.io.File;
import java.util.*;
import java.util.stream.IntStream;

public class MazeGenService {

    private MazeGeneration mazeGeneration;
    private MazeExport mazeExport;

    public void setMazeGeneration(MazeGeneration mazeGeneration) { this.mazeGeneration = mazeGeneration; }

    public void setMazeExport(MazeExport mazeExport) { this.mazeExport = mazeExport; }

    public void generate(int option, String fileNamePrefix) {

        generateImages(option, fileNamePrefix);

        generateSeeds(option, fileNamePrefix);

        generateJSONs(option, fileNamePrefix);
    }

    private void generateImages(int option, String fileNamePrefix) {

        new File(Constants.FILES_MAZES_IMAGES_PATH).mkdir();
        String[] imagesFilesArray = new File(Constants.FILES_MAZES_IMAGES_PATH).list();

        int finalImageSaved = Arrays.stream(imagesFilesArray)
                .filter(file -> file.matches(fileNamePrefix + "[0-9]+" + Constants.EXPORT_IMAGE_EXTENSION))
                .map(file -> file.replace(fileNamePrefix, ""))
                .map(file -> file.replace(Constants.EXPORT_IMAGE_EXTENSION, ""))
                .map(Integer::parseInt)
                .max(Integer::compare)
                .orElse(0);

        IntStream.range(1 + finalImageSaved, 1 + option + finalImageSaved).forEach(i -> {
            mazeGeneration.init();
            //mazeExport.export(mazeGeneration.getLabCells(), ExportTypes.TO_IMAGE, fileNamePrefix + i);
        });
    }

    private void generateSeeds(int option, String fileNamePrefix) {

        new File(Constants.FILES_MAZES_COORDINATES_PATH).mkdir();
        String[] seedsFilesArray = new File(Constants.FILES_MAZES_COORDINATES_PATH).list();

        int finalSeedSaved = Arrays.stream(seedsFilesArray)
                .filter(file -> file.matches(fileNamePrefix + "[0-9]+" + Constants.EXPORT_SEED_EXTENSION))
                .map(file -> file.replace(fileNamePrefix, ""))
                .map(file -> file.replace(Constants.EXPORT_SEED_EXTENSION, ""))
                .map(Integer::parseInt)
                .max(Integer::compare)
                .orElse(0);

        IntStream.range(1 + finalSeedSaved, 1 + option + finalSeedSaved).forEach(i -> {
            mazeGeneration.init();
            //mazeExport.export(mazeGeneration.getLabCells(), ExportTypes.TO_SEED, fileNamePrefix + i);
        });
    }

    private void generateJSONs(int option, String fileNamePrefix) {

        new File(Constants.FILES_MAZES_COORDINATES_PATH).mkdir();
        String[] jsonFilesArray = new File(Constants.FILES_MAZES_COORDINATES_PATH).list();

        int finalImageSaved = Arrays.stream(jsonFilesArray)
                .filter(file -> file.matches(fileNamePrefix + "[0-9]+" + Constants.EXPORT_JSON_EXTENSION))
                .map(file -> file.replace(fileNamePrefix, ""))
                .map(file -> file.replace(Constants.EXPORT_JSON_EXTENSION, ""))
                .map(Integer::parseInt)
                .max(Integer::compare)
                .orElse(0);

        IntStream.range(1 + finalImageSaved, 1 + option + finalImageSaved).forEach(i -> {
            mazeGeneration.init();
            //mazeExport.export(mazeGeneration.getLabCells(), ExportTypes.TO_JSON, fileNamePrefix + i);
        });
    }
}
