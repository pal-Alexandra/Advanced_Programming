package org.homework.system;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Pal Alexandra
 * This class is used to describe the Document part from the Document Management System
 */
public class Document implements Serializable {

    protected String id;
    protected String title;
    protected String location;

    protected Map<String, Object> tags;

    /**
     * This is the default constructor of the class.
     */
    public Document() {
        this.title = "";
        this.id = "";
        this.location = "";
        this.tags = new HashMap<>();
    }

    /**
     * This is another constructor of the class.
     *
     * @param title: sets the title of the document
     * @param id:    sets the id of the document
     */
    public Document(String title, String id) {
        this.title = title;
        this.id = id;
        this.location = "";
        this.tags = new HashMap<>();
    }

    /**
     * This method is used to set the id of the document
     *
     * @param id: sets the id of the document
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method is used to set the title of the document
     *
     * @param title: sets the id of the document
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method is used to set the path in the local file system or the link to an external URL of the document
     *
     * @param location: sets the path/link of the document
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * This method is used to set the tags of a document
     *
     * @param tags: sets the tags of a document
     */
    public void setTags(Map<String, Object> tags) {
        this.tags.putAll(tags);
    }

    /**
     * This method is used to provide the id of the document
     *
     * @return: the id of the document
     */
    public String getId() {
        return id;
    }

    /**
     * This method is used to provide the title of the document
     *
     * @return: the title of the document
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method is used to provide the location of the document
     *
     * @return: the location of the document
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method is used to provide the tags of the document
     *
     * @return: the tags of the document
     */
    public Map<String, Object> getTags() {
        return new HashMap<>(tags);
    }

    /**
     * This method is used to add a new tag to a document.
     *
     * @param key: the key of the tag
     * @param obj: the value of the key
     */
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    /**
     * This method overrides the toString() method from the Object class.
     *
     * @return: a string which contains information about the document.
     */
    @Override
    public String toString() {
        return "\tDocument{\n" +
                "\t\tid= " + id + '\n' +
                "\t\ttitle= " + title + '\n' +
                "\t\tlocation= " + location + '\n' +
                "\t\ttags= " + tags + " }" +
                "\n\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id) && Objects.equals(title, document.title) && Objects.equals(location, document.location) && Objects.equals(tags, document.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, location, tags);
    }
}
