package xyz.drena.imports.utils;

import xyz.drena.maze.Position;
import xyz.drena.maze.transducer.GroundType;

public class ImportUnits {
    private final Position position;
    private final GroundType groundType;

    public ImportUnits(Position position, GroundType groundType) {
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

    @Override
    public String toString() {
        return "ImportUnits{" +
                "position=" + position +
                ", groundType=" + groundType +
                '}';
    }
}
