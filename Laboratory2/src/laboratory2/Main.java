package laboratory2;

/**
 * This is the Main class which is used for illustrate the functionalities of the classes Road and Location
 */
public class Main {
    public static void main(String[] args) {

        Location location1 = new Location();
        location1.setName("FirstLocation");
        location1.setLocationType(LocationType.CITY);
        location1.setCoordinates(1.0, 4.5);
        System.out.println(location1.toString());

        Location location2 = new Location("SecondLocation");
        location2.setLocationType(LocationType.AIRPORT);
        location2.setCoordinates(11.0, 13.0);
        System.out.print("Location: ");
        System.out.print(" " + location2.getName());
        System.out.print(" " + location2.getLocationType());
        System.out.print(" Coordinates: x: " + location2.getXCoordinate() + " y: " + location2.getYCoordinate());
        System.out.print("\n");

        Road road1 = new Road();
        road1.setLength(9.0);
        road1.setRoadType(RoadType.COUNTRY);
        road1.setSpeedLimit(80.0);
        System.out.println(road1.toString());

        Road road2 = new Road(RoadType.HIGHWAY);
        road2.setLength(300.0);
        road2.setSpeedLimit(120.0);
        System.out.println("Road: RoadType: " + road2.getRoadType() + " Length: " + road2.getLength() +
                " SpeedLimit: " + road2.getSpeedLimit());

    }
}