package xyz.drena.controllers.defaultChanges;

import xyz.drena.view.tools.Constants;

public class ChangeColumnsController extends AbstractChangeLengthController {

    @Override
    public void handleValue(double value) {
        resolveRequest(value, Constants.DEFAULT_COLUMNS_PATH);
    }
}
