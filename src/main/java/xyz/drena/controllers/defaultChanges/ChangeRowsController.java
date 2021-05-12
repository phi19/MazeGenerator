package xyz.drena.controllers.defaultChanges;

import xyz.drena.view.tools.Constants;

import java.io.File;

public class ChangeRowsController extends AbstractChangeLengthController {

    @Override
    public void handleValue(double value) {
        resolveRequest(value, Constants.DEFAULT_ROWS_PATH);
    }
}
