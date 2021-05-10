package xyz.drena.exports;

import xyz.drena.maze.Position;
import xyz.drena.maze.transducer.GroundType;

public class ExportUnits {
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

