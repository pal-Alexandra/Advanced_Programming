## General info
This folder contains the solution for the seventh homework. Solved/ unsolved tasks are checkmarked (:smile: / :confused:).

# The problem

Concurrency

Consider a map represented as a n x n square matrix, each cell being an individual location of the map.

A number of robots (agents) must explore all the cells of the matrix. They are initially located at random positions and are allowed to move in any direction inside the map. Two robots cannot be in the same cell at once.

The robots can access a shared memory containing tokens (for example, numbers from 1 to n3, shuffled). Once a robot reaches an unvisited cell it must extract n tokens and store them in the matrix cell.

A supervisor can start/pause the robots (all of them or only a specific one).

## Tasks
  * :smile: Implement the commands that start/pause the robots (all of them or only a specific one). A robot can be paused for a specific time or indefinitely, requiring a start command.
The commands must be given using the keyboard;
  * :smile: Design an algorithm such that each robots will try to explore the map in a systematic fashion, ensuring the termination of the exploration process;
  * :smile: Implement a timekeeper thread that runs concurrently with the player threads, as a daemon. This thread will display the running time of the exploration and it will stop it exceeds a certain time limit;
  * :smile: At the end of the exploration, determine how many tokens each robot has placed in the matrix.
