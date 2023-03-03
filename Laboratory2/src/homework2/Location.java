package homework2;
/**
 * @author Pal Alexandra
 * This class describes the Location part from the instance of the problem "Best Route Problem"
 * This class is the parent class of the other location type classes
 */
public abstract class Location {
        protected String name;
        protected double xCoordinate, yCoordinate;

        /**
         * This is the default constructor of the class.
         */
        public Location(){
            this.name = "";
        }

        /**
         * This is another constructor of the class
         * @param name: Sets the name of the location
         */
        public Location(String name){
            this.name = name;
        }

        /**
         * This method sets the name of the location
         * @param name: Sets the name of the location
         */
        public void setName(String name){
            this.name = name;
        }

        /**
         * This method sets the coordinates of the location
         * @param x: Sets the x coordinate of the location
         * @param y: Sets the y coordinate of the location
         * Together, the parameters x and y, identify the point, in the cartesian coordinate system, of the location
         */
        public void setCoordinates(double x, double y){
            this.xCoordinate = x;
            this.yCoordinate = y;
        }

        /**
         * This method return the name of the location
         * @return this.name: the name of the location
         */
        public String getName(){
            return this.name;
        }

        /**
         * This method return the coordinate from x-axis of the cartesian coordinate system of the location
         * @return this.xCoordinate: the coordinate from x-axis of the cartesian coordinate system
         */
        public double getXCoordinate(){
            return this.xCoordinate;
        }

        /**
         * This method return the coordinate from y-axis of the cartesian coordinate system of the location
         * @return this.yCoordinate: the coordinate from y-axis of the cartesian coordinate system
         */
        public double getYCoordinate(){
            return this.yCoordinate;
        }

        /**
         * This method overrides the toString() method from the Object class.
         * @return : This method create and return a string which consists of the all the information of the location
         */
        @Override
        public String toString() {
            return "Location: Name: " + this.name + " Coordinate x: " + this.xCoordinate
                    + " y: " + this.yCoordinate + " At adress: " + System.identityHashCode(this);
        }

    /**
     *  This method override the Object. equals method from the super class Object of Java.
     *  This method is abstract and will be implemented by each descendant of the class Location
     */
    @Override
    public abstract boolean equals(Object o);

}
