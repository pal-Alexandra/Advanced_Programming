package laboratory2;

/**
 * @author Pal Alexandra
 * This class describe the Location part from the instance of the problem "Best Route Problem"
 */
public class Location {
    private String name;
    private LocationType locationType;
    private double xCoordinate, yCoordinate;

    /**
     * This is the default constructor of the class.
     */
    public Location() {
        this.name = "";
    }

    /**
     * This is another constructor of the class
     *
     * @param name: Sets the name of the location
     */
    public Location(String name) {
        this.name = name;
    }

    /**
     * This is another constructor of the class
     *
     * @param name:         Sets the name of the location
     * @param locationType: Sets the location type of the new object
     */
    public Location(String name, LocationType locationType) {
        this.name = name;
        this.locationType = locationType;
    }

    /**
     * This method sets the name of the location.
     *
     * @param name: Sets the name of the location
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method sets the location type of the new object
     *
     * @param locationType: Sets the location type of the new object
     */
    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    /**
     * This method sets the coordinates (in the cartesian coordinate system) of location
     *
     * @param x: Sets the x coordinate of the location
     * @param y: Sets the y coordinate of the location
     *           Together, the parameters x and y, identify the point, in the cartesian coordinate system, of the location
     */
    public void setCoordinates(double x, double y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    /**
     * This method returns the name of the location
     *
     * @return this.name: the name of the location
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method returns the type of the location
     *
     * @return this.locationType: the type of the location - a member of the enum LocationType
     */
    public LocationType getLocationType() {
        return this.locationType;
    }

    /**
     * This method returns the coordinate from x-axis of the cartesian coordinate system
     *
     * @return this.xCoordinate: the coordinate from x-axis of the cartesian coordinate system
     */
    public double getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     * This method returns the coordinate from y-axis of the cartesian coordinate system
     *
     * @return this.yCoordinate: the coordinate from y-axis of the cartesian coordinate system
     */
    public double getYCoordinate() {
        return this.yCoordinate;
    }

    /**
     * This method overrides the toString() method from the Object class.
     *
     * @return : This method create and return a string which consists of the all the information of the location
     */
    @Override
    public String toString() {

        return "Location: Name: " + this.name + " Type: " + this.locationType + " Coordinate x: " + this.xCoordinate
                + " y: " + this.yCoordinate + " At adress: " + System.identityHashCode(this);

    }
}
