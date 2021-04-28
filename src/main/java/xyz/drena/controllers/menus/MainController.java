package xyz.drena.controllers.menus;

import xyz.drena.controllers.AbstractController;
import xyz.drena.controllers.Controller;
import xyz.drena.view.tools.Messages;
import xyz.drena.view.menuOptions.MainOptions;

import java.util.Map;

public class MainController extends AbstractController {

    private Map<Integer, Controller> controllerMap;

    public void setControllerMap(Map<Integer, Controller> controllerMap) { this.controllerMap = controllerMap; }

    public void handleOption(int option) {

        if (option == MainOptions.QUIT.getOption()) {
            return;
        }

        if (!controllerMap.containsKey(option)) {
            throw new IllegalStateException(Messages.SYSTEM_ERROR);
        }

        controllerMap.get(option).init();
        init();
    }
}
