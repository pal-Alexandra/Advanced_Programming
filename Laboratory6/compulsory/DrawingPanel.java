package org.compulsory;

/**
 * @author Pal Alexandra
 * This class describe the Drawing panel (the canvas) of the application
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;


public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final  static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;

    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    /**
     * This method is used to initialize the drawing panel dimensions
     */
    protected void initPanel() {

        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //repaint();
            }
        });
    }

    /**
     * TO DO
     */
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    /**
     * This method is used to initialize the number of dots and lines that have to be drawn.
      */
    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    /**
     * This method is used to initialize the coordinates of the dots.
     */
    private void createVertices() {
        int x0 = W / 2; int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    /**
     * This method draws the dots.
     */
    private void drawVertices() {

        for(int i=0;i<numVertices;i++){
            graphics.setColor(Color.DARK_GRAY);
            graphics.fillOval(x[i],y[i],20,20);
            graphics.drawOval(x[i],y[i], 20, 20);
        }

    }

    /**
     * This method draws the lines according to the line's probability.
     */
    private void drawLines() {

        int maxLines = numVertices * (numVertices-1)/2;
        Map<Integer, List<Integer>> listAdiacent = new HashMap<>();

        int noOfLines = (int)(edgeProbability*10*maxLines)/10;
        for(int i = 0; i<noOfLines; i++)
        {
            Random random = new Random();
            int node1 = random.nextInt(numVertices);
            int node2 = random.nextInt(numVertices);
            if(node1 == node2){
                i--;
            }
            else{
                if(!listAdiacent.containsKey(node1))
                {
                    listAdiacent.put(node1, new ArrayList<>());
                }
                if(!listAdiacent.containsKey(node2))
                {
                    listAdiacent.put(node2, new ArrayList<>());
                }
                if(listAdiacent.get(node1).contains(node2)){
                    i--;
                }
                else{
                    graphics.setColor(Color.black);
                    listAdiacent.get(node1).add(node2);
                    listAdiacent.get(node2).add(node1);
                    graphics.drawLine(x[node1], y[node1], x[node2], y[node2]);
                }
            }
        }
    }

    @Override
    public void update(Graphics g) { } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }


}



