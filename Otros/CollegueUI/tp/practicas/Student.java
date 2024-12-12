package tp.practicas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implement a college student.
 *
 * @author Ibaute Vega Gil
 * @version 1.0.0
 */
public class Student {
    
    final public int id;
    public String name;
    private final List<Course> courseList;
    
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courseList = new ArrayList<>();
    }

    /**
    * Return the student's id.
    *
    * @return the student's id as an integer
    */
    public int getId() {
        return this.id;
    }
    
    /**
    * Return the student's name.
    *
    * @return the student's name as a string
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * Add a new course in the student's courses.
    * 
    * @param a new course class
    * @return true if the course is added, false otherwise
    */
    public boolean enrollCourse(Course newCourse) {
        for(Course course : this.courseList) {
            if (newCourse.equals(course)) {
                return false;
            }
        }
        this.courseList.add(newCourse);
        return true;
    }
    
    /**
    * Remove a course from the student's courses.
    * 
    * @param a course code
    * @return true if the course is removed, false if course is not found
    */
    public boolean unenrollCourse(int code) {
        for(Course course : this.courseList) {
            if (course.getCode() == code) {
                this.courseList.remove(course);
                return true;
            }
        }
        return false;
    }
    
    /**
    * Return a collection of the student's courses, sorted by code.
    * 
    * @return a collection of the student's courses
    */
    public Collection<Course> getEnrolledCourses() {
        List<Course> sortedList = new ArrayList<>(this.courseList);
        sortedList.sort((course1, course2) -> Integer.compare(course1.getCode(), course2.getCode()));
        return sortedList;
    }
    
    /**
    * Return a string of the student's information.
    * 
    * @return a string of the student's information.
    */
    @Override
    public String toString() {
        String string = this.id + "-" + this.name + "[";
        List<Course> sortedList = new ArrayList<>(this.courseList);
        sortedList.sort((course1, course2) -> Integer.compare(course1.getCode(), course2.getCode()));
        List<String> toStringList = new ArrayList<>();
        for(Course course : sortedList) {
            toStringList.add(course.toString());
        }
        return string + String.join(", ", toStringList) + "]";
    }
    
    /**
    * Indicate whether some other object is the same to this one.
    * 
    * @param a new object
    * @return true if the two objects are the same, false otherwise
    */
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Student)) return false;
        Student other = (Student)obj;
        return other.getId() == this.id;
    }
    
    /**
    * Return a hash code valid for the object.
    * 
    * @return the student's identification
    */
    @Override
    public int hashCode() {
        return this.id;
    }
}