package compulsory;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Pal Alexandra
 * This is the main class, and it is used to solve the last three tasks from compulsory exercices.
 */
public class Main {
    public static void main(String args[]){

        List<Student> studentList = createStudents();

        Set<Project> projectList = createProjects();

        //SORT STUDENTS
        Collections.sort(studentList,
                ((u, v) -> u.getName().compareTo(v.getName())));

        printStudents(studentList);
        printProjects(projectList);

    }

    /**
     * This method is used to create a list of students using streams.
     * @return: studentList: a list with Student objects
     */
    public static List<Student> createStudents(){
        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        List<Student> studentList = new LinkedList<>();
        for(Student s: students){
            studentList.add(s);
        }
        return  studentList;
    }

    /**
     * This method is used to create a set of projects using streams.
     * @return projectList: a set with Project objects
     */
    public static Set<Project> createProjects(){
        var projects = IntStream.rangeClosed(0,2)
                .mapToObj(i->new Project("P"+i))
                .toArray(Project[]::new);

        Set<Project> projectList = new TreeSet<>();
        projectList.addAll(Arrays.asList(projects));
        return  projectList;
    }

    /**
     * This method is used to print a list of students.
     * @param students: Student objects to be printed.
     */
    public static void printStudents(List<Student> students){
        for(Student student: students){
            System.out.println(student.getName());
        }
    }
    /**
     * This method is used to print a set of projects.
     * @param projects: Project objects to be printed.
     */
    public static void printProjects(Set<Project> projects){
        for(Project project: projects){
            System.out.println(project.getName());
        }
    }

}
