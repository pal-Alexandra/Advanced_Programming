package homework3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pal Alexandra
 * This class implements the network from the homework task.
 */
public class Network {

    List<Person> listOfPersons;
    List<Company> listOfCompanies;

    /**
     * This is the default constructor of the class.
     */
    public Network() {
        this.listOfPersons = new ArrayList<Person>();
        this.listOfCompanies = new ArrayList<Company>();
    }

    /**
     * This is another constructor of the class.
     *
     * @param listOfPersons:   sets the persons from the network.
     * @param listOfCompanies: sets the companies from the network.
     */
    public Network(List<Person> listOfPersons, List<Company> listOfCompanies) {

        this.listOfPersons = listOfPersons;
        this.listOfCompanies = listOfCompanies;
    }

    /**
     * This method computes the importance of a person node.
     *
     * @param person: the person node to compute importance of
     * @return importance: this represents the persons the node follows + the persons following the node + the companies the node works for.
     */
    int computePersonImportance(Person person) {

        int importance = person.getRelationships().size();
        for (int i = 0; i < this.listOfPersons.size(); i++) {
            if (this.listOfPersons.get(i).compareTo(person) != 0) {
                if (this.listOfPersons.get(i).getRelationships().containsKey(person) == true) {
                    importance++;
                }
            }
        }

        return importance;
    }

    /**
     * This method computes the importance of a company node.
     *
     * @param company: the company node to compute importance of
     * @return importance: the persons who work in the company (who have a position in the company)
     */
    int computeCompanyImportance(Company company) {

        int importance = 0;
        for (int i = 0; i < this.listOfPersons.size(); i++)
            if (this.listOfPersons.get(i).getRelationships().containsKey(company) == true) {
                importance++;
            }

        return importance;
    }

    /**
     * This method is used to compute the imporance of a node from the network.
     *
     * @param node: the node to compute importance of
     * @return the importance of the node
     */

    public int computeImportance(Node node) {

        int importance;
        if (node instanceof Person) {
            Person person = (Person) node;
            importance = computePersonImportance(person);
        } else {
            Company company = (Company) node;
            importance = computeCompanyImportance(company);
        }

        return importance;

    }

    /**
     * This method is used to get the list of persons from the current network.
     *
     * @return: a list of persons.
     */
    public List<Person> getListOfPersons() {
        return this.listOfPersons;
    }

    /**
     * This method is used to get the list of companies from the current network.
     *
     * @return a list of companies.
     */
    public List<Company> getListOfCompanies() {
        return this.listOfCompanies;
    }

    /**
     * This method is used to set the persons list of the network.
     *
     * @param listOfPersons: sets the network persons list
     */
    public void setListOfPersons(List<Person> listOfPersons) {
        this.listOfPersons = listOfPersons;
    }

    /**
     * This method is used to set the company list of the network.
     *
     * @param listOfCompanies: sets the network company list
     */
    public void setListOfCompanies(List<Company> listOfCompanies) {
        this.listOfCompanies = listOfCompanies;
    }

}
