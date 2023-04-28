package org.homework.robots;

/**
 * @author Pal Alexandra
 * This class implements the supervisor of the robots.
 */


import lombok.Data;
import org.homework.map.ExplorationMap;
import org.homework.other.Timekeeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Data
public class Supervisor {

    private List<Robot> robots;
    private ExplorationMap map;
    private int robotsCount;

    private Exploration exploration;

    public Supervisor(Exploration exploration) {
        this.exploration = exploration;
        this.robots = exploration.getRobots();
        this.map = exploration.getMap();
        this.robotsCount = this.robots.size() - 1;
    }

    /**
     * Within this method, the supervisor can start/pause the robots (all of them or only a specific one).
     */
    public void start() {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        List<Runnable> tasks = new ArrayList<>();
        for (Robot robot : robots) {
            Runnable task = new Thread(robot);
            tasks.add(task);
            //Executes the given task sometime in the future.
            executor.execute(task);
        }

        //Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
        executor.shutdown();

        Scanner cin = new Scanner(System.in);
        System.out.println("Enter sa for starting all the robots.");
        System.out.println("Enter pa to pause all the robots.");
        System.out.println("Enter a number between 0 and " + this.robotsCount + " to start/pause an certain robot. (If the robot is already paused, then it will be restarted for the exploration)");
        while (true) {
            String command = cin.nextLine();

            if (command.equals("sa")) {
                for (Robot robot : robots) {
                    if (robot.isPaused()) {
                        robot.restart();
                    }
                }
                System.out.println("All robots are exploring");
            } else if (command.equals("pa")) {
                for (Robot robot : robots) {
                    if (!robot.isPaused()) {
                        robot.pause();
                    }
                }
                System.out.println("All robots are paused");
            } else {
                try {
                    int commandNumber = Integer.parseInt(command);
                    if (robots.get(commandNumber).isPaused()) {
                        System.out.println("Robot: " + robots.get(commandNumber).getName() + " is now exploring");
                        robots.get(commandNumber).restart();
                    } else {
                        robots.get(commandNumber).pause();
                        System.out.println("Robot: " + robots.get(commandNumber).getName() + " is paused");
                    }
                } catch (NumberFormatException exception) {
                    System.out.println(exception);
                }
            }

            if (map.isComplet()) {
                break;
            }

        }
    }

    public static void main(String args[]) {

        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E", explore));
        explore.addRobot(new Robot("R2D2", explore));
        explore.addRobot(new Robot("Optimus Prime", explore));

        Supervisor robotSupervisor = new Supervisor(explore);

        Timekeeper timer1 = new Timekeeper(20000); //20 seconds
        Timekeeper timer2 = new Timekeeper(120000); //2 minutes

        //timer1.start();
        timer2.start();
        robotSupervisor.start();
    }

}
