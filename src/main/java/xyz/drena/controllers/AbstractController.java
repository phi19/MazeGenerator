package xyz.drena.controllers;

import xyz.drena.view.View;

public class AbstractController implements Controller {

    protected View view;
    protected Controller nextController;

    public void setView(View view) { this.view = view; }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    @Override
    public void init() {
        view.show();
    }
}
