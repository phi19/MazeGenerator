package xyz.drena.LabGeneration.generator;
import org.academiadecodigo.simplegraphics.graphics.Color;

public enum GroundType {

    FLOOR(Color.WHITE, java.awt.Color.WHITE),
    WALL(Color.BLACK, java.awt.Color.black),
    START(Color.GREEN, java.awt.Color.GREEN),
    END(Color.RED, java.awt.Color.RED);

    private final Color color;
    private final java.awt.Color javaColor;

    GroundType(Color color, java.awt.Color javaColor) {
        this.color = color;
        this.javaColor = javaColor;
    }

    public Color getColor() {
        return color;
    }

    public java.awt.Color toJavaColor() {
        return javaColor;
    }
}
