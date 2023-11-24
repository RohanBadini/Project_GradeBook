package ui;

import model.Course;
import model.GradeBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCoursePanel extends JPanel {
    private JTextField nametext;
    private JTextField creditstext;
    private JTextField gradetext;
    GradeBook mygradebook;

    public AddCoursePanel(GradeBook mygradebook) {
        super();
        this.mygradebook = mygradebook;
        panelLayout();
        panelSubLabels();
        panelMainLabel();
        panelTextFields();
        addbutton();
        backbutton();
    }

    public void panelMainLabel() {

        JLabel pageTitle = new JLabel("Enter the course details below :");
        pageTitle.setBounds(150, 100, 340, 50);
        pageTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        pageTitle.setForeground(Color.orange);
        pageTitle.setBackground(Color.black);
        pageTitle.setOpaque(true);

        add(pageTitle);

    }

    public void panelTextFields() {
        nametext = new JTextField(10);
        nametext.setBounds(190, 200, 300, 50);
        add(nametext);
        creditstext = new JTextField(3);
        creditstext.setBounds(190, 300, 300, 50);
        add(creditstext);
        gradetext = new JTextField(1);
        gradetext.setBounds(190, 400, 300, 50);
        add(gradetext);


    }

    public void addbutton() {

        JButton addbtn = new JButton("Add Course");
        addbtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        addbtn.setBounds(220, 500, 150, 50);
        addbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addcoursegi();
            }
        });

        add(addbtn);

    }

    public void backbutton() {
        JButton bckbtn = new JButton("Go Back");
        bckbtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        bckbtn.setBounds(50, 50, 75, 40);
        bckbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        bckbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                GradeBookGUI.mainHomeBtnsPanel.setVisible(true);
            }
        });

        add(bckbtn);

    }

    public void panelLayout() {
        setLayout(null);
        setBounds(300, 0, 600, 622);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bgImage = new ImageIcon("data/shutterstock_301818437.jpg").getImage();
        g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
    }


    public void panelSubLabels() {

        JLabel corsName = new JLabel("Course Name :");
        corsName.setBounds(50, 200, 135, 50);
        corsName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        corsName.setForeground(Color.green);
        corsName.setBackground(Color.black);
        corsName.setOpaque(true);

        JLabel noCredits = new JLabel("Credits :");
        noCredits.setBounds(50, 300, 95, 50);
        noCredits.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        noCredits.setForeground(Color.green);
        noCredits.setBackground(Color.black);
        noCredits.setOpaque(true);

        JLabel labelGrade = new JLabel("Grade :");
        labelGrade.setBounds(50, 400, 75, 50);
        labelGrade.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        labelGrade.setForeground(Color.green);
        labelGrade.setBackground(Color.black);
        labelGrade.setOpaque(true);


        add(corsName);
        add(labelGrade);
        add(noCredits);
    }

    public void addcoursegi() {
        Course course = new Course(nametext.getText().toUpperCase(), Integer.parseInt(creditstext.getText()),
                Integer.parseInt(gradetext.getText()));

        if (!mygradebook.getCourses().isEmpty() && isCourseAlreadyAdded(nametext.getText().toUpperCase())) {
            JOptionPane.showMessageDialog(null,
                    "Sorry! This course has already been added!!!");
        } else {
            mygradebook.addCourse(course);
            JOptionPane.showMessageDialog(null,
                    "Course has been added successfully!");
        }

    }

    //EFFECTS: Helper for runAddCourse to check if the course is already there
    public boolean isCourseAlreadyAdded(String courseName) {
        for (Course exCourse : mygradebook.getCourses()) {
            if (courseName.equals(exCourse.getName())) {
                return true;
            }
        }
        return false;
    }


}
