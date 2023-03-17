package homework3;

import java.util.HashMap;

/**
 * @author Pal Alexandra
 * This class describes a specialized person in the network.
 */
public class Programmer extends Person {
    double salary;

    /**
     * This is the constructor of the class.
     *
     * @param name: sets the name of the person
     */
    public Programmer(String name) {

        this.name = name;
        this.birthdate = "";
        this.relationships = new HashMap<Node, Relationship>();
    }

    /**
     * This method sets the salary of the programmer.
     *
     * @param salary: sets the salary of the programmer.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * This method returns the salary of the programmer.
     *
     * @return this.salary - the salary of the current programmer
     */
    public double getSalary() {
        return this.salary;
    }
}
