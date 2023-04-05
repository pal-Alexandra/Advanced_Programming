package org.homework.other;

/**
 * @author Pal Alexandra
 * This class describes the dots from the positional game.
 */

import java.io.Serializable;

public class Vertex implements Serializable {

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


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

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
}
