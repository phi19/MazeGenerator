package xyz.drena.exports;

import xyz.drena.controllers.menus.ExportController;

import java.util.LinkedList;

public interface Exportable {

    void export(LinkedList<ExportController.ExportUnits> exportUnits);
}
