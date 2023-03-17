package homework3;


/**
 * @author Pal Alexandra
 * This class implement the "Companies" from the social network.
 */

public class Company implements Node, Comparable<Company> {
    private String name;
    private String adress;

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
     * This method sets the adress of the company.
     *
     * @param adress: sets the adress of the company
     */
    public void setAdress(String adress) {
        this.adress = adress;
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
     * This method is used to get the adress of the company.
     *
     * @return this.adress: the adress of the current company.
     */
    public String getAdress() {
        return this.adress;
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

    /**
     * This method override the Object. equals method from the super class Object of Java. Two companies are equal if they have the same name.
     *
     * @param company: the company with which I compare the current object
     * @return: result will be true or false
     */
    @Override
    public boolean equals(Object company) {
        boolean result = true;

        if (this != company) {
            if (!(company instanceof Company)) {
                result = false;
            } else {
                Company companyObject = (Company) company;
                if (this.name.compareTo(companyObject.getName()) == 0) {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * This method overrides the hashCode() method from the super class Object of Java.
     *
     * @return: the hash of the current Company object
     */
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 17 * hash + this.adress.hashCode();

        return hash;
    }
}