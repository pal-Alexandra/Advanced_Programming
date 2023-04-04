package org.homework.panels;

/**
 * @author Pal Alexandra
 * This class describes the control panel of the game.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import org.homework.game.Game;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton saveImgBtn = new JButton("Save Image");

    JButton resetBtn = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * This class creates the buttons of the panel.
     */
    private void init() {

        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::save);
        saveImgBtn.addActionListener(this::saveImage);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);

        add(loadBtn);
        add(saveBtn);
        add(saveImgBtn);
        add(resetBtn);
        add(exitBtn);
    }

    /**
     * The action for the Exit button
     *
     * @param e: the event received
     */
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    /**
     * The action for the Save Image button: saves an image of the current canvas in an external file chosen by the user.
     *
     * @param e: the event received
     */
    private void saveImage(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Give the location: ");
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save file as: " + fileToSave.getAbsolutePath());
            try {
                ImageIO.write(frame.canvas.image, "png", new FileOutputStream(fileToSave.getAbsolutePath()));

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }
    }

    /**
     * The action for the Save button: saves the current state of a game in an external file chosen by the user.
     *
     * @param e
     */
    private void save(ActionEvent e) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Give the location: ");
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save file as: " + fileToSave.getAbsolutePath());
            try {
                PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                        .allowIfSubType("com.baeldung.jackson.inheritance")
                        .allowIfSubType("java.util.ArrayList")
                        .build();
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);
                objectMapper.writeValue(new File(fileToSave.getAbsolutePath()), frame.canvas.game);

            } catch (IOException ex) {
                ex.getMessage();
            }

        }
    }

    /**
     * The action for the Load button: loads the state of a game stored in an external file chosen by the user.
     *
     * @param e
     */

    private void load(ActionEvent e) {

        Game game = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Give the location of the file: ");
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                game = objectMapper.readValue(new File(fileToLoad.getAbsolutePath()), Game.class);

            } catch (IOException ex) {
                ex.getMessage();
            }

        }

        frame.canvas.restoredGame(game);


    }

    /**
     * The action for the Reset button: resets the game.
     *
     * @param e
     */
    private void reset(ActionEvent e) {
        this.frame.setTitle("You pressed the button RESET");
        frame.canvas.removeAll();
        frame.canvas.repaint();
        frame.canvas.createOffscreenImage();
        frame.canvas.createBoard();
        frame.canvas.initPanel();
    }


}
