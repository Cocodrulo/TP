package tp.practicas;

/**
 * The Course class represents an academic course with an identifier and a subject name.
 * 
 * @version 1.0.0
 * @author Sergio Rivero Díaz
 */
public class Course {

    String subject;

    int identificator;
    
    public Course(int identificator, String subject) {
        this.identificator = identificator;
        this.subject = subject;
    }

    /**
     * Method to get the course identifier.
     * 
     * @return the identificator
     **/
    public int getCode() {
        return identificator;
    }

    /** 
     * Method to get the subject name.
     * 
     * @return the subject name
     **/
    public String getName() {
        return subject; // Returns the subject name.
    }

    /** 
     * Return a string representation of the object.
     * 
     * @return String representing the object
     **/
    @Override
    public String toString() {
        return "(" + identificator + ")" + subject;
    }

    /** 
     * Indicate whether some other object is the same to this one.
     * 
     * @return true if the two objects are te same, false otherwise
     **/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Course)) {
            return false;
        }
        Course other = (Course) obj;
        
        return this.identificator == other.identificator &&
                this.subject.equals(other.subject);
    }

    /**
     * Return a hash code value for the object.
     * 
     * @return unique hash
     **/
    @Override
    public int hashCode() {
        return this.getCode();
    }
}