package xyz.drena.services;

import xyz.drena.LabGeneration.MazeExport;
import xyz.drena.LabGeneration.MazeGeneration;
import xyz.drena.LabGeneration.exports.ExportTypes;
import xyz.drena.LabGeneration.generator.Cell;
import xyz.drena.LabGeneration.generator.GroundType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.IntStream;

public class MazeGenService {

    private MazeGeneration mazeGeneration;
    private MazeExport mazeExport;

    public void setMazeGeneration(MazeGeneration mazeGeneration) { this.mazeGeneration = mazeGeneration; }

    public void setMazeExport(MazeExport mazeExport) { this.mazeExport = mazeExport; }

    public MazeGenService() {
        //mazes = new ArrayList<>();
    }

    public void generate(int option) {

        IntStream.range(0, option).forEach(i -> {
            mazeGeneration.init();
            mazeExport.export(mazeGeneration.getLabCells(), ExportTypes.TO_IMAGE, "lab" + i);
            //mazes.add(mazeGeneration.getLabCells());
        });
    }
}
