package xyz.drena.exports.exportables;

import xyz.drena.exports.utils.ExportUnits;

import java.util.LinkedList;

public interface Exportable {

    void export(LinkedList<ExportUnits> exportUnits, String fileName);
}
