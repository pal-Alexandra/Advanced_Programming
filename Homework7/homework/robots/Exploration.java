package org.homework.robots;

/**
 * @author Pal Alexandra
 * This class describes the exploration of the robots.
 */

import lombok.Data;
import org.homework.other.SharedMemory;
import org.homework.map.Cell;
import org.homework.map.ExplorationMap;

import java.util.ArrayList;
import java.util.List;

@Data
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

}
