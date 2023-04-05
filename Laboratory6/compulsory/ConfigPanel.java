package org.compulsory;

/**
 * @author Pal Alexandra
 * This class describe the Configuation panel of the application
 */

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createBtn = new JButton("Create new game");

    public ConfigPanel(MainFrame frame){
        this.frame=frame;
        init();
    }

    /**
     * This method is used to initialize the elements from the configuration panel: a label and a spinner for introducing parameters regarding the number of dots and lines and a button for creating a new game.
     */
    private void init(){
        dotsLabel=new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6,3,100,1));

        linesLabel=new JLabel("Line probability:");
        Double[] probabilities={1.0, 0.5, 0.4, 0.3, 0.2};
        linesCombo = new JComboBox<>(probabilities);

        createBtn.addActionListener(this::createButtonEvent);

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createBtn);
    }

    /**
     * This method describe the event for the Create New Game button: everything is reset in order to the new parameters of the configuration panel.
     * @param e: the event
     */
    private void createButtonEvent(ActionEvent e){
        frame.canvas.createBoard();
    }

}



