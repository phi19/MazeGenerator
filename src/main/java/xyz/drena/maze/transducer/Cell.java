package xyz.drena.maze.transducer;

import xyz.drena.maze.Position;

import java.util.Objects;

public class Cell {

    private final Position position;

    public Cell(Position position) {
        this.position = position;
    }

    public Position getPosition() { return position; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return position.equals(cell.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
