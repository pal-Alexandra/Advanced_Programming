package homework2;
/**
 * This class describes a type of Location, therefore extends the super-class Location
 */
public class Airport extends Location {
    private int numberOfTerminals;

    /**
     * This is the constructor of the class
     * @param name: Sets the name of the airport
     */
    public Airport(String name){
        this.name = name;
    }

    /**
     * This method sets the number of terminals of the airport
     * @param numberOfTerminals: Sets the number of terminals of the airport
     */
    public void setNumberOfTerminals(int numberOfTerminals){
        this.numberOfTerminals = numberOfTerminals;
    }

    /**
     * This method return the number of terminals of the airport
     * @return this.numberOfTerminals: the number of terminals of the airport
     */
    public long getNumberOfTerminals(){
        return this.numberOfTerminals;
    }

    /**
     * This method override the Object. equals method from the super class Object of Java. Two airports are equal if their coordinates are equals.
     * @param airport: the airport with which I compare the current object
     * @return: result will be true or false
     */
    @Override
    public boolean equals(Object airport) {
        boolean result = true;

        if (this != airport) {
            if (!(airport instanceof Airport)) {
                result = false;
            } else {
                Airport airportObject = (Airport) airport;
                if ((this.getXCoordinate() != airportObject.getXCoordinate()) || (this.getYCoordinate() != airportObject.getYCoordinate())) {
                    result = false;
                }
            }
        }

        return result;
    }

}
