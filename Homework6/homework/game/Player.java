package org.homework.game;

/**
 * @author: Pal Alexandra
 * This class describes a player of the positional game.
 */

import org.homework.other.Line;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Player implements Serializable {

    Color color;
    List<Line> lines;

    public Player(Color color) {
        this.color = color;
        lines = new ArrayList<>();
    }

    /**
     * This method sets the color of the player.
     *
     * @param color: red (for the first player) or blue (for the second player)
     */
    public void setColor(Color color) {
        this.color = color;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }


    public Color getColor() {
        return color;
    }

    public List<Line> getLines() {
        return lines;
    }

    /**
     * This class adds an edge in the list of edges that has been colored by the current player.
     *
     * @param line: the most recent edge that has been colored by the current player
     */
    public void addLine(Line line) {
        this.lines.add(line);
    }

    @Override
    public String toString() {
        return "Player{" +
                "color=" + color +
                ", lines=" + lines +
                '}';
    }
}
