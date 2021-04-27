package xyz.drena.controllers;

import xyz.drena.services.ChangeDefaultsService;
import xyz.drena.view.DefaultsOptions;

public class DefaultOptionsController extends AbstractController {

    private ChangeDefaultsService changeDefaultsService;

    public void setChangeDefaultsService(ChangeDefaultsService changeDefaultsService) { this.changeDefaultsService = changeDefaultsService; }

    public void changeDefault(DefaultsOptions option, boolean parseToInt, double number) {
        changeDefaultsService.changeDefault(option.getFile(), parseToInt, number);
    }
}
