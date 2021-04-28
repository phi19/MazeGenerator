package xyz.drena.controllers.defaultChanges;

import xyz.drena.controllers.AbstractController;
import xyz.drena.services.ChangeDefaultsService;
import xyz.drena.view.tools.Constants;

public class ChangeSeedController extends AbstractController {

    private ChangeDefaultsService changeDefaultsService;

    public void setChangeDefaultsService(ChangeDefaultsService changeDefaultsService) { this.changeDefaultsService = changeDefaultsService; }

    public void handleValue(double value) {
        changeDefaultsService.changeDefault(value, Constants.FILES_DEFAULTS_SEED);
    }
}
