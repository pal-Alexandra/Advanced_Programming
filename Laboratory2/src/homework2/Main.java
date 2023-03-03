package homework2;

/**
 * This is the Main class. It is used to illustrate the functionalities that have been implemented.
 */
public class Main {
    public static void main(String[] args) {

        City city = new City("Iasi");
        city.setCoordinates(10.1, 27.5);
        city.setPopulation(800_083);

        Airport airport = new Airport("Aeroport_Bacau");
        airport.setCoordinates(21.3, 23.5);
        airport.setNumberOfTerminals(2);

        GasStation gasStation = new GasStation("Petrom_Galati");
        gasStation.setCoordinates(50.2, 25.8);
        gasStation.setGasPrice(5.7);

        Road road1 = new Road();
        road1.setIdRoad("1");
        road1.setRoadType(RoadType.HIGHWAY);
        road1.setLength(3.0);
        road1.setSpeedLimit(140);
        road1.addLocation(city);
        road1.addLocation(airport);  //this road will not be valid because the distance between city -> airport > road1.length
        //road1.printLocationCrossed();

        Road road2 = new Road();
        road2.setIdRoad("2");
        road2.setRoadType(RoadType.EXPRESS);
        road2.setLength(30.0);
        road2.setSpeedLimit(140);
        road2.addLocation(airport);
        road2.addLocation(gasStation); //this road will be valid because the distance between airport->gasStation < road2.length
        //road2.printLocationCrossed();

        ProblemInstance instance1 = new ProblemInstance();
        instance1.setInstanceNumber(1);
        instance1.addLocation(city);
        instance1.addLocation(airport);
        instance1.addLocation(gasStation);
        instance1.addRoad(road1);

        ProblemInstance instance2 = new ProblemInstance();
        instance2.setInstanceNumber(2);
        instance2.addLocation(city);
        instance2.addLocation(city);
        instance2.addLocation(gasStation);
        instance2.addRoad(road1);


        ProblemInstance instance3 = new ProblemInstance();
        instance3.setInstanceNumber(3);
        instance3.addLocation(city);
        instance3.addLocation(airport);
        instance3.addLocation(gasStation);
        instance3.addRoad(road2);
        instance3.addRoad(road2);


        instance1.checkValidityOfInstance();
        instance2.checkValidityOfInstance();
        instance3.checkValidityOfInstance();

        System.out.println("Exit program");
        
    }
}