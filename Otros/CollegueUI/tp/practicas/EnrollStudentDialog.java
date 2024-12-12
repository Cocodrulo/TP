package tp.practicas;

import java.util.List;
import javax.swing.*;
import java.awt.*;

/**
 * Student dialog handler.
 * @author Javier Aday Pérez Romero
 * @version 1.0.0
 **/
class EnrollStudentDialog extends JDialog { 
    
    private boolean clickedAccept;
    private JComboBox<String> studentCombo, courseCombo;
    
    public EnrollStudentDialog(JFrame owner, List<Student> enrolledStudents, List<Course> offeredCourses) {
        super(owner, "Enrolll student in course", true);
        
        JPanel panel = (JPanel) getContentPane();
        
        panel.add(createButtons(), BorderLayout.SOUTH);
        panel.add(createForm(enrolledStudents, offeredCourses), BorderLayout.CENTER);
        
        setSize(400, 300);
        setResizable(false);
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    /**
     * Creates accept and cancel buttons.
     * @return Panel with buttons.
     **/
    private JPanel createButtons() {
        JPanel panel = new JPanel();
        
        JButton acceptBtn = new JButton("Accept");
        JButton cancelBtn = new JButton("Cancel");
        
        panel.add(acceptBtn);
        panel.add(cancelBtn);
        
        acceptBtn.addActionListener(ev -> {
           clickedAccept = true; 
           setVisible(false);
           dispose();
        });
        
        cancelBtn.addActionListener(ev -> {
           clickedAccept = false; 
           setVisible(false);
           dispose();
        });
        
        return panel;
    }
    
    /**
     * Create the form fot the dialog.
     * @param enrolledStudents Students in the system.
     * @param offeredCourses Courses in the system.
     * @return Panel with form.
     **/
    private JPanel createForm(List<Student> originalStudents, List<Course> originalCourses) {
        JPanel panel = new JPanel();
        
        JPanel studentPanel = new JPanel();
        
        String[] students = new String[originalStudents.size()];
        for (int i = 0; i < students.length; i++) {
            Student student = originalStudents.get(i);
            students[i] = String.format("%d.-%s", student.getId(), student.getName());
        }
        
        studentCombo = new JComboBox<String>(students);
        studentPanel.add(studentCombo);
        
        JPanel coursePanel = new JPanel();
        
        String[] courses = new String[originalCourses.size()];
        for (int i = 0; i < courses.length; i++) {
            Course course = originalCourses.get(i);
            courses[i] = course.toString();
        }
        
        courseCombo = new JComboBox<String>(courses);
        coursePanel.add(courseCombo);
        
        panel.add(studentPanel);
        panel.add(coursePanel);
        
        return panel;
    }
    
    /**
     * Check whether dialog was accepted or not.
     * @return true if dialog was accepted, false otherwise.
     **/
    public boolean isAccepted() {
        return clickedAccept;
    }
    
    /**
     * Get the index of the student inputed in the form.
     * @return Student index.
     **/
    public int getStudent() {
        return studentCombo.getSelectedIndex();
    }
    
    /**
     * Get the index of the course inputed in the form.
     * @return Course index.
     **/
    public int getCourse() {
        return courseCombo.getSelectedIndex();
    }
}
