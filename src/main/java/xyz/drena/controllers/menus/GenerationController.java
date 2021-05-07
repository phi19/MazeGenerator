package xyz.drena.controllers.menus;

import xyz.drena.controllers.AbstractController;
import xyz.drena.services.MazeGenService;

public class GenerationController extends AbstractController {

    private MazeGenService mazeGenService;

    public void setMazeGenService(MazeGenService mazeGenService) { this.mazeGenService = mazeGenService; }

    public void handleValue(int value, String fileNamePrefix) {
        mazeGenService.generate(value, fileNamePrefix);
    }
}
