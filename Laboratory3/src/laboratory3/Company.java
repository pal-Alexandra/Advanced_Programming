
package laboratory3;

/**
 * @author Pal Alexandra
 * This class implement the "Companies" from the social network.
 */

public class Company implements Node, Comparable<Company> {
    private String name;

    /**
     * This is the constructor of the class.
     *
     * @param name: sets the name of the company
     */
    public Company(String name) {
        this.name = name;
    }

    /**
     * This method sets the name of the company.
     *
     * @param name: sets the name of the company
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Whithin this method, this class implement the interface Node.
     *
     * @return this.name : the name of the current company
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Whithin this method, this class implement the interface java.uitl.Comparable: the comparison is made by name
     *
     * @param company the object to be compared.
     * @return 0 if this == company, <0 if this < company, >0 if this > company
     */
    @Override
    public int compareTo(Company company) {
        if (company == null)
            throw new NullPointerException();
        else if (!(company instanceof Company))
            throw new ClassCastException("Uncomparable objects!");
        else {

            Company company1 = (Company) company;
            return this.name.compareTo(company1.getName());
        }
    }

}