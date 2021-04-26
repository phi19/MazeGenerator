package xyz.drena;

import xyz.drena.generator.GroundType;
import xyz.drena.generator.Position;
import xyz.drena.view.Constants;

import java.util.LinkedList;

public class Main {

    private Flow flow;

    public static void main(String[] args) {
        Main main = new Main();

        main.startFlow();
        main.export();
    }

    private void startFlow() {
        flow = new Flow();
        flow.init();
    }

    private void export() {

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
