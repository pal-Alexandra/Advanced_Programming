## General info
This folder contains the solution for compulsory exercices from the second laboratory. Solved/ unsolved tasks are checkmarked (:smile: / :confused:).

# The problem
An instance of the "Best Route Problem" consists of locations and roads. Locations may be cities, airports, gas stations, etc.

Two locations may be connected by a road, or not. Roads may be highways, express, country, etc.

Each location has a name, type and x, y coordinates (assume that the locations are placed in a cartesian coordinate system).

Each road has a type, length and a speed limit. The length of a road should not be less than the euclidian distance between the location coordinates.

We consider the problem of determining the "best" route from one location to another.

## Tasks
  * :smile: Create a class that describes an instance of the problem;
  * :smile: Override the Object.equals method for the Location and Road classes. The problem should not allow adding the same location or road twice;
  * :smile: Instead of using an enum, create dedicated classes either for locations: cities, air ports, gas stations etc. or roads: highway, express, country, etc. Each concrete location class may have additional specific propertes (population, number of terminals, gas price, etc.);
  * :smile: Implement a method that determines if a problem's instance is valid;
  * :smile: Implement an algorithm for determining if it is possible to go from one location to another using the given roads;
  * :smile: Write doc comments in your source code and generate the class documentation using javadoc.
