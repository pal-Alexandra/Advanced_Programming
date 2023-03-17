package homework3;

import java.util.HashMap;

/**
 * @author Pal Alexandra
 * This class describes a specialized person in the network.
 */
public class Designer extends Person {

    private int experienceYears;

    /**
     * This is the constructor of the class.
     *
     * @param name: sets the name of the designer
     */
    public Designer(String name) {
        this.name = name;
        this.birthdate = "";
        this.relationships = new HashMap<Node, Relationship>();
    }

    /**
     * This method returns the experience.
     *
     * @return this.experienceYears - the experience of the current programmer
     */
    public int getExperienceYears() {
        return this.experienceYears;
    }

    /**
     * This method sets the experience of the designer.
     *
     * @param experienceYears: sets the experience of the designer.
     */
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
}
