package tp.practicas;

import java.awt.*;
import java.util.List;
import javax.swing.*;

/**
 * Main UI class.
 * @author Javier Aday Pérez Romero
 * @version 1.0.0
 **/
public class CollegeGUI extends JFrame {
    static private final OfferedCourses offeredCourses = new OfferedCourses();
    static private final EnrolledStudents enrolledStudents = new EnrolledStudents();;

    private JTextArea data;
    private JRadioButton orderName;
    private JRadioButton orderId;
    private JButton addStudent;
    private JButton enrollStudent;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem itemAddStudent, itemEnrollStudent, itemExit;

    /**
     * Build the interacteable app menu.
     **/
    private void constructMenu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("Menu");
        itemAddStudent = new JMenuItem("Add new student");
        itemEnrollStudent = new JMenuItem("Enroll student in course");
        itemExit = new JMenuItem("Exit");
        menu.add(itemAddStudent);
        menu.add(itemEnrollStudent);
        menu.add(itemExit);
        menuBar.add(menu);
    }
    
    /**
     * Build the buttons for main actions.
     * @return control panel
     **/
    private Component constructControls() {
        orderName = new JRadioButton("Order by student's name", true);
        orderId = new JRadioButton("Order by student's id", false);
        ButtonGroup bg = new ButtonGroup();
        bg.add(orderName);
        bg.add(orderId);
        addStudent = new JButton("Add new student");
        enrollStudent = new JButton("Enroll student in course");
        JPanel east = new JPanel();
        east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
        JPanel order = new JPanel();
        order.setLayout(new BoxLayout(order, BoxLayout.PAGE_AXIS));
        order.add(orderName);
        order.add(orderId);
        order.setBorder(BorderFactory.createTitledBorder("List order"));
        east.add(order);
        east.add(addStudent);
        east.add(enrollStudent);
        
        return east;
    }

    /**
     * Build the text display.
     * @return Scrolleable pane with text area.
     **/
    private Component constructInfo() {
        data = new JTextArea();
        data.setEditable(false);
        data.setFocusable(false);
        
        for (Student student : enrolledStudents.getStudentsOrderByName()) {
            data.append(student.toString()+"\n");
        }
        
        return new JScrollPane(data);
    }
    
    /**
     * Refresh the data on the display.
     **/
    private void refreshPanel() {
        if (orderName.isSelected()) {
            data.setText("");
            for (Student student : enrolledStudents.getStudentsOrderByName()) {
                data.append(student.toString()+"\n");
            }
        } else if(orderId.isSelected()) {
            data.setText("");
            for (Student student : enrolledStudents.getStudentsOrderById()) {
                data.append(student.toString()+"\n");
            }
        }
    }
    
    /**
     * Opens the add student dialoh and handles action
     **/
    private void onAddStudent() {
        AddStudentDialog dialog = new AddStudentDialog(CollegeGUI.this);
            
        if (!dialog.isAccepted()) return;
        Student student = new Student(dialog.getId(), dialog.getName());
        enrolledStudents.addStudent(student);
        
        refreshPanel();
    }
    
    
    /**
     * Opens the enroll student dialoh and handles action
     **/
    private void onEnrollStudent() {
        List<Student> originalStudents = enrolledStudents.getStudentsOrderById();
        List<Course> originalCourses = offeredCourses.getCourses();
        EnrollStudentDialog dialog = new EnrollStudentDialog(CollegeGUI.this, originalStudents, originalCourses);
        
        if (!dialog.isAccepted()) return;
        
        Student student = originalStudents.get(dialog.getStudent());
        Course course = originalCourses.get(dialog.getCourse());
        
        student.enrollCourse(course);
        
        refreshPanel();
    }
    
    /**
     * Attach listener to different components.
     **/
    private void attachListeners() {
        itemExit.addActionListener(ev -> {
            System.exit(0);
        });
        
        itemAddStudent.addActionListener(ev -> onAddStudent());
        addStudent.addActionListener(ev -> onAddStudent());
        
        itemEnrollStudent.addActionListener(ev -> onEnrollStudent());
        enrollStudent.addActionListener(ev -> onEnrollStudent());
        
        orderName.addActionListener(ev -> refreshPanel());
        orderId.addActionListener(ev -> refreshPanel());
    }

    public CollegeGUI(){
        super("College Management");
        InitialData.init(offeredCourses, enrolledStudents);
        constructMenu();
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add(constructInfo(), BorderLayout.CENTER);
        pane.add(constructControls(), BorderLayout.EAST);
        setContentPane(pane);
        setLocation(50, 50);
        setSize(700, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        attachListeners();
        setVisible(true);
    }

    /**
     * Initialize the UI
     **/
    public static void main (String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception ignored) {
        }
        new CollegeGUI();
    }
}