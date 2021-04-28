package xyz.drena.controllers.menus;

import xyz.drena.controllers.AbstractController;
import xyz.drena.services.LabGenService;
import xyz.drena.LabGeneration.generator.GroundType;
import xyz.drena.LabGeneration.Position;
import xyz.drena.view.tools.Constants;

import java.util.LinkedList;

public class ExportController extends AbstractController {

    private LabGenService labGenService;

    public void setLabGenService(LabGenService labGenService) { this.labGenService = labGenService; }

    @Override
    public void init() {
        super.init();
        //export();
    }

    public void export() {

        Constants.EXPORT_TYPE.getExportable().export(getExportUnits());
    }

    private LinkedList<ExportUnits> getExportUnits() {

        LinkedList<ExportUnits> exportUnits = new LinkedList<>();

        labGenService.getLabCells().forEach(
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
