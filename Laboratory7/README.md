## General info
This folder contains the solution for compulsory exercices from the seventh laboratory. Solved/ unsolved tasks are checkmarked (:smile: / :confused:).

# The problem

Concurrency

Consider a map represented as a n x n square matrix, each cell being an individual location of the map.

A number of robots (agents) must explore all the cells of the matrix. They are initially located at random positions and are allowed to move in any direction inside the map. Two robots cannot be in the same cell at once.

The robots can access a shared memory containing tokens (for example, numbers from 1 to n3, shuffled). Once a robot reaches an unvisited cell it must extract n tokens and store them in the matrix cell.

A supervisor can start/pause the robots (all of them or only a specific one).

## Tasks
  * :smile: Create an object oriented model of the problem;
  * :smile: Each robot will have a name and they must perform in a concurrent manner, moving randomly around the map and extracting tokens from the shared memory when reaching an unvisited cell; 
  * :smile: A message will be displayed on the screen every time a robot visits a new cell;
  * :smile: Simulate the exploration using a thread for each robot.
