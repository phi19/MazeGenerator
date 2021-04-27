package xyz.drena.controllers;

import xyz.drena.view.View;

public class AbstractController implements Controller {

    protected View view;

    public void setView(View view) { this.view = view; }

    @Override
    public void init() {
        view.show();
    }
}
