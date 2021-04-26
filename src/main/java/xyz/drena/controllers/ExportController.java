package xyz.drena.controllers;

import xyz.drena.Flow;
import xyz.drena.generator.GroundType;
import xyz.drena.generator.Position;
import xyz.drena.view.Constants;
import xyz.drena.view.ExportView;

import java.util.LinkedList;

public class ExportController extends AbstractController {

    private Flow flow;

    public void setFlow(Flow flow) { this.flow = flow; }

    @Override
    public void init() {
        super.init();
        export();
    }

    public void export() {

        Constants.EXPORT_TYPE.getExportable().export(getExportUnits());
    }

    private LinkedList<ExportUnits> getExportUnits() {

        LinkedList<ExportUnits> exportUnits = new LinkedList<>();

        flow.getLabCells().forEach(
                (cell, groundType) ->
                        exportUnits.add(new ExportUnits(cell.getPosition(), groundType))
        );

        return exportUnits;
    }

    public static class ExportUnits {
        private final Position position;
        private final GroundType groundType;

        public ExportUnits(Position position, GroundType groundType) {
            this.position = position;
            this.groundType = groundType;
        }

        public int getRow() {
            return position.getRow();
        }

        public int getCol() {
            return position.getCol();
        }

        public GroundType getGroundType() {
            return groundType;
        }

    }
}
