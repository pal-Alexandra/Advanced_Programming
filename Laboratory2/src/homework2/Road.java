package homework2;
/**
 * @author Pal Alexandra
 * This class describe the Road part from the instance of the problem "Best Route Problem"
 * This class is the parent class of the other road type classes
 */
public class Road {
    private String idRoad;
    private double length;
    private double speedLimit;
    private RoadType roadType;

    Location[] crossedLocations;
    private int countCrossedLocations;
    private int memoryCrossedLocations;

    /**
     * This is the default constructor of the class.
     */
    public Road() {
        this.memoryCrossedLocations = 100;
        this.countCrossedLocations = 0;
        this.crossedLocations = new Location[memoryCrossedLocations];
        this.length = 0;
        this.speedLimit = -1;
    }

    /**
     * This is another constructor of the class
     * @param idRoad: Sets the id of the road
     */
    public Road(String idRoad) {
        this.idRoad = idRoad;
    }

    /**
     * This method sets the length of the road
     * @param length: Sets the length of the road
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * This method sets the type of the road
     * @param roadType: Sets the type of the road
     */
    public void setRoadType(RoadType roadType) {
        this.roadType = roadType;
    }

    /**
     * This method sets the speed limit of the road
     * @param speedLimit: Sets the speed limit of the road
     */
    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * This method sets the id of the road
     * @param idRoad: Sets the speed limit of the road
     */
    public void setIdRoad(String idRoad) {
        this.idRoad = idRoad;
    }

    /**
     * This method return the length of the road
     * @return this.length: the length of the road (of the current object)
     */
    public double getLength() {
        return this.length;
    }

    /**
     * This method return the type of the road
     * @return this.roadType: the type of the road (of the current object): a member of the enum RoadType
     */
    public RoadType getRoadType() {
        return this.roadType;
    }

    /**
     * This method return the speed limit of the road
     * @return this.speedLimit: the speed limit of the road (of the current object)
     */
    public double getSpeedLimit() {
        return this.speedLimit;
    }

    /**
     * This method return the id of the road
     * @return this.idRoad: the id of the road (of the current object)
     */
    public String getIdRoad() {
        return this.idRoad;
    }

    /**
     * This method return the number of locations that the road crosses
     * @return this.countCrossedLocations: the number of locations that the road crosses
     */
    public int getCountCrossedLocations() {
        return this.countCrossedLocations;
    }

    /**
     * This method adds a new location in the locations (crossed by the road) array.
     * @param location: the location to be added
     */
    public void addLocation(Location location) {

        if (this.countCrossedLocations == this.memoryCrossedLocations)
            this.resizeMemoryLocations();

        this.crossedLocations[countCrossedLocations] = location;
        this.countCrossedLocations++;
    }

    /**
     * This method will resize the memory of the locations array . If the number of locations gets to be equal to the array dimension, then this method will be called, and it will double the array dimension.
     */
    public void resizeMemoryLocations() {

        Location[] auxLocations = new Location[2 * this.memoryCrossedLocations];

        for (int i = 0; i < countCrossedLocations; i++)
            auxLocations[i] = this.crossedLocations[i];

        this.memoryCrossedLocations = 2 * this.memoryCrossedLocations;
        this.crossedLocations = new Location[memoryCrossedLocations];
        for (int i = 0; i < countCrossedLocations; i++)
            this.crossedLocations[i] = auxLocations[i];
    }

    /**
     * This method print information about the locations that the road crosses
     */
    public void printLocationCrossed(){

        for(int i=0; i<this.countCrossedLocations; i++){
            System.out.println(this.crossedLocations[i].toString());
        }
    }

    /**
     * This method overrides the toString() method from the Object class.
     * @return : This method create and return a string which consists of the all the information of the road
     */
    @Override
    public String toString() {
        return "Road: Type: " + this.roadType + " Length: " + this.length + " SpeedLimit: " + this.speedLimit +
                " At adress: " + System.identityHashCode(this);
    }

    /**
     * This method override the Object. equals method from the super class Object of Java. Two roads are equal if their id-s are equal.
     * @param road: the road with which I compare the current object
     * @return: result will be true or false
     */
    @Override
    public boolean equals(Object road) {
        boolean result = true;
        if (this != road) {
            if (!(road instanceof Road)) {
                result = false;
            } else {
                Road roadObject = (Road) road;
                if ((this.getIdRoad() != roadObject.getIdRoad()) || (this.getIdRoad() != roadObject.getIdRoad())) {
                    result = false;
                }
            }
        }
        return result;
    }
}
