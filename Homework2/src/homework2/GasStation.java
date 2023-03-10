package homework2;

/**
 * This class describes a type of Location, therefore extends the super-class Location
 */
public class GasStation extends Location {
    double gasPrice;

    /**
     * This is the constructor of the class
     *
     * @param name: Sets the name of the gasStation
     */
    public GasStation(String name) {
        this.name = name;
    }

    /**
     * This method sets the price of the gas
     *
     * @param gasPrice: Sets the price of the gas
     */
    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    /**
     * This method return the price of the gas
     *
     * @return this.gasPrice: the price of the gas at the current gasStation
     */
    public double getGasPrice() {
        return this.gasPrice;
    }

    /**
     * This method override the Object. equals method from the super class Object of Java. Two gasStations are equal if their coordinates are equals.
     *
     * @param gasStation: the gasStation with which I compare the current object
     * @return: result will be true or false
     */
    @Override
    public boolean equals(Object gasStation) {
        boolean result = true;

        if (this != gasStation) {
            if (!(gasStation instanceof GasStation)) {
                result = false;
            } else {
                GasStation gasStationObject = (GasStation) gasStation;
                if ((this.getXCoordinate() != gasStationObject.getXCoordinate()) || (this.getYCoordinate() != gasStationObject.getYCoordinate())) {
                    result = false;
                }
            }
        }

        return result;
    }

}
