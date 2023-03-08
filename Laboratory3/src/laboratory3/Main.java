
package laboratory3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Pal Alexandra
 * This is the main class, and it is used to solve the last task from compulsory exercices.
 */
public class Main {
    public static void main(String[] args) {

        List<Node> listObjects = createList();
        printObject(listObjects);

    }

    /**
     * This method is used to create a list of node objects.
     *
     * @return: list: a list of node objects.
     */
    public static List<Node> createList() {
        List<Node> list = new ArrayList<Node>();

        list.add(new Person("P1"));
        list.add(new Company("C1"));
        list.add(new Company("C2"));
        list.add(new Person("P2"));
        list.add(new Company("C3"));
        list.add(new Person("P3"));

        return list;

    }

    /**
     * This method is used to print on the screen the name of various node objects.
     *
     * @param list: a list containg the node objects.
     */
    public static void printObject(List<Node> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }
}