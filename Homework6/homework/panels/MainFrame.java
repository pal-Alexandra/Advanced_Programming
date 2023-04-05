package org.homework.panels;
/**
 * @author Pal Alexandra
 * This class describes the mainframe of the game.
 */

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    /**
     * This method initialize the control and configuration panels and the canvas of the game.
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);


        controlPanel.setBackground(Color.lightGray);
        configPanel.setBackground(Color.lightGray);

        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

}
