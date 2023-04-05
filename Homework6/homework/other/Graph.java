package org.homework.other;

/**
 * @author Pal Alexandra
 * This class describes the graph of the positional game: the dots are vertices and the lines are edges.
 */


import org.homework.game.Color;

import java.io.Serializable;
import java.util.*;


public class Graph implements Serializable {

    protected List<Vertex> vertices;
    protected List<Line> lines;

    double edgeProbability;

    Map<Vertex, Set<Vertex>> listAdiacent;

    public Graph() {
        vertices = new ArrayList<>();
        lines = new ArrayList<>();
        listAdiacent = new HashMap<>();
    }


    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Line> getLines() {
        return lines;
    }

    public double getEdgeProbability() {
        return edgeProbability;
    }

    public Map<Vertex, Set<Vertex>> getListAdiacent() {
        return listAdiacent;
    }

    public void setEdgeProbability(double edgeProbability) {
        this.edgeProbability = edgeProbability;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public void setListAdiacent(Map<Vertex, Set<Vertex>> listAdiacent) {
        this.listAdiacent = listAdiacent;
    }

    /**
     * This method adds a new vertex in graph.
     *
     * @param v: the vertex to be added
     */
    public void addVertice(Vertex v) {
        vertices.add(v);
        listAdiacent.put(v, new HashSet<>());
    }

    /**
     * This method adds a new edge in graph.
     *
     * @param l: the edge to be added
     */
    public void addLine(Line l) {
        lines.add(l);
    }

    /**
     * This method resets the color of an edge in graph.
     *
     * @param line:  the edge to be reset
     * @param color: the new color of the edge
     */
    public void resetLineColor(Line line, Color color) {

        for (int i = 0; i < lines.size(); i++)
            if (lines.get(i).equals(line)) {
                lines.get(i).setColor(color);
            }

    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertices=" + vertices +
                ", lines=" + lines +
                ", edgeProbability=" + edgeProbability +
                ", listAdiacent=" + listAdiacent +
                '}';
    }
}
