package org.homework.other;

/**
 * @author Pal Alexandra
 * This class describes the dots from the positional game.
 */

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.awt.geom.Point2D;
import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "class")
public class Vertex extends Point2D implements Serializable {

    double x, y;


    public Vertex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    protected Vertex() {
        super();
    }

    @Override
    public void setLocation(Point2D p) {
        super.setLocation(p);
    }


    @Override
    public Object clone() {
        return super.clone();
    }
}
