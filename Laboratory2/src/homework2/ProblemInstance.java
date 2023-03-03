package homework2;
import java.lang.Math;
/**
 * This class describes an instance of the problem: Best Route Problem (from one location to another).
 */
public class ProblemInstance {

    private int instanceNumber;
    Location[] locations;
    int countLocations;
    int memoryLocations;

    Road[] roads;
    int countRoads;
    int memoryRoads;

    /**
     * This is the default constructor of the class
     */
    public ProblemInstance(){
        memoryLocations = 100;
        locations = new Location[memoryLocations];
        countLocations = 0;
        memoryRoads = 100;
        roads = new Road[memoryRoads];
        countRoads = 0;
    }

    /**
     * This method sets the number (placeholder for an ID) of the instance
     * @param n: sets the number of the instance
     */
    public void setInstanceNumber(int n){
        this.instanceNumber = n;
    }

    /**
     * This method check if a given location exists in the problem or not.
     * @param location : the location to be checked
     * @return result: true if the given location exists in the problem, false otherwise
     */
    public boolean existsLocation(Location location){
        boolean result = false;
        for(int i=0; i<countLocations; i++)
            if(this.locations[i].equals(location) == true){
                result = true;
                return result;
            }

        return result;
    }

    /**
     * This method check if a given road exists in the problem or not.
     * @param road : the road to be checked
     * @return result: true if the given road exists in the problem, false otherwise
     */
    public boolean existsRoad(Road road){
        boolean result = false;
        for(int i=0; i<countRoads; i++)
            if(this.roads[i].equals(road) == true){
                result = true;
                return result;
            }

        return result;
    }

    /**
     * This method tries to add a new location in the problem. If the new location already exists in the problem, then a message will pe printed.
     * @param location: the location to be added
     */
    public void addLocation(Location location){

        if(this.existsLocation(location) == false){

            if(this.countLocations == this.memoryLocations)
                this.resizeMemoryLocations();
            this.locations[countLocations] = location;
            this.countLocations++;

        }else{
            System.out.println("[instance " + this.instanceNumber + "] " + "You cannot add this locations because it already exists in the problem");
        }
    }

    /**
     * This method will resize the memory of the locations array . If the number of locations gets to be equal to the array dimension, then this method will be called, and it will double the array dimension.
     */
    public void resizeMemoryLocations(){

        Location[] auxLocations = new Location[2*this.memoryLocations];

        for(int i =0; i<countLocations; i++)
            auxLocations[i] = this.locations[i];

        this.memoryLocations = 2*this.memoryLocations;
        this.locations = new  Location[memoryLocations];
        for(int i =0; i<countLocations; i++)
            this.locations[i] = auxLocations[i];
    }
    /**
     * This method tries to add a new road in the problem. If the new road already exists in the problem, then a message will pe printed.
     * @param road: the road to be added
     */
    public void addRoad(Road road){

        if(this.existsRoad(road) == false){
            if(this.countRoads == this.memoryRoads){
                this.resizeMemoryRoads();
            }
            this.roads[countRoads] = road;
            this.countRoads++;
        }else{
            System.out.println("[instance " + this.instanceNumber + "] " + "You cannot add this road because it already exists in the problem");
        }
    }
    /**
     * This method will resize the memory of the roads array . If the number of roads gets to be equal to the array dimension, then this method will be called, and it will double the array dimension.
     */
    public void resizeMemoryRoads(){

        Road[] auxRoads = new Road[2*this.memoryRoads];

        for(int i =0; i<countLocations; i++)
            auxRoads[i] = this.roads[i];

        this.memoryRoads = 2*this.memoryRoads;
        this.roads = new  Road[memoryRoads];
        for(int i =0; i<countRoads; i++)
            this.roads[i] = auxRoads[i];
    }

    /**
     * This method check if the current instance of the problem is valid. The instance is valid if for each road, the road length is greater than the euclidian distance between every 2 location coordinates that the road crosses
     * This print appropriate messages for each case.
     */
    public void checkValidityOfInstance(){
        boolean result = true;
        for(int i=0; i<this.countRoads && result == true; i++){
            for(int j=0; j<this.roads[i].getCountCrossedLocations()-1 && result==true; j++){
                for (int k=j+1; k<this.roads[i].getCountCrossedLocations() && result==true; k++){
                    double distance = this.computeDistanceBetweenLocations(this.roads[i].crossedLocations[j], this.roads[i].crossedLocations[k]);
                    if (distance > this.roads[i].getLength()) {
                        result = false;
                        System.out.println("[instance " + this.instanceNumber + "] " + "A road with length less than the euclidian distance between the 2 location coordinates was found. Therefore this instance is not valid");
                    }
                }
            }
        }

        if(result == true)
            System.out.println("[instance " + this.instanceNumber + "] " + "This instance of the problem is valid");
    }

    /**
     * This method computes the euclidian distance between 2 location coordinates
     * @param l1: first location
     * @param l2: second location
     * @return distance: the euclidian distance between l1 and l2 coordinates
     */
    public double computeDistanceBetweenLocations(Location l1, Location l2){
        double cathetus1 = Math.abs(l1.getXCoordinate() - l2.getXCoordinate());
        double cathetus2 = Math.abs(l1.getYCoordinate() - l2.getYCoordinate());
        double distance = Math.sqrt(Math.pow(cathetus1,2) + Math.pow(cathetus2,2));
        return  distance;
    }
}
