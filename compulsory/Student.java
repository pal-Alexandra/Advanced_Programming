package compulsory;

/**
 * @author Pal Alexandra
 * This class describes the students from the "The Student-Project Allocation Problem"
 */
public class Student implements Comparable<Student>{
    private String name;

    /**
     * This is the constructor of the class.
     * @param name: sets the name of the current student
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * This method sets the name of the student.
     * @param name: sets the name of the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is used to obtain the name of the student.
     * @return name: the name of the current student.
     */
    public String getName() {
        return name;
    }

    /**
     * Whithin this method, this class implements the interface Comparable (to make sure the objects of this class are comparable: the comparison is made by name)
     * @param student the object to be compared.
     * @return  0 if this == person, <0 if this < person, >0 if this > person
     */
    @Override
    public int compareTo(Student student){
        if(student == null){
            throw  new NullPointerException();
        } else if(!(student instanceof Student)){
            throw new ClassCastException("Uncomparable objects!");
        } else{
            Student student1 = (Student) student;
            return this.name.compareTo(student1.getName());
        }
    }
}
