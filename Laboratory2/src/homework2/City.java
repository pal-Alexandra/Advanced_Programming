package homework2;
/**
 * This class describes a type of Location, therefore extends the super-class Location
 */
public class City extends Location{

    private long population;

    /**
     * This is the constructor of the class
     * @param name: Sets the name of the city
     */
    public City(String name){
        this.name = name;
    }
    /**
     * This method sets the population of the city
     * @param population: Sets the population of the city
     */
    public void setPopulation(long population){
        this.population = population;
    }

    /**
     * This method return the population of the city
     * @return this.population: the population of the city
     */
    public long getPopulation(){
        return this.population;
    }

    /**
     * This method override the Object. equals method from the super class Object of Java. Two cities are equal if their coordinates are equals.
     * @param city: the city with which I compare the current object
     * @return: result will be true or false
     */
    @Override
    public boolean equals(Object city) {
        boolean result = true;

        if (this != city) {
            if (!(city instanceof City)) {
                result = false;
            } else {
                City cityObject = (City) city;
                if ((this.getXCoordinate() != cityObject.getXCoordinate()) || (this.getYCoordinate() != cityObject.getYCoordinate())) {
                    result = false;
                }
            }
        }
        return result;
    }


}
