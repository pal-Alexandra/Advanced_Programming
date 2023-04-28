package org.homework.robots;

/**
 * @author Pal Alexandra
 * This class describes the robot.
 */


import lombok.Data;

import java.util.Random;
import java.util.Stack;

@Data
public class Robot implements Runnable {

    private final Object pauseLock = new Object();
    private boolean paused = true;
    private String name;
    private boolean running;
    Exploration explore;

    //the robot explores the map in a DFS manner
    private Stack<int[]> stackForPositions;

    private int countTokens;


    public Robot(String name, Exploration exploration) {
        this.name = name;
        this.running = true;
        this.countTokens = 0;
        this.stackForPositions = new Stack<>();
        this.explore = exploration;
    }


    /**
     * This method describe the code executed by every new thread.
     * The robot tries to visit a new cell of the matrix.
     * The exploration is made in a DFS manner.
     */
    public void run() {

        Random random = new Random();
        int startI = random.nextInt(5);
        int startJ = random.nextInt(5);
        stackForPositions.push(new int[]{startI, startJ});
        while (running) {


            synchronized (pauseLock) {
                if (!running) //while waiting to synchronize on pauseLock, the running variable may have changed
                    break;

                if (paused) {
                    try {
                        pauseLock.wait(); //if the robot is paused, then it will wait until the lock-paused is released

                    } catch (InterruptedException exception) {
                        break;
                    }

                    if (!running) //since the robot has been paused, the running variable may have changed
                        break;
                }
            }

            //trying to visit cells in DFS manner
            boolean visit = false;
            while (!visit && !stackForPositions.isEmpty()) {
                int currentPosition[] = stackForPositions.pop();
                int i = currentPosition[0];
                int j = currentPosition[1];
                visit = explore.getMap().visit(i, j, this);

                if (visit == true) {
                    this.countTokens += 5;
                }

                if (i > 0 && !explore.getMap().isCellVisited(i - 1, j)) {
                    stackForPositions.push(new int[]{i - 1, j});
                }

                if (i < explore.getMap().getMatrix().length - 1 && !explore.getMap().isCellVisited(i + 1, j)) {
                    stackForPositions.push(new int[]{i + 1, j});
                }

                if (j > 0 && !explore.getMap().isCellVisited(i, j - 1)) {
                    stackForPositions.push(new int[]{i, j - 1});
                }

                if (j < explore.getMap().getMatrix().length - 1 && !explore.getMap().isCellVisited(i, j + 1)) {
                    stackForPositions.push(new int[]{i, j + 1});
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            running = false;
            if (!this.getExplore().getMap().isComplet()) {
                running = true;
            } else {
                System.out.println(this.name + "has placed in the map " + this.countTokens + "tokens");
            }

        }
    }

    /**
     * This method is used to release the lock (paused-lock) from a paused robot.
     */
    public void restart() {
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notifyAll();
        }
    }

    /**
     * This method is used to set the paused-lock.
     */
    public void pause() {
        paused = true;
    }

    public boolean isPaused() {
        return paused;
    }
}
























