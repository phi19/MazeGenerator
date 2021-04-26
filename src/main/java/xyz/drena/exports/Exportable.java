package xyz.drena.exports;

import xyz.drena.Main;

import java.util.LinkedList;

public interface Exportable {

    void export(LinkedList<Main.ExportUnits> exportUnits);
}
