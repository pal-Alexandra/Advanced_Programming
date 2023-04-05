package org.compulsory;

/**
 * @author Pal Alexandra
 * This class describe the Control panel of the application
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * This method is used to initialize the elements from the control panel, the buttons: Load, Save, Exit, Reset
     */
    private void init() {

        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);

        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
    }

    /**
     * This method describe the event for the Exit button: the application is closed.
     * @param e
     */
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    /**
     * This method describe the event for the Save button (in the compulsory task, this button hasn't implementation)
     * @param e
     */
    private void save(ActionEvent e){

        this.frame.setTitle("You pressed the button SAVE");

    }

    /**
     * This method describe the event for the Load button (in the compulsory task, this button hasn't implementation)
     * @param e
     */
    private void load(ActionEvent e){
        this.frame.setTitle("You pressed the button LOAD");

    }

    /**
     * This method describe the event for the Reset button: every thing is reset
     * @param e
     */
    private void reset(ActionEvent e){
        this.frame.setTitle("You pressed the button RESET");
        frame.canvas.removeAll();
        frame.canvas.repaint();
        frame.canvas.initPanel();
    }



}
