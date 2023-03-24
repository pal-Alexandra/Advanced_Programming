package org.homework4;

import java.util.*;

/**
 * @author Pal Alexandra
 * This class describes the problem "The Student-Project Allocation Problem"
 */
public class Problem {

    private List<Student> students;
    private List<Project> projects;

    private Map<Student, List<Project>> preferences;

    private Map<Project, Boolean> projectsAvailability;

    /**
     * This is the default constructor of the class.
     */
    public Problem() {
        this.students = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.preferences = new HashMap<>();
        this.projectsAvailability = new HashMap<>();
    }

    /**
     * This is another constructor of the class.
     *
     * @param students: sets the students of the problem.
     * @param projects: sets the projects of the problem.
     */
    public Problem(List<Student> students, List<Project> projects) {
        this.students = students;
        this.projects = projects;
        this.projectsAvailability = new HashMap<>();
        for (Project project : projects) {
            this.projectsAvailability.put(project, true);
        }
    }

    /**
     * This method is used to set the students of the problem.
     *
     * @param students: set the students of the problem.
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * This method is used to set the students of the problem.
     *
     * @param projects: set the students of the problem.
     */
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    /**
     * This method is used to set the list of projects that are admissible for each student.
     */
    public void setPreferences() {
        this.preferences = new HashMap<>();
        for (Student student : this.students) {
            this.preferences.put(student, student.getPreferences());
        }
    }

    /**
     * This method is used to obtain the students from the problem.
     *
     * @return: students: the students from the problem.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * This method is used to obtain the projects from the problem.
     *
     * @return: projects: the projects from the problem.
     */
    public List<Project> getProjects() {
        return projects;
    }

    /**
     * This method is used to add a student to the problem list of students.
     *
     * @param student: student to be added
     */
    public void addStudent(Student student) {
        this.students.add(student);
        this.preferences.put(student, student.getPreferences());
    }

    /**
     * This method is used to add a project to the problem list of projects.
     *
     * @param project: project to be added
     */
    public void addProject(Project project) {
        this.projects.add(project);
        this.projectsAvailability.put(project, true);
    }

    /**
     * This method is used to display all the students that have a number of preferences lower than the average number of preferences (task_2 from homework).
     */
    public void displaySpecialStudents() {
        double avg = this.students.stream()
                .mapToInt(Student::getNumberOfPreferences)
                .average()
                .orElse(0);

        System.out.println("All the students that have a number of preferences lower than the average number of preferences are:");
        this.students.stream()
                .filter(s -> s.getNumberOfPreferences() < avg)
                .forEach(System.out::println);

    }

    /**
     * This method is used to assign each student to at most one project such as each project is assigned to at most one student (task_4 from homework).
     */
    public void solveProblem() {
        Map<Student, Project> allocation = new HashMap<>();

        for (Student student : this.students) {
            boolean hasProject = false;
            for (Project project : student.getPreferences()) {
                if (this.projectsAvailability.get(project) == true) {
                    allocation.put(student, project);
                    this.projectsAvailability.replace(project, false);
                    hasProject = true;
                    break;
                }
            }
            if (hasProject == false)
                allocation.put(student, new Project("NULL"));
        }

        this.printAllocation(allocation);

    }

    /**
     * This method is used to print each student with the project that he has been assigned to.
     *
     * @param allocation: a map which contains each student with the project that he has been assigned to.
     */
    public void printAllocation(Map<Student, Project> allocation) {
        for (Map.Entry<Student, Project> entry : allocation.entrySet()) {
            System.out.println(entry.getKey().toString());
            System.out.println("\t HAS BEEN ALOCATED TO: " + entry.getValue().getName());
        }
    }

}
