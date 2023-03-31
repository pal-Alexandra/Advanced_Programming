package org.homework.commands;

/**
 * @author Pal Alexandra
 * This class describe the command view from the Document Management System
 */

import org.homework.system.Catalog;
import org.homework.system.Document;

import java.awt.*;
import java.io.File;
import java.util.UUID;

public class ViewCommand extends Command {


    /**
     * This is the constructor of the class
     *
     * @param command: sets the name of the command
     * @param catalog: sets the Catalog object that will be processed
     */
    public ViewCommand(String command, Catalog catalog) {
        super(command, catalog);
    }

    /**
     * This method is used to open a document using the native operating system application
     *
     * @param document: the Document object that will be opened
     */
    public static void view(Document document) {
        File file = new File(document.getLocation());
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }
}
