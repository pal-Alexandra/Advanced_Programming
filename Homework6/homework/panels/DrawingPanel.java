package org.homework.panels;

import org.homework.game.Game;
import org.homework.game.Color;
import org.homework.game.Player;
import org.homework.other.Graph;
import org.homework.other.Line;
import org.homework.other.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;


public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    Graph myGraph;

    Game game;

    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        createBoard();
        initPanel();
    }

    /**
     * This method initializes the panel and capture the movements of the game.
     */
    protected void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point mousePoint = e.getPoint();
                Line clickedLine = game.getClickedLine(mousePoint);

                if (!game.isGameIsOver()) {
                    game.game_move(graphics, clickedLine);
                }
                repaint();
            }
        });

    }

    protected void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(java.awt.Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    /**
     * This method creates the board and sets the game according to parameters of the configuration panel
     */
    final void createBoard() {
        myGraph = new Graph();
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        myGraph.setEdgeProbability(edgeProbability);

        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();

        Player player1 = new Player(Color.RED);
        Player player2 = new Player(Color.BLUE);
        game = new Game(myGraph, player1, player2);

        repaint();
    }

    /**
     * This method restores the game with a game that was received from an external file.
     *
     * @param restoredGame: the game from an external file
     */
    final void restoredGame(Game restoredGame) {
        System.out.println("sunt in restore game");

        game = restoredGame;
        myGraph = restoredGame.getGraph();
        numVertices = myGraph.getVertices().size() - 1;
        edgeProbability = (Double) myGraph.getEdgeProbability();

        System.out.println(myGraph.getLines());
        removeAll();
        repaint();
        createOffscreenImage();
        drawVertices();
        drawRestoredLines();
        repaint();
    }


    /**
     * This method creates the vertices of the game.
     */
    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle

        for (int i = 0; i < numVertices; i++) {
            var vertice = new Vertex(x0 + (int) (radius * Math.cos(alpha * i)), y0 + (int) (radius * Math.sin(alpha * i)));
            myGraph.addVertice(vertice);
        }
    }

    /**
     * This method draws the vertices of the game.
     */
    private void drawVertices() {

        for (int i = 0; i < numVertices; i++) {
            graphics.setColor(java.awt.Color.DARK_GRAY);
            graphics.fillOval((int) myGraph.getVertices().get(i).getX(), (int) myGraph.getVertices().get(i).getY(), 20, 20);
            graphics.drawOval((int) myGraph.getVertices().get(i).getX(), (int) myGraph.getVertices().get(i).getY(), 20, 20);
        }

    }

    /**
     * This method creates and draws the edges of the game.
     */
    private void drawLines() {

        int maxLines = numVertices * (numVertices - 1) / 2;
        int noOfLines = (int) (edgeProbability * 10 * maxLines) / 10;
        for (int i = 0; i < noOfLines; i++) {
            Random random = new Random();
            int node1 = random.nextInt(numVertices);
            int node2 = random.nextInt(numVertices);
            if (node1 == node2) {
                i--;
            } else {
                Vertex v1 = myGraph.getVertices().get(node1);
                Vertex v2 = myGraph.getVertices().get(node2);
                ;
                if (myGraph.getListAdiacent().get(v1).contains(v2)) {
                    i--;
                } else {
                    graphics.setColor(java.awt.Color.lightGray);
                    Line line = new Line(Color.GRAY, v1, v2);
                    myGraph.addLine(line);
                    myGraph.getListAdiacent().get(v1).add(v2);
                    myGraph.getListAdiacent().get(v2).add(v1);
                    graphics.drawLine((int) v1.getX(), (int) v1.getY(), (int) v2.getX(), (int) v2.getY());
                }
            }
        }
    }

    /**
     * This method is used to draw the lines of a restored game.
     */
    public void drawRestoredLines() {
        for (int i = 0; i < game.getGraph().getLines().size(); i++) {
            var line = game.getGraph().getLines().get(i);
            if (line.getColor() == Color.GRAY) {
                graphics.setColor(java.awt.Color.lightGray);
            } else if (line.getColor() == Color.RED) {
                graphics.setColor(java.awt.Color.red);
            } else {
                graphics.setColor(java.awt.Color.blue);
            }
            graphics.drawLine((int) line.getV1().getX(), (int) line.getV1().getY(), (int) line.getV2().getX(), (int) line.getV2().getY());
        }
    }

    public void loadImage(BufferedImage image) {
        graphics.drawImage(image, 0, 0, null);
        repaint();
    }


    @Override
    public void update(Graphics g) {
    } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }


}



