package homework3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pal Alexandra
 * This class implement the "Persons" from the social network.
 */
public class Person implements Node, Comparable<Person> {
    protected String name;
    protected String birthdate;

    protected Map<Node, Relationship> relationships;

    /**
     * This is the default constructor of the class.
     */
    public Person() {
        this.name = "";
        this.birthdate = "";
        this.relationships = new HashMap<Node, Relationship>();

    }

    /**
     * This is the constructor of the class.
     *
     * @param name: sets the name of the person
     */
    public Person(String name) {
        this.name = name;
        this.birthdate = "";
        this.relationships = new HashMap<Node, Relationship>();

    }

    /**
     * This method sets the name of the person.
     *
     * @param name: sets the name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is used to sets the relationships of the current person.
     *
     * @param relationships: sets the mapped list of relationships
     */
    public void setRelationships(Map<Node, Relationship> relationships) {
        this.relationships.putAll(relationships);
    }

    /**
     * This method sets the birthdate of the person.
     *
     * @param birthdate: sets the birthdate of the person.
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * This method returns the birthdate of the current person.
     *
     * @return: this.birthdate the birthdate of the current person.
     */
    public String getBirthdate() {
        return this.birthdate;
    }

    /**
     * This method is used to get the mapped relationships of the current person.
     *
     * @return: this.relationships: a list of mapped relationships.
     */
    public Map<Node, Relationship> getRelationships() {
        return relationships;
    }

    /**
     * Whithin this method, this class implement the interface Node.
     *
     * @return this.name : the name of the current person
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Whithin this method, this class implement the interface java.uitl.Comparable: the comparison is made by name
     *
     * @param person the object to be compared.
     * @return 0 if this == person, <0 if this < person, >0 if this > person
     */
    @Override
    public int compareTo(Person person) {
        if (person == null)
            throw new NullPointerException();
        else if (!(person instanceof Person))
            throw new ClassCastException("Uncomparable objects!");
        else {

            Person person1 = (Person) person;
            return this.name.compareTo(person1.getName());
        }
    }

    /**
     * This method is used to add a person-to-person ("FOLLOW") relationship to the current person relationships.
     *
     * @param friend:       the person who is "FOLLOWED" by the current person
     * @param relationship: the object to describe the relationship PERSON TO PERSON
     */
    public void addFriend(Person friend, Relationship relationship) {
        this.relationships.put(friend, relationship);
    }

    /**
     * This method is used to add a person-to-company relationship to the current person relationships.
     *
     * @param company:      the company which the current person is in relationship
     * @param relationship: the object to describe the relationship person-to-company
     */
    public void addCompany(Company company, Relationship relationship) {
        this.relationships.put(company, relationship);
    }

    /**
     * This method override the Object. equals method from the super class Object of Java. Two persons are equal if they have the same name.
     *
     * @param person: the person with which I compare the current object
     * @return: result will be true or false
     */
    @Override
    public boolean equals(Object person) {
        boolean result = true;

        if (this != person) {
            if (!(person instanceof Person)) {
                result = false;
            } else {
                Person personObject = (Person) person;
                if (this.name.compareTo(personObject.getName()) == 0) {
                    result = false;
                }
            }
        }
        return result;
    }


    /**
     * This method overrides the hashCode() method from the super class Object of Java.
     *
     * @return: the hash of the current Person object
     */
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 17 * hash + this.birthdate.hashCode();

        return hash;
    }


}

