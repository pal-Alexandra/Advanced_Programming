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

    Location[] endPoints;

    /**
     * This is the default constructor of the class.
     */
    public Road() {
        this.endPoints = new Location[2];
        this.length = 0;
        this.speedLimit = -1;
    }

    /**
     * This is another constructor of the class
     *
     * @param idRoad: Sets the id of the road
     */
    public Road(String idRoad) {
        this.idRoad = idRoad;
    }

    /**
     * This method sets the length of the road
     *
     * @param length: Sets the length of the road
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * This method sets the type of the road
     *
     * @param roadType: Sets the type of the road
     */
    public void setRoadType(RoadType roadType) {
        this.roadType = roadType;
    }

    /**
     * This method sets the speed limit of the road
     *
     * @param speedLimit: Sets the speed limit of the road
     */
    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * This method sets the id of the road
     *
     * @param idRoad: Sets the speed limit of the road
     */
    public void setIdRoad(String idRoad) {
        this.idRoad = idRoad;
    }

    /**
     * This method sets the ends of the road.
     *
     * @param l1: the start point of the road
     * @param l2: the start point of the road
     */
    public void setEndPoints(Location l1, Location l2) {

        this.endPoints[0] = l1;
        this.endPoints[1] = l2;
    }

    /**
     * This method return the length of the road
     *
     * @return this.length: the length of the road (of the current object)
     */
    public double getLength() {
        return this.length;
    }

    /**
     * This method return the type of the road
     *
     * @return this.roadType: the type of the road (of the current object): a member of the enum RoadType
     */
    public RoadType getRoadType() {
        return this.roadType;
    }

    /**
     * This method return the speed limit of the road
     *
     * @return this.speedLimit: the speed limit of the road (of the current object)
     */
    public double getSpeedLimit() {
        return this.speedLimit;
    }

    /**
     * This method return the id of the road
     *
     * @return this.idRoad: the id of the road (of the current object)
     */
    public String getIdRoad() {
        return this.idRoad;
    }

    /**
     * This method overrides the toString() method from the Object class.
     *
     * @return : This method create and return a string which consists of the all the information of the road
     */
    @Override
    public String toString() {
        return "Road: Type: " + this.roadType + " Length: " + this.length + " SpeedLimit: " + this.speedLimit +
                " At adress: " + System.identityHashCode(this);
    }

    /**
     * This method override the Object. equals method from the super class Object of Java. Two roads are equal if their id-s are equal.
     *
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
