package xyz.drena.controllers.defaultChanges;

import xyz.drena.controllers.AbstractController;
import xyz.drena.services.PathsService;
import xyz.drena.view.tools.Messages;

import java.io.File;

public abstract class AbstractChangeLengthController extends AbstractController implements ChangeLengthController {

    private PathsService pathsService;

    public void setChangeDefaultsService(PathsService pathsService) { this.pathsService = pathsService; }

    protected void resolveRequest(double value, String path) {

        if (value % 2 == 1) {
            if (!pathsService.writeToFile(Double.toString(value), new File(path))) {
                System.out.println(Messages.SYSTEM_ERROR);
            }
            return;
        }

        System.out.println(Messages.VIEW_SET_LENGTH_ERROR);
        init();
    }
}
