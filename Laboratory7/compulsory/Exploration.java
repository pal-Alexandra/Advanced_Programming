package org.compulsory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class describes the exploration of the robots.
 */
public class Exploration {

    private final SharedMemory sharedMemory = new SharedMemory(5);
    private ExplorationMap map;
    private final List<Robot> robots = new ArrayList<>();

    public Exploration() {
        Cell[][] matrix = new Cell[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = new Cell();
            }
        }
        map = new ExplorationMap(matrix);

    }

    /**
     * This method is used to add a new robot to explore the map.
     *
     * @param robot: robot to be added.
     */
    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public SharedMemory getSharedMemory() {
        return sharedMemory;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    /**
     * This method creates a new thread for each robot and causes the threads to begin execution.
     */
    public void start() {
        for (Robot robot : robots) {
            Runnable runnable = robot;
            Thread robotThread = new Thread(runnable);
            robotThread.start();
        }
    }

    /**
     * This is the main function of the program.
     *
     * @param args
     */
    public static void main(String args[]) {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E", explore));
        explore.addRobot(new Robot("R2D2", explore));
        explore.addRobot(new Robot("Optimus Prime", explore));
        System.out.println("Incepem o noua rulare: ");
        explore.start();
    }


}
