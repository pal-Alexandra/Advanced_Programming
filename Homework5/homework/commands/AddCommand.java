package org.homework.commands;

import org.homework.system.Catalog;
import org.homework.system.Document;

public class AddCommand extends Command {
    public AddCommand(String command, Catalog catalog, Document document) {
        super(command, catalog, document);
    }

    public static void add(Catalog catalog, Document document) {
        var newDocs = catalog.getDocs();
        newDocs.add(document);
        catalog.setDocs(newDocs);
    }

}
