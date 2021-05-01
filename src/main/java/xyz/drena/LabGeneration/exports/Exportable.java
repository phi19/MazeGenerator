package xyz.drena.LabGeneration.exports;

import xyz.drena.LabGeneration.MazeExport;

import java.util.LinkedList;

public interface Exportable {

    void export(LinkedList<MazeExport.ExportUnits> exportUnits);

    void export(LinkedList<MazeExport.ExportUnits> exportUnits, String fileName);
}
