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
                FileOutputStream fileOut =
                        new FileOutputStream(fileToSave.getAbsolutePath());
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(frame.canvas.game);
                out.close();
                fileOut.close();
            } catch (IOException i) {
                System.out.println(i.getMessage());
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
                FileInputStream fileIn = new FileInputStream(fileToLoad.getAbsolutePath());
                ObjectInputStream in = new ObjectInputStream(fileIn);
                game = (Game) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                System.out.println(i.getMessage());
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Game class not found");
                System.out.println(c.getMessage());
                return;
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
