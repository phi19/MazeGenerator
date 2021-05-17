package xyz.drena.controllers.menus;

import xyz.drena.controllers.AbstractController;
import xyz.drena.services.EditService;
import xyz.drena.services.PathsService;

public class EditController extends AbstractController {

    private EditService editService;
    private PathsService pathsService;

    public void setEditService(EditService editService) { this.editService = editService; }

    public void setPathsService(PathsService pathsService) { this.pathsService = pathsService; }

    public void start(String result) {
        // this doesn't have much YET
        // keyboard is the controller
        //pathsService.readFromFile(result);
        editService.init();
    }

}
