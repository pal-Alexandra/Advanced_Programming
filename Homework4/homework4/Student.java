package org.homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Pal Alexandra
 * This class describes the students from the "The Student-Project Allocation Problem"
 */
public class Student implements Comparable<Student>{
    private String name;

    private List<Project> preferences;

    /**
     * This is the constructor of the class.
     * @param name: sets the name of the current student
     */
    public Student(String name) {
        this.name = name;
        this.preferences = new ArrayList<>();
    }

    /**
     * This method sets the name of the student.
     * @param name: sets the name of the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is used to set the list of projects that are admissible for the current student.
     *
     * @param preferences: sets the list of projects that are admissible for the current student
     */
    public void setPreferences(List<Project> preferences) {
        this.preferences = preferences;
    }

    /**
     * This method is used to obtain the name of the student.
     * @return name: the name of the current student.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to obtain the list of projects that are admissible for the current student.
     * @return preferences: the list of projects that are admissible for the current student.
     */

    public List<Project> getPreferences() {
        return preferences;
    }

    /**
     * This method is used to add a project to the list of projects that are admissible for the current student.
     * @param project: the project to be added
     */
    public void addPreference(Project project){
        this.preferences.add(project);
    }

    /**
     * This method is used to obtain how many projects are admissible for the current student.
     * @return preferences.size() : the number of projects are admissible for the current student.
     */
    public int getNumberOfPreferences(){
        return this.preferences.size();
    }

    /**
     * Whithin this method, this class implements the interface Comparable (to make sure the objects of this class are comparable: the comparison is made by name)
     * @param student the object to be compared.
     * @return  0 if this == person, <0 if this < person, >0 if this > person
     */
    @Override
    public int compareTo(Student student){
        if(student == null){
            throw  new NullPointerException();
        } else if(!(student instanceof Student)){
            throw new ClassCastException("Uncomparable objects!");
        } else{
            Student student1 = (Student) student;
            return this.name.compareTo(student1.getName());
        }
    }

   /**
     * This method overrides the Object. equals method from the super class Object of Java. Two students are equal if they have the same name.
     * @param o: object to be compared with the current student
     * @return true  if this == o, false else
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    /**
     * This method overrides the Object.hashCode method from the super class Object of Java.
     * @return: the hash for the current student
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * This method overrides the Object.toString method from the super class Object of Java.
     * @return: a string which contains information about the current student.
     */
    @Override
    public String toString() {
        return "STUDENT{" +
                "name='" + name + '\'' +
                ", PREFERENCES=" + preferences +
                '}';
    }
}
