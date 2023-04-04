package org.homework.other;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.homework.game.Color;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Pal Alexandra
 * This class describes the lines from the positional game.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "class")
public class Line extends Line2D implements Serializable {
    public Color color;
    Vertex v1, v2;

    /**
     * This is the constructor of the class.
     *
     * @param color: sets the color of the line
     * @param v1:    sets the first end-point (dot) of the line
     * @param v2:    sets the second end-point (dot) of the line
     */
    public Line(Color color, Vertex v1, Vertex v2) {
        this.color = color;
        this.v1 = v1;
        this.v2 = v2;
    }

    public Color getColor() {
        return color;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }


    public void setColor(Color color) {
        this.color = color;
    }

    public void setV1(Vertex v1) {
        this.v1 = v1;
    }

    public void setV2(Vertex v2) {
        this.v2 = v2;
    }

    @Override
    public String toString() {
        return "Line{" +
                "color=" + color +
                ", v1=" + v1 +
                ", v2=" + v2 +
                '}';
    }

    @Override
    public double getX1() {
        return v1.getX();
    }

    @Override
    public double getY1() {
        return v1.getY();
    }

    @Override
    public Point2D getP1() {
        return v1;
    }

    @Override
    public double getX2() {
        return v2.getX();
    }

    @Override
    public double getY2() {
        return v2.getY();
    }

    @Override
    public Point2D getP2() {
        return v2;
    }

    @Override
    public void setLine(double x1, double y1, double x2, double y2) {
        v1.setLocation(x1, y1);
        v2.setLocation(x2, y2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(v1, line.v1) && Objects.equals(v2, line.v2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, v1, v2);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }
}
