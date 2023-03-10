package homework2;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

/**
 * This is the Main class. It is used to illustrate the functionalities that have been implemented.
 */
public class Main {

    /**
     * This method is used for create some locations and put them in an array.
     *
     * @return: an array containg the locations that have been created
     */
    public static Location[] createLocations() {
        Location[] locations = new Location[6];

        City city1 = new City("Iasi");
        city1.setCoordinates(10.1, 27.5);
        city1.setPopulation(800_083);
        locations[0] = city1;

        Airport airport = new Airport("Aeroport_Bacau");
        airport.setCoordinates(21.3, 23.5);
        airport.setNumberOfTerminals(2);
        locations[1] = airport;

        GasStation gasStation = new GasStation("Petrom_Galati");
        gasStation.setCoordinates(50.2, 25.8);
        gasStation.setGasPrice(5.7);
        locations[2] = gasStation;

        City city2 = new City("Botosani");
        city2.setCoordinates(13.4, 33.2);
        city2.setPopulation(100_083);
        locations[3] = city2;

        City city3 = new City("Cluj");
        city3.setCoordinates(8.1, 12.5);
        city3.setPopulation(900_083);
        locations[4] = city3;

        City city4 = new City("Brasov");
        city4.setCoordinates(6.1, 15.5);
        city4.setPopulation(500_083);
        locations[5] = city4;

        return locations;

    }

    /**
     * This method is used for create some roads between the given locations and put them in an array.
     *
     * @param locations: the possible ends of the roads
     * @return: roads[]: an array containg the roads that have been created
     */
    public static Road[] createRoads(Location[] locations) {
        Road[] roads = new Road[4];
        for (int i = 0; i < 4; i++) {
            roads[i] = new Road();
        }

        Road road1 = new Road();
        road1.setIdRoad("1");
        road1.setRoadType(RoadType.HIGHWAY);
        road1.setLength(3.0);
        road1.setSpeedLimit(140);
        road1.setEndPoints(locations[0], locations[1]); //this road will not be valid because the distance between city -> airport > road1.length
        roads[0] = road1;

        Road road2 = new Road();
        road2.setIdRoad("2");
        road2.setRoadType(RoadType.EXPRESS);
        road2.setLength(30.0);
        road2.setSpeedLimit(140);
        road2.setEndPoints(locations[1], locations[2]); //this road will be valid because the distance between airport->gasStation < road2.length
        roads[1] = road2;

        Road road3 = new Road();
        road3.setIdRoad("3");
        road3.setRoadType(RoadType.HIGHWAY);
        road3.setLength(80.0);
        road3.setSpeedLimit(140);
        road3.setEndPoints(locations[2], locations[3]);
        roads[2] = road3;

        Road road4 = new Road();
        road4.setIdRoad("4");
        road4.setRoadType(RoadType.HIGHWAY);
        road4.setLength(80.0);
        road4.setSpeedLimit(140);
        road4.setEndPoints(locations[3], locations[5]);
        roads[3] = road4;

        return roads;
    }

    /**
     * This method is used for create some instances of the problem.
     *
     * @param locations: the possible locations given for an instance
     * @param roads:     the possible roads given for an instance
     * @return instances: an array containing the instances that have been created
     */
    public static ProblemInstance[] createProblemInstace(Location[] locations, Road[] roads) {
        ProblemInstance[] instances = new ProblemInstance[3];
        for (int i = 0; i < 3; i++) {
            instances[i] = new ProblemInstance();
        }

        instances[0].setInstanceNumber(1);
        for (int i = 0; i < locations.length; i++) {
            instances[0].addLocation(locations[i]);
        }
        instances[0].addRoad(roads[0]);

        instances[1].setInstanceNumber(2);
        instances[1].addLocation(locations[0]);
        instances[1].addLocation(locations[0]);
        instances[1].addLocation(locations[2]);
        instances[1].addRoad(roads[0]);

        instances[2].setInstanceNumber(3);
        for (int i = 0; i < locations.length; i++) {
            instances[2].addLocation(locations[i]);
        }
        instances[2].addRoad(roads[1]);
        instances[2].addRoad(roads[1]);
        instances[2].addRoad(roads[2]);
        instances[2].addRoad(roads[3]);

        return instances;
    }

    public static void main(String[] args) {

        Location[] locations = createLocations();
        Road[] roads = createRoads(locations);

        
        ProblemInstance[] instances = createProblemInstace(locations, roads);
        instances[0].checkValidityOfInstance();
        instances[1].checkValidityOfInstance();
        instances[2].checkValidityOfInstance();

        GraphLocation graph = new GraphLocation(instances[2]);
        graph.determineAccessibility(locations[1], locations[3]);
        graph.determineAccessibility(locations[2], locations[5]);
        graph.determineAccessibility(locations[0], locations[5]);

        System.out.println("Exit program");

    }
}