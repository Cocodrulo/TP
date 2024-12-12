package tp.practicas;

import java.util.List;
import java.util.ArrayList;

/**
 * Container that handle the students.
 * 
 * @version 1.0.0
 * @author Javier Aday Pérez Romero
 **/
public class EnrolledStudents {
    private List<Student> studentsList;
    
    public EnrolledStudents() {
        studentsList = new ArrayList<>();
    }
    
    /**
     * Add a new student to the list.
     * 
     * @param student Student to add
     * @return true if successfull, false otherwise
     **/
    public boolean addStudent(Student student) {
        if (studentsList.contains(student)) return false;
        
        studentsList.add(student);
        return true;
    }
    
    /**
     * Remove a student from the list.
     * 
     * @param id Id of the student to remove
     * @return true if successfull, false otherwise
     **/
    public boolean removeStudent(int id) {
        Student toRemove = this.getStudent(id);
        if (toRemove == null) return false;
        
        studentsList.remove(toRemove);
        return true;
        
    }
    
    /**
     * Get a student from the list.
     * 
     * @param id Id of the student to get
     * @return Student that have the specified id
     **/
    public Student getStudent(int id) {
        for (Student student : studentsList) {
            if (student.getId() == id) return student;
        }
        
        return null;
    }
    
    /**
     * Get all the students in a course.
     * 
     * @param code Course code
     * @return The list of the students that have that course
     **/
    public List<Student> getStudentsByCourse(int code) {
        List<Student> studentsCopy = new ArrayList<>();
        
        for (Student student : studentsList) {
            for (Course course : student.getEnrolledCourses()) {
                if (course.getCode() == code) studentsCopy.add(student);
            }
        }
        
        studentsCopy.sort((studentA, studentB) -> studentA.getName().equals(studentB.getName()) ? 
                                                    Integer.compare(studentA.getId(), studentB.getId()) : 
                                                    studentA.getName().compareTo(studentB.getName()));
        
        
        return studentsCopy;
    }
   
    /**
     * Get all the students ordered by name.
     * 
     * @return The list of students ordered by its name
     **/
    public List<Student> getStudentsOrderByName() {
        List<Student> studentsCopy = new ArrayList<>(studentsList);
        studentsCopy.sort((studentA, studentB) -> studentA.getName().compareTo(studentB.getName()));
        
        return studentsCopy;
    }
    
    /**
     * Get all the students ordered by id.
     * 
     * @return The list of students ordered by its id
     **/
    public List<Student> getStudentsOrderById() {
        List<Student> studentsCopy = new ArrayList<>(studentsList);
        studentsCopy.sort((studentA, studentB) -> Integer.compare(studentA.getId(), studentB.getId()));
        
        return studentsCopy;
    }
}