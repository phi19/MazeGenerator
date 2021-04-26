package xyz.drena.algorithm;

import xyz.drena.generator.Position;

import java.util.Objects;

public class Block {

    private final Position position;

    public Block(Position position) {
        this.position = position;
    }

    public Position getPosition() { return position; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return position.equals(block.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Block{" +
                "position=" + position +
                '}';
    }
}
