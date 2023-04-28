package org.homework.other;

/**
 * @author Pal Alexandra
 * This class describe a  timekeeper thread that runs concurrently with the player threads, as a daemon.
 * This thread will display the running time of the exploration, and it will stop it exceeds a certain time limit.
 */
public class Timekeeper extends Thread {
    private long timeLimit;

    public Timekeeper(long timeLimit) {
        this.timeLimit = timeLimit;
        setDaemon(true);
    }

    /**
     * This method displays the running time of the exploration (every 6 seconds).
     * If the time limit is crossed, then this method will end the exploration.
     */
    public void run() {

        long startTime = System.currentTimeMillis();

        while (true) {
            long elapsedTime = System.currentTimeMillis() - startTime;

            System.out.println("Running time: " + elapsedTime / 1000.0 + " seconds");


            if (elapsedTime >= timeLimit) {
                System.out.println("Time limit exceeded. Stopping the exploration.");
                System.exit(0);
            }

            try {
                sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
