package org.compulsory;

/**
 * @author Pal Alexandra
 * This class describe the main frame of the application (the positional game)
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
     * This method puts together the elements of the application: the configuration panel, the control panel and the drawing panel
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
