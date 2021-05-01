package xyz.drena.LabGeneration.exports;

import xyz.drena.LabGeneration.MazeExport;

import java.util.LinkedList;

public abstract class AbstractExportable implements Exportable {

    @Override
    public void export(LinkedList<MazeExport.ExportUnits> exportUnits) {

    }

    @Override
    public void export(LinkedList<MazeExport.ExportUnits> exportUnits, String fileName) {

    }
}
