package ui;

import model.Course;
import model.GradeBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveCoursePanel extends JPanel {
    private JTextField nametext;
    GradeBook mygradebook;

    public RemoveCoursePanel(GradeBook mygradebook) {
        super();
        this.mygradebook = mygradebook;
        panelLayout();
        panelMainLabel();
        panelSubLabels();
        panelTextFields();
        backbutton();
        removebutton();
    }

    public void panelSubLabels() {

        JLabel corsName = new JLabel("Enter Course Name :");
        corsName.setBounds(50, 250, 200, 50);
        corsName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        corsName.setForeground(Color.green);
        corsName.setBackground(Color.black);
        corsName.setOpaque(true);


        add(corsName);

    }

    public void panelMainLabel() {

        JLabel pageTitle = new JLabel("Enter the course name to remove...");
        pageTitle.setBounds(100, 100, 450, 50);
        pageTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        pageTitle.setForeground(Color.orange);
        pageTitle.setBackground(Color.black);
        pageTitle.setOpaque(true);

        add(pageTitle);

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

    public void removebutton() {

        JButton removebtn = new JButton("Remove Course");
        removebtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        removebtn.setBounds(220, 400, 150, 50);
        removebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        removebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCourse();
            }
        });

        add(removebtn);

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

    public void panelTextFields() {
        nametext = new JTextField(10);
        nametext.setBounds(260, 250, 300, 50);
        add(nametext);

    }


    public void deleteCourse() {

//        System.out.println("\n Enter the course name to delete:");
        boolean isRemoved = false;
        String removeInput = nametext.getText().toUpperCase();
        for (Course rcourse : mygradebook.getCourses()) {
            if (removeInput.equals(rcourse.getName())) {
                mygradebook.removeCourse(rcourse);
                JOptionPane.showMessageDialog(null,
                        "Course Removed successfully!");
//                System.out.println("Course Removed Successfully");
                isRemoved = true;
                break;
            }
        }
        if (!isRemoved) {
//            System.out.println("There is no course named " + removeInput);
            JOptionPane.showMessageDialog(null,
                    "There is no course named " + removeInput);
        }


    }

}
