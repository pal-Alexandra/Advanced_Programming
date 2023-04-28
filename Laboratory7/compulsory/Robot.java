package org.compulsory;

/**
 * @author Pal Alexandra
 * This class describes the robot.
 */


import java.util.Random;


public class Robot implements Runnable {

    private String name;
    private boolean running;
    Exploration explore;

    public Robot(String name, Exploration exploration) {
        this.name = name;
        explore = exploration;
        running = true;
    }

    public String getName() {
        return name;
    }

    public boolean isRunning() {
        return running;
    }

    public Exploration getExplore() {
        return explore;
    }

    /**
     * This method describe the code executed by every new thread.
     * The robot tries to visit a new cell of the matrix.
     */
    public void run() {

        while (running) {
            boolean visit = false;
            while (!visit) {
                Random random = new Random();
                int x = random.nextInt(5);
                int y = random.nextInt(5);
                visit = explore.getMap().visit(x, y, this);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            running = false;
            if (!this.getExplore().getMap().isComplet())
                running = true;
        }


    }


}





















