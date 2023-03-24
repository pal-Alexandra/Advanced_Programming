package org.homework4;

import java.util.Objects;

/**
 * @author Pal Alexandra
 * This class describes the projects from the "The Student-Project Allocation Problem"
 */
public class Project implements Comparable<Project> {
    private String name;

    /**
     * This is the constructor of the class.
     *
     * @param name: sets the name of the current project
     */
    public Project(String name) {
        this.name = name;
    }

    /**
     * This method sets the name of the project.
     *
     * @param name: sets the name of the project.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is used to obtain the name of the project.
     *
     * @return name: the name of the current project.
     */
    public String getName() {
        return name;
    }

    /**
     * Whithin this method, this class implements the interface Comparable (to make sure the objects of this class are comparable: the comparison is made by name)
     *
     * @param project the object to be compared.
     * @return 0 if this == project, <0 if this < project, >0 if this > project
     */
    @Override
    public int compareTo(Project project) {
        if (project == null) {
            throw new NullPointerException();
        } else if (!(project instanceof Project)) {
            throw new ClassCastException("Uncomparable objects!");
        } else {
            Project project1 = (Project) project;
            return this.name.compareTo(project1.getName());
        }
    }

    /**
     * This method overrides the Object. equals method from the super class Object of Java. Two projects are equal if they have the same name.
     *
     * @param o: object to be compared with the current project
     * @return true  if this == o, false else
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name);
    }

    /**
     * This method overrides the Object.hashCode method from the super class Object of Java.
     *
     * @return: the hash for the current project
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * This method overrides the Object.toString method from the super class Object of Java.
     *
     * @return: a string which contains information about the current project.
     */

    @Override
    public String toString() {
        return "PROJECT{" +
                "name='" + name + '\'' +
                '}';
    }
}
