package org.homework.game;

/**
 * @author Pal Alexandra
 * This class describes the positional game.
 */

import org.homework.other.Graph;
import org.homework.other.Line;
import org.homework.other.Vertex;

import java.awt.*;

import static java.awt.Color.RED;
import static java.awt.Color.BLUE;

import java.awt.geom.Line2D;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



public class Game implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    private Graph graph;
    Player playerOne;
    Player playerTwo;

    Player winner;

    int turn;

    int coloredLines;

    boolean gameIsOver;

    public Game() {
    }

    /**
     * This is the constructor of the class
     *
     * @param graph:     sets the graph of the positional game.
     * @param playerOne: sets the first player
     * @param playerTwo: sets the second player
     */
    public Game(Graph graph, Player playerOne, Player playerTwo) {
        this.graph = graph;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        turn = 0;
        gameIsOver = false;
        coloredLines = 0;
    }

    public int getColoredLines() {
        return coloredLines;
    }

    public Graph getGraph() {
        return graph;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    /**
     * This method finds which edge of the graph has been clicked.
     *
     * @param p: the point that has been clicked.
     * @return: the clicked edge or null if there hasn't been clicked an edge.
     */
    public Line getClickedLine(Point p) {

        for (Line line : graph.getLines()) {
            Line2D line1 = new Line2D.Double(line.getX1(), line.getY1(),
                    line.getX2(), line.getY2());
            double distance = line1.ptLineDist(line.getX1(), line.getY1(),
                    line.getX2(), line.getY2(),
                    p.x, p.y);

            if (distance < 5)
                return line;

        }
        return null;
    }

    /**
     * This method is used to manage the game loop.
     *
     * @return: 0 if it is the first player's turn, 1 if it is the second player's turn
     */
    public int getTurn() {
        return turn;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isGameIsOver() {
        return gameIsOver;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public void setColoredLines(int coloredLines) {
        this.coloredLines = coloredLines;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }

    /**
     * This method describes the move for the first player and check if the game has been won by him.
     *
     * @param graphics:    used to draw and color red the clicked line by the first player
     * @param clickedLine: the clicked line by the first player
     */
    public void playerOneMove(Graphics2D graphics, Line clickedLine) {
        clickedLine.setColor(Color.RED);
        graphics.setColor(RED);
        graphics.drawLine((int) clickedLine.getX1(), (int) clickedLine.getY1(), (int) clickedLine.getX2(), (int) clickedLine.getY2());
        getPlayerOne().addLine(clickedLine);
        getGraph().resetLineColor(clickedLine, Color.RED);
        coloredLines++;
        boolean result = checkGameOver(clickedLine, Color.RED);

        if (result == true) {
            System.out.println("GAME OVER. The winner has the color: " + getWinner().getColor());
            gameIsOver = true;
        }

    }

    /**
     * This method describes the move for the second player and check if the game has been won by him.
     *
     * @param graphics:    used to draw and color blue the clicked line by the first player
     * @param clickedLine: the clicked line by the second player
     */
    public void playerTwoMove(Graphics2D graphics, Line clickedLine) {
        clickedLine.setColor(Color.BLUE);
        graphics.setColor(BLUE);
        graphics.drawLine((int) clickedLine.getX1(), (int) clickedLine.getY1(), (int) clickedLine.getX2(), (int) clickedLine.getY2());
        getPlayerTwo().addLine(clickedLine);
        getGraph().resetLineColor(clickedLine, Color.BLUE);
        coloredLines++;
        boolean result = checkGameOver(clickedLine, Color.BLUE);

        if (result == true) {
            System.out.println("GAME OVER. The winner has the color: " + getWinner().getColor());
            gameIsOver = true;
        }

    }

    /**
     * This method is used to manage a move from the game: decides whose turn it is and calls the related methods, then checks if the game is tied.
     *
     * @param graphics:    used to draw and color the clicked line by the player
     * @param clickedLine: the clicked line by the player
     */
    public void game_move(Graphics2D graphics, Line clickedLine) {

        if (clickedLine != null) {

            if (clickedLine.getColor().equals(Color.GRAY)) {

                if (turn == 0) {
                    playerOneMove(graphics, clickedLine);
                } else {
                    playerTwoMove(graphics, clickedLine);
                }
                if (coloredLines == graph.getLines().size() && !gameIsOver) {
                    gameIsOver = true;
                    System.out.println("Remiza. Au fost colorate toate liniile, dar niciun jucator nu a format vreun triunghi!");
                }
                turn = 1 - turn;

            } else {
                System.out.println("Linia selectata are deja culoare. Selecteaza alta linie!");
            }

        } else {
            System.out.println("Nu ai dat click pe o linie, mai incearca :)");
        }

    }

    /**
     * This method check if a triangle of the same color was formed.
     *
     * @param line:  the most recent line that has been colored
     * @param color: the color of the line
     * @return: true if a triangle of the same color was formed, false otherwise
     */
    public boolean checkGameOver(Line line, Color color) {

        Set<Vertex> neighboursV1 = new HashSet<>();
        neighboursV1.addAll(graph.getListAdiacent().get(line.getV1()));
        Set<Vertex> neighboursV2 = new HashSet<>();
        neighboursV2.addAll(graph.getListAdiacent().get(line.getV2()));
        neighboursV1.retainAll(neighboursV2);

        int sameColorLines;
        for (Vertex v1 : neighboursV1) {
            sameColorLines = 1;
            Vertex v2 = line.getV1();
            Vertex v3 = line.getV2();
            for (Line l : graph.getLines()) {
                if (l.getColor().equals(color)) {
                    //v2-v1, v3-v1
                    if ((l.getV1().equals(v2) && l.getV2().equals(v1)) ||
                            (l.getV1().equals(v1) && l.getV2().equals(v2))) sameColorLines++;

                    else if ((l.getV1().equals(v3) && l.getV2().equals(v1)) ||
                            (l.getV1().equals(v1) && l.getV2().equals(v3))) sameColorLines++;


                }
            }
            if (sameColorLines == 3) {
                if (color == Color.RED)
                    this.setWinner(playerOne);
                else
                    this.setWinner(playerTwo);

                return true;
            }
        }
        return false;

    }


    @Override
    public String toString() {
        return "Game{" +
                "graph=" + graph +
                ", playerOne=" + playerOne +
                ", playerTwo=" + playerTwo +
                '}';
    }


}
