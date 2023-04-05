package org.homework.panels;
/**
 * @author Pal Alexandra
 * This class describes the configuration panel of the game.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createBtn = new JButton("Create new game");

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * This method creates the buttons of the configuration panel.
     */
    private void init() {
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        linesLabel = new JLabel("Line probability:");
        Double[] probabilities = {1.0, 0.5, 0.4, 0.3, 0.2};
        linesCombo = new JComboBox<>(probabilities);

        createBtn.addActionListener(this::createButtonEvent);

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createBtn);
    }

    /**
     * This method assign the event for the Create New Game button
     *
     * @param e
     */
    private void createButtonEvent(ActionEvent e) {
        frame.canvas.createBoard();
    }

}



