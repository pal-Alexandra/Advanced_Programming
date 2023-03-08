package laboratory3;

/**
 * @author Pal Alexandra
 * This class implement the "Persons" from the social network.
 */
public class Person implements Node, Comparable{
    private String name;

    /**
     * This is the constructor of the class.
     * @param name: sets the name of the person
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * This method sets the name of the person.
     * @param name: sets the name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Whithin this method, this class implement the interface Node.
     * @return this.name : the name of the current person
     */
    @Override
    public String getName(){
        return this.name;
    }

    /**
     * Whithin this method, this class implement the interface java.uitl.Comparable: the comparison is made by name
     * @param person the object to be compared.
     * @return 0 if this == person, <0 if this < person, >0 if this > person
     */
    @Override
    public int compareTo(Object person){
        if(person == null)
            throw new NullPointerException();
        else if(!(person instanceof Person))
            throw new ClassCastException("Uncomparable objects!");
        else{

            Person person1 = (Person) person;
            return this.name.compareTo(person1.getName());
        }
    }
}
