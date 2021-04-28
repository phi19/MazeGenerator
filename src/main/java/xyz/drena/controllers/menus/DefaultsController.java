package xyz.drena.controllers.menus;

import xyz.drena.controllers.AbstractController;
import xyz.drena.controllers.Controller;
import xyz.drena.view.tools.Messages;
import xyz.drena.view.menuOptions.DefaultsOptions;

import java.util.Map;

public class DefaultsController extends AbstractController {

    private Map<Integer, Controller> controllerMap;

    public void setControllerMap(Map<Integer, Controller> controllerMap) { this.controllerMap = controllerMap; }

    public void handleOption(int option) {

        if (option == DefaultsOptions.GO_BACK.getOption()) {
            return;
        }

        if (!controllerMap.containsKey(option)) {
            throw new IllegalStateException(Messages.SYSTEM_ERROR);
        }

        controllerMap.get(option).init();
        init();
    }
}
