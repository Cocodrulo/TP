package tp.practicas;

import javax.swing.*;
import java.awt.*;

/**
 * Student dialog handler.
 * @author Javier Aday Pérez Romero
 * @version 1.0.0
 **/
class AddStudentDialog extends JDialog {
    
    private boolean clickedAccept;
    private JTextField idTextField, nameTextField;
    
    public AddStudentDialog(JFrame owner) {
        super(owner, "Add new student", true);
        
        JPanel panel = (JPanel) getContentPane();
        
        panel.add(createButtons(), BorderLayout.SOUTH);
        panel.add(createForm(), BorderLayout.CENTER);
        
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
     * @return Panel with form.
     **/
    private JPanel createForm() {
        JPanel panel = new JPanel();
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
        
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("Student ID: "));
        idTextField = new JTextField(15);
        idPanel.add(idTextField);
        
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Student Name: "));
        nameTextField = new JTextField(20);
        namePanel.add(nameTextField);
        
        panel.add(idPanel);
        panel.add(namePanel);
        
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
     * Get the ID inputed in the form.
     * @return Student ID.
     **/
    public int getId() {
        return Integer.parseInt(idTextField.getText());
    }
    
    /**
     * Get the name inputed in the form.
     * @return Student name.
     **/
    public String getName() {
        return nameTextField.getText();
    }
}
