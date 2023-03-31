package org.homework;

/**
 * @author Pal Alexandra
 * This is the main class, and it is used to show the functionalities of the homework.
 */

import java.io.IOException;
import java.util.*;

import org.homework.commands.*;
import org.homework.system.Catalog;
import org.homework.system.Document;
import org.homework.exceptions.*;

import javax.print.Doc;

public class Main {
    public static void main(String[] args) {

        Catalog catalog = new Catalog("CatalogTema");
        Set<Document> docs = createDocs();

        for (Document d : docs) {
            //adds a new entry into the catalog using AddCommand class
            AddCommand.add(catalog, d);
        }

        //saving the catalog to an external file using SaveCommand class
        SaveCommand.save(catalog, "documente\\");

        //printing the list of documents of the catalog, on the screen using ListCommand class
        ListCommand.list(catalog);

        Catalog catalogLoaded = null;
        try {
            //loading the catalog from an external file using the LoadCommand class
            catalogLoaded = LoadCommand.load("documente\\CatalogTema.json");
        } catch (InvalidCatalogException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            //creating (and opening) an HTML report representing the content of the catalog using ReportCommand class
            ReportCommand.report(catalog);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * This method is used to create a list of documents.
     *
     * @return a list which contains Document objects
     */
    public static Set<Document> createDocs() {
        var book1 = new Document("Pride and Prejudice", "1A");
        book1.setLocation("D:\\Ale\\Facultate\\An II sem II\\PA\\Lab5_TEMA\\documente\\Pride and Prejudice.txt");
        book1.addTag("TYPE", "BOOK");
        book1.addTag("author", "Jane Austen");
        var book2 = new Document("The Great Gatsby", "1B");
        book2.setLocation("D:\\Ale\\Facultate\\An II sem II\\PA\\Lab5_TEMA\\documente\\The Great Gatsby.txt");
        book2.addTag("TYPE", "BOOK");
        book2.addTag("author", "F. Scott Fitzgerald");
        var article1 = new Document("The tradition of care for Ancient Rome", "2A");
        article1.setLocation("D:\\Ale\\Facultate\\An II sem II\\PA\\Lab5_TEMA\\documente\\The tradition of care for Ancient Rome.txt");
        article1.addTag("TYPE", "ARTICLE");
        article1.addTag("year", 2023);
        var article2 = new Document("Rollo May and Erik Erikson for Psychological developments", "2B");
        article2.setLocation("D:\\Ale\\Facultate\\An II sem II\\PA\\Lab5_TEMA\\documente\\The tradition of care for Ancient Rome.txt");
        article2.addTag("TYPE", "ARTICLE");
        article2.addTag("year", 2022);
        Set<Document> docs = new HashSet<>();
        docs.add(book1);
        docs.add(book2);
        docs.add(article1);
        docs.add(article2);
        return docs;
    }

}