package org.homework.commands;

/**
 * @author Pal Alexandra
 * This class is used to describe a generic command.
 */

import org.homework.system.Catalog;
import org.homework.system.Document;

public abstract class Command {

    String command;
    Catalog catalog;
    Document document;

    /**
     * This is the default constructor of the class.
     */
    public Command() {
        this.command = "";
        this.catalog = new Catalog();
        this.document = new Document();
    }

    /**
     * This is another constructor of the class.
     *
     * @param command:  sets the name of the command
     * @param catalog:  sets the Catalog object that will be processed
     * @param document: sets the Document    object that will be processed
     */
    public Command(String command, Catalog catalog, Document document) {
        this.command = command;
        this.catalog = catalog;
        this.document = document;
    }

    /**
     * This is another constructor of the class.
     *
     * @param command: sets the name of the command
     * @param catalog: sets the Catalog object that will be processed
     */
    public Command(String command, Catalog catalog) {
        this.command = command;
        this.catalog = catalog;
    }
}
