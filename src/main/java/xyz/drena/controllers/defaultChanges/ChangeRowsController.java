package xyz.drena.controllers.defaultChanges;

import xyz.drena.view.tools.Constants;

public class ChangeRowsController extends AbstractChangeLengthController {

    @Override
    public void handleValue(double value) {
        resolveRequest(value, Constants.FILES_DEFAULTS_ROWS);
    }
}