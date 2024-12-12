package tp.practicas;

import java.util.ArrayList;
import java.util.List;

/**
 * The OfferedCourses class represents the set of subjects offered by the educational center.
 * This class allows managing a list of courses, including adding, removing, and retrieving courses.
 * 
 * @version 1.0.0
 * @author Harrinson Miliani Trujillo
 */
public class OfferedCourses {
    private List<Course> courses;

    public OfferedCourses() {
        courses = new ArrayList<>();
    }

    /**
     * Add a course to the list of courses.
     *
     * @param course The course to add
     * @return true if the course was successfully added, false if it already exists in the list
     */
    public boolean addCourse(Course course) {
        if (courses.contains(course)) {
            return false;
        } else {
            courses.add(course);
            return true;
        }
    }

    /**
     * Remove a course from the list based on its code.
     *
     * @param id The code of the course to remove
     * @return true if the course was successfully removed, false if it was not found
     */
    public boolean removeCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode() == id) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieve a course from the list based on its code.
     *
     * @param id The code of the course to retrieve
     * @return The course corresponding to the code, or null if not found
     */
    public Course getCourse(int id) {
        for (Course course : courses) {
            if (course.getCode() == id) {
                return course;
            }
        }
        return null;
    }

    /**
     * Get the list of courses sorted by their string representation.
     *
     * @return A sorted list of courses
     */
    public List<Course> getCourses() {
        List<Course> coursesCopy = new ArrayList<>(courses);
        coursesCopy.sort((courseA, courseB) -> courseA.toString().compareTo(courseB.toString()));
        
        return coursesCopy;
    }
}