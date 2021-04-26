package xyz.drena.exports;

import xyz.drena.Main;
import xyz.drena.controllers.ExportController;
import xyz.drena.controllers.MainController;

import java.util.LinkedList;

public interface Exportable {

    void export(LinkedList<ExportController.ExportUnits> exportUnits);
}
