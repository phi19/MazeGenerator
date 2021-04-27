package xyz.drena.exports;

import xyz.drena.controllers.ExportController;

import java.util.LinkedList;

public interface Exportable {

    void export(LinkedList<ExportController.ExportUnits> exportUnits);
}
