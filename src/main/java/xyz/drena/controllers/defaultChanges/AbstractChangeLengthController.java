package xyz.drena.controllers.defaultChanges;

import xyz.drena.controllers.AbstractController;
import xyz.drena.services.ChangeDefaultsService;
import xyz.drena.view.tools.Constants;
import xyz.drena.view.tools.Messages;

public abstract class AbstractChangeLengthController extends AbstractController implements ChangeLengthController {

    private ChangeDefaultsService changeDefaultsService;

    public void setChangeDefaultsService(ChangeDefaultsService changeDefaultsService) { this.changeDefaultsService = changeDefaultsService; }

    protected void resolveRequest(double value, String fileName) {

        if (value % 2 == 1) {
            changeDefaultsService.changeDefault(value, fileName);
            return;
        }

        System.out.println(Messages.VIEW_SET_LENGTH_ERROR);
        init();
    }
}
