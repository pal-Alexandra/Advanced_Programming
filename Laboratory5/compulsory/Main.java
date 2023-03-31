package org.compulsory;

/**
 * @author Pal Alexandra
 * This is the main class, and it is used to illustrate the functionalities of the compulsory tasks.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    /**
     * This method is used to test input/output operations using objects and files.
     *
     * @param args: line command parameters
     * @throws IOException:             if the input/output file is not valid, an exception will be thrown.
     * @throws InvalidCatalogException: the application will signal if an input file is not valid using a custom exception
     */
    public static void main(String[] args) throws IOException {

        Main app = new Main();
        app.testCreateSave();
        app.testLoad();
    }

    /**
     * This method is used to create a list of documents.
     *
     * @return docs: list of documents.
     */
    public Set<Document> createDocs() {
        var book1 = new Document("Pride and Prejudice", "1A");
        book1.setLocation("location1");
        book1.addTag("TYPE", "BOOK");
        book1.addTag("author", "Jane Austen");
        var book2 = new Document("The Great Gatsby", "1B");
        book2.setLocation("location2");
        book2.addTag("TYPE", "BOOK");
        book2.addTag("author", "F. Scott Fitzgerald");
        var article1 = new Document("The tradition of care: Ancient Rome", "2A");
        article1.setLocation("location3");
        article1.addTag("TYPE", "ARTICLE");
        article1.addTag("year", 2023);
        var article2 = new Document("Rollo May and Erik Erikson: Psychological developments", "2B");
        article2.setLocation("location4");
        article2.addTag("TYPE", "ARTICLE");
        article2.addTag("year", 2022);
        Set<Document> docs = new HashSet<>();
        docs.add(book1);
        docs.add(book2);
        docs.add(article1);
        docs.add(article2);
        return docs;
    }

    /**
     * This method saves a catalog to an external file using JSON format.
     *
     * @throws IOException: if the output file is not valid, an exception will be thrown.
     */
    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Catalog");
        Set<Document> docs = createDocs();
        for (Document d: docs){
            catalog.add(d);
        }

        try {
            CatalogUtil.save(catalog, "documente\\catalog.json");
        } catch (IOException e) {
            System.out.println("Error saving " + e);
        }
    }

    /**
     * This method loads a catalog from an external file.
     * If the input file is not valid, an exception will be thrown.
     */
    private void testLoad() {
        Catalog catalog = new Catalog();
        try {
            catalog = CatalogUtil.load("documente\\catalog.json");
        } catch (IOException | InvalidCatalogException e) {
            System.out.println("Error loading catalog : " + e);
        }

        System.out.println(catalog);
    }

}