package homework2;

import java.util.*;

/**
 * This class describe the given roads and locations of a certain instance as a graph where the locations are nodes and the roads are edges (undirected).
 */
public class GraphLocation {

    private ProblemInstance instance;

    Map<Location, ArrayList<Location>> adjLocations;

    /**
     * This is the constructor of the class.
     *
     * @param instance: the instance problem containg the locations and the roads to be modeled as a graph. This constructor describes (creates) the graph by the adjacency lis.t
     */
    GraphLocation(ProblemInstance instance) {
        this.instance = instance;
        this.adjLocations = new HashMap<Location, ArrayList<Location>>();

        for (int i = 0; i < instance.getCountLocations(); i++) {
            this.adjLocations.put(instance.locations[i], new ArrayList<Location>());
        }

        for (int i = 0; i < this.instance.getCountRoads(); i++) {
            this.adjLocations.get(this.instance.roads[i].endPoints[0]).add(this.instance.roads[i].endPoints[1]);
            this.adjLocations.get(this.instance.roads[i].endPoints[1]).add(this.instance.roads[i].endPoints[0]);
        }
    }

    /**
     * This method is used to determine if f is possible to go from one location to another using the given roads.
     *
     * @param l1: the start location
     * @param l2: the destination location
     */
    public void determineAccessibility(Location l1, Location l2) {

        if(this.instance.checkValidityOfInstance() == true){

            if (l1.equals(l2))
                System.out.println(l1.getName() + " is reachable from " + l2.getName());
            else {

                //this array will contain the visited locations
                ArrayList<Location> visited = new ArrayList<Location>();

                //queue for BFS
                LinkedList<Location> queue = new LinkedList<Location>();
                ;

                //mark l1 as visited
                visited.add(l1);

                //add l1 to BFS queue
                queue.add(l1);
                //Iterator<Location> i;
                Location temp;
                boolean stop;
                stop = false;
                int COUNTER = 0;
                while (queue.size() != 0 && stop == false) {
                    //dequeue a vertex from queue

                    temp = queue.poll();
                    //System.out.println("\t" + COUNTER++ + " " + temp.getName());
                    ArrayList<Location> adjTemp = adjLocations.get(temp);
                    for (int i = 0; i < adjTemp.size(); i++) {

                        //System.out.println(adjTemp.get(i).getName());
                        if (adjTemp.get(i).equals(l2)) {
                            System.out.println(l2.getName() + " is reachable from " + l1.getName());
                            stop = true;
                        }

                        if (!visited.contains(adjTemp.get(i))) {
                            queue.add(adjTemp.get(i));
                            visited.add(adjTemp.get(i));
                        }
                    }
                }

                if (stop == false) {
                    System.out.println(l2.getName() + " IS NOT reachable from " + l1.getName());
                }
            }

        } else{
            System.out.println("This graph is build based on a instance that's not valid, therefore, " + l2.getName() + " IS NOT reachable from " + l1.getName() );
        }

    }

}
