package org.homework.commands;

/**
 * @author Pal Alexandra
 * This class describe the command list from the Document Management System
 */

import org.homework.system.Catalog;

public class ListCommand extends Command {
    /**
     * This is the constructor of the class
     *
     * @param command: sets the name of the command
     * @param catalog: sets the Catalog object that will be processed
     */
    public ListCommand(String command, Catalog catalog) {
        super(command, catalog);
    }

    /**
     * This method is used to print the list of documents within the catalog, on the screen;
     *
     * @param catalog: Catalog object that will be processed
     */
    public static void list(Catalog catalog) {
        var myDocs = catalog.getDocs();
        if (myDocs.size() == 0) {
            System.out.println("The " + catalog.getName() + " is empty");
            return;
        } else {
            System.out.println(catalog.getName());
            myDocs.forEach(System.out::println);
        }
    }
}
