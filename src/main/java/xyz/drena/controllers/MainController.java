package xyz.drena.controllers;

import xyz.drena.Flow;

public class MainController extends AbstractController {

    private Flow flow;

    public void setFlow(Flow flow) { this.flow = flow; }

    public void generateLab() {
        flow.init();
        nextController.init();
    }
}
