package ui;

import model.Course;
import model.GradeBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// Represents a class with View All Panel to the user
public class ViewAllPanel extends JPanel {
    private JScrollPane coursesDisplay;
    GradeBook mygradebook;
    private List<String> coursenames;

    // EFFECTS: Initializes View All Layout and Buttons
    public ViewAllPanel(GradeBook mygradebook) {
        super();
        this.mygradebook = mygradebook;
        backbutton();
        panelMainLabel();
        panelLayout();
        panelScroller();



    }

    // EFFECTS: creates a scroller and adds it to the panel
    public void panelScroller() {
        runViewAllCourses();
        String[] array = coursenames.toArray(new String[coursenames.size()]);
        JList<String> list = new JList<>(array);
        coursesDisplay = new JScrollPane(list);
        list.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        coursesDisplay.setBounds(100,190,360,350);
        coursesDisplay.setVisible(true);
        add(coursesDisplay);



    }

    // EFFECTS: makes the list of courses that can be printed onto the panel
    public void runViewAllCourses() {
        coursenames = new ArrayList<>();
        if (mygradebook.getCourses().isEmpty()) {
//            don't nothing
        } else {

            for (int r = 0; r < mygradebook.getCourses().size(); r++) {
                Course rcourse = mygradebook.getCourses().get(r);
                int t = r + 1;
                coursenames.add(t + ". " + rcourse.getName());
            }

        }
    }

    // EFFECTS: Change the background of the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bgImage = new ImageIcon("data/shutterstock_301818437.jpg").getImage();
        g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
    }

    // EFFECTS: Sets the panel layout and bounds
    public void panelLayout() {
        setLayout(null);
        setBounds(300, 0, 600, 622);
    }

    // EFFECTS: Creates a title label for the panel and adds it to the frame
    public void panelMainLabel() {

        JLabel pageTitle = new JLabel("List of All the Courses added :");
        pageTitle.setBounds(100, 100, 360, 50);
        pageTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        pageTitle.setForeground(Color.orange);
        pageTitle.setBackground(Color.black);
        pageTitle.setOpaque(true);

        add(pageTitle);

    }

    // EFFECTS: Creates a back button and when clicked , it navigates to the main panel, adds it to the panel.
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

}
