package org.homework4;

import java.util.*;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

/**
 * @author Pal Alexandra
 * This is the main class, and it is used to show the functionalities of the homework.
 */
public class Main {
    public static void main(String args[]) {

        List<Project> projectList = createProjects();
        List<Student> studentList = createStudents(projectList);

        Problem problem = new Problem(studentList, projectList);
        problem.setPreferences();

        System.out.println("\t\tTASK_2");
        problem.displaySpecialStudents();

        System.out.println("\t\tTASK_4");
        problem.solveProblem();

    }

    /**
     * This method is used to create a list of students using streams.
     *
     * @return: studentList: a list with Student objects
     */
    public static List<Student> createStudents(List<Project> projects) {

        Faker faker = new Faker();
        var students = IntStream.rangeClosed(0, 5)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toArray(Student[]::new);
        List<Student> studentList = new ArrayList<>();
        for (Student s : students) {
            studentList.add(s);
        }
        studentList.get(0).setPreferences(Arrays.asList(projects.get(0), projects.get(1), projects.get(2), projects.get(5)));
        studentList.get(1).setPreferences(Arrays.asList(projects.get(1), projects.get(2), projects.get(3)));
        studentList.get(2).setPreferences(Arrays.asList(projects.get(0), projects.get(1)));
        studentList.get(3).setPreferences(Arrays.asList(projects.get(5)));
        studentList.get(4).setPreferences(Arrays.asList(projects.get(2), projects.get(3), projects.get(5)));
        studentList.get(5).setPreferences(Arrays.asList(projects.get(0), projects.get(3), projects.get(4)));

        return studentList;
    }

    /**
     * This method is used to create a set of projects using streams.
     *
     * @return projectList: a set with Project objects
     */
    public static List<Project> createProjects() {
        Faker faker = new Faker();
        var projects = IntStream.rangeClosed(0, 5)
                .mapToObj(i -> new Project(faker.company().bs()))
                .toArray(Project[]::new);

        List<Project> projectList = new ArrayList<>();
        projectList.addAll(Arrays.asList(projects));
        return projectList;
    }


    /**
     * This method is used to print a list of students.
     *
     * @param students: Student objects to be printed.
     */
    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    /**
     * This method is used to print a set of projects.
     *
     * @param projects: Project objects to be printed.
     */
    public static void printProjects(List<Project> projects) {
        for (Project project : projects) {
            System.out.println(project.getName());
        }
    }

}
