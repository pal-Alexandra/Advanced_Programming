package homework3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pal Alexandra
 * This is the main class, and it is used to solve the last task from compulsory exercices.
 */
public class Main {
    public static void main(String[] args) {

        List<Person> personList = createPersonList();
        List<Company> companyList = createCompanyList();
        List<Relationship> relationshipsList = createRelationshipsList();

        //creating mapped relationships and assesing them to persons
        Map<Node, Relationship> relationshipMap = new HashMap<>();

        relationshipMap.put(personList.get(1), relationshipsList.get(0));
        relationshipMap.put(companyList.get(2), relationshipsList.get(1));
        personList.get(0).setRelationships(relationshipMap);
        relationshipMap.clear();

        relationshipMap.put(personList.get(2), relationshipsList.get(0));
        relationshipMap.put(personList.get(3), relationshipsList.get(0));
        relationshipMap.put(companyList.get(3), relationshipsList.get(3));
        personList.get(1).setRelationships(relationshipMap);
        relationshipMap.clear();

        relationshipMap.put(personList.get(1), relationshipsList.get(0));
        relationshipMap.put(companyList.get(1), relationshipsList.get(3));
        personList.get(2).setRelationships(relationshipMap);
        relationshipMap.clear();

        relationshipMap.put(personList.get(4), relationshipsList.get(0));
        relationshipMap.put(companyList.get(0), relationshipsList.get(1));
        personList.get(3).setRelationships(relationshipMap);
        relationshipMap.clear();

        relationshipMap.put(personList.get(3), relationshipsList.get(0));
        personList.get(4).setRelationships(relationshipMap);
        relationshipMap.clear();


        Network network = new Network(personList, companyList);

        printNetwork(network);


    }

    /**
     * This method is used to create a list of relationship
     *
     * @return relationship: list of relationship
     */
    public static List<Relationship> createRelationshipsList() {
        ArrayList<Relationship> relationships = new ArrayList<>();
        relationships.add(new PersonRelationship());
        relationships.add(new CompanyRelationship(CompanyPosition.PROGRAMMER));
        relationships.add(new CompanyRelationship(CompanyPosition.DESIGNER));
        relationships.add(new CompanyRelationship(CompanyPosition.TEAM_LEADER));

        return relationships;
    }

    /**
     * This method is used to create a list of persons.
     *
     * @return: list: a list of persons.
     */
    public static List<Person> createPersonList() {
        List<Person> list = new ArrayList<>();

        Programmer programmer = new Programmer("Programmer1");
        programmer.setBirthdate("Birthdate1");
        Designer designer = new Designer("Designer1");
        designer.setBirthdate("Birthdate2");
        list.add(programmer);
        list.add(designer);

        Person person3 = new Person("Person3");
        person3.setBirthdate("Birthdate3");
        list.add(person3);
        Person person4 = new Person("Person4");
        person4.setBirthdate("Birthdate4");
        list.add(person4);
        Person person5 = new Person("Person5");
        person5.setBirthdate("Birthdate5");
        list.add(person5);

        return list;

    }

    /**
     * This method is used to create a list of companies.
     *
     * @return: list: list of companies
     */

    public static List<Company> createCompanyList() {
        List<Company> list = new ArrayList<>();

        Company company1 = new Company("Company1");
        company1.setAdress("Adress1");
        list.add(company1);
        Company company2 = new Company("Company2");
        company2.setAdress("Adress2");
        list.add(company2);
        Company company3 = new Company("Company3");
        company3.setAdress("Adress3");
        list.add(company3);
        Company company4 = new Company("Company4");
        company4.setAdress("Adress4");
        list.add(company4);

        return list;

    }

    /**
     * This method is used to sort a list of persons according to their importance in a network.
     *
     * @param network: the network which contains the persons to be ordered
     * @return a sorted list of persons.
     */
    public static List<Person> sortPersons(Network network) {

        boolean sorted = false;
        Person temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < network.listOfPersons.size() - 1; i++) {
                if (network.computeImportance(network.listOfPersons.get(i)) < network.computeImportance(network.listOfPersons.get(i + 1))) {
                    temp = network.listOfPersons.get(i);
                    network.listOfPersons.set(i, network.listOfPersons.get(i + 1));
                    network.listOfPersons.set(i + 1, temp);
                    sorted = false;

                }
            }
        }

        return network.getListOfPersons();

    }

    /**
     * This method is used to sort a list of persons according to their importance in a network.
     *
     * @param network: the network which contains the companies to be ordered
     * @return a sorted list of companies.
     */
    public static List<Company> sortCompanies(Network network) {
        boolean sorted = false;
        Company temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < network.listOfCompanies.size() - 1; i++) {
                if (network.computeImportance(network.listOfCompanies.get(i)) < network.computeImportance(network.listOfCompanies.get(i + 1))) {
                    temp = network.listOfCompanies.get(i);
                    network.listOfCompanies.set(i, network.listOfCompanies.get(i + 1));
                    network.listOfCompanies.set(i + 1, temp);
                    sorted = false;

                }
            }
        }
        return network.getListOfCompanies();
    }

    /**
     * This method is used to print persons from a list, starting with a specified index.
     *
     * @param index:   the start index
     * @param list:    a person list to be printed
     * @param network: the network which contains the persons list
     */
    public static void printPersonsFromIndex(int index, List<Person> list, Network network) {
        for (int i = index; i < list.size(); i++) {
            int importance = network.computeImportance(list.get(i));
            System.out.println("The node: " + list.get(i).getName() + " has " + importance + " connections");
        }
    }

    /**
     * This method is used to print companies from a list, starting with a specified index.
     *
     * @param index:   the start index
     * @param list:    a company list to be printed
     * @param network: the network which contains the company list
     */
    public static void printCompaniesFromIndex(int index, List<Company> list, Network network) {
        for (int i = index; i < list.size(); i++) {
            int importance = network.computeImportance(list.get(i));
            System.out.println("The node: " + list.get(i).getName() + " has " + importance + " connections");
        }
    }

    /**
     * This method is used to print the nodes of a network and the nodes are ordered according to their importance.
     * As the importance of a person-node is calculated differently from a company-node, to print the nodes sorted by their importance, it is used a merge sort.
     *
     * @param network: the network to be printed.
     */
    public static void printNetwork(Network network) {

        List<Person> sortedPersons = sortPersons(network);
        List<Company> sortedCompany = sortCompanies(network);

        int i = 0, j = 0;
        while (i < network.listOfPersons.size() && j < network.listOfCompanies.size()) {
            int importanceI = network.computeImportance(network.listOfPersons.get(i));
            int importanceJ = network.computeImportance(network.listOfCompanies.get(j));
            if (importanceI > importanceJ) {
                System.out.println("The node: " + network.listOfPersons.get(i).getName() + " has " + importanceI + " connections");
                i++;
            } else {
                System.out.println("The node: " + network.listOfCompanies.get(j).getName() + " has " + importanceJ + " connections");
                j++;
            }
        }

        if (i < network.listOfPersons.size())
            printPersonsFromIndex(i, network.listOfPersons, network);

        if (j < network.listOfCompanies.size())
            printCompaniesFromIndex(j, network.listOfCompanies, network);
    }


}