package laboratory2;

/**
 * @author Pal Alexandra
 * This class describe the Road part from the instance of the problem "Best Route Problem"
 */
public class Road {
    private double length;
    private double speedLimit;
    private RoadType roadType;

    /**
     * This is the default constructor of the class.
     */
    public Road() {
        this.length = 0;
        this.speedLimit = -1;
    }

    /**
     * This is another constructor of the class
     *
     * @param speedLimit: Sets the speed limit of the road
     */
    public Road(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * This is another constructor of the class
     *
     * @param roadType: Sets the type of the road
     */
    public Road(RoadType roadType) {
        this.roadType = roadType;
    }

    /**
     * This is another constructor of the class
     *
     * @param roadType:   Sets the type of the road
     * @param speedLimit: Sets the speed limit of the road
     */
    public Road(RoadType roadType, double speedLimit) {
        this.roadType = roadType;
        this.speedLimit = speedLimit;
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
     * This method returns the length of the road
     *
     * @return this.length: the length of the road (of the current object)
     */
    public double getLength() {
        return this.length;
    }

    /**
     * This method sets the type of the road
     *
     * @return this.roadType: the type of the road (of the current object): a member of the enum RoadType
     */
    public RoadType getRoadType() {
        return this.roadType;
    }

    /**
     * This method returns the speed limit of the road
     *
     * @return this.speedLimit: the speed limit of the road (of the current object)
     */
    public double getSpeedLimit() {
        return this.speedLimit;
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
}
