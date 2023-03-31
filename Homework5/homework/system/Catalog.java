package org.homework.system;


import java.io.Serializable;
import java.util.*;

/**
 * @author Pal Alexandra
 * This class is used to describe the Catalog part from the Document Management System
 */
public class Catalog implements Serializable {

    private String name;
    private Set<Document> docs;

    /**
     * This is the default constructor of the class.
     */
    public Catalog() {
        this.name = "";
        this.docs = new TreeSet<>();
    }

    /**
     * This is another constructor of the class.
     *
     * @param name: sets the name of the catalog.
     */
    public Catalog(String name) {
        this.name = name;
        this.docs = new HashSet<>();
    }

    /**
     * This method is used to set the name of the catalog.
     *
     * @param name: sets the name of the catalog.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is used to set the entries of the catalog.
     *
     * @param docs: a list of documents.
     */
    public void setDocs(Set<Document> docs) {
        this.docs = docs;
    }

    /**
     * This method is used to provide the name of the catalog.
     *
     * @return : the name of the catalog
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to provide the documents of the catalog.
     *
     * @return : the name of the documents of the catalog.
     */
    public Set<Document> getDocs() {
        return new HashSet<>(docs);
    }

    /**
     * This method id used to add a new entry into the catalog.
     *
     * @param document: the entry to be added.
     */
    public void add(Document document) {
        if (docs.contains(document)) {
            System.out.println("Catalog already contains this document. Ignoring.");
        } else {
            this.docs.add(document);
        }

    }

    /**
     * This method overrides the toString() method from the Object class.
     *
     * @return: a string which contains information about the catalog.
     */
    @Override
    public String toString() {
        return "Catalog: " +
                "name= " + name + '\n' +
                "docs=" + docs +
                "\n";
    }
}
