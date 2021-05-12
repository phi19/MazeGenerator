package xyz.drena.controllers.menus;

import xyz.drena.controllers.AbstractController;
import xyz.drena.services.EditService;

public class EditController extends AbstractController {

    private EditService editService;

    public void setEditService(EditService editService) { this.editService = editService; }

    public void start() {
        // this doesn't have much YET
        // keyboard is the controller
        editService.init();
    }

}
