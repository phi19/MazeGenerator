package xyz.drena.controllers;

import xyz.drena.services.LabGenService;
import xyz.drena.view.MainOptions;

public class MainController extends AbstractController {

    private LabGenService labGenService;
    private DefaultOptionsController defaultOptionsController;

    public void setLabGenService(LabGenService labGenService) { this.labGenService = labGenService; }

    public void setDefaultOptionsController(DefaultOptionsController defaultOptionsController) { this.defaultOptionsController = defaultOptionsController; }

    public void handleOption(int option) {

        switch(MainOptions.values()[option - 1]) {
            case CHANGE_DEFAULTS:
                defaultOptionsController.init();
                break;
            case EDIT_MAZE:
            case EXPORT_MAZE:
                break;
            case QUIT:
                return;
        }
        init();
    }

    public void generateLab() {
        labGenService.init();
        //nextController.init();
    }
}
