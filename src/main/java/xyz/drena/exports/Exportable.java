package xyz.drena.exports;

import java.util.LinkedList;

public interface Exportable {

    void export(LinkedList<ExportUnits> exportUnits, String fileName);
}
