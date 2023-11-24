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

public class ViewAllPanel extends JPanel {
    private JScrollPane coursesDisplay;
    GradeBook mygradebook;
    private List<String> coursenames;

    public ViewAllPanel(GradeBook mygradebook) {
        super();
        this.mygradebook = mygradebook;
        backbutton();
        panelMainLabel();
        panelLayout();
        panelScroller();



    }

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

    public void runViewAllCourses() {
        coursenames = new ArrayList<>();
        if (mygradebook.getCourses().isEmpty()) {
//            System.out.println("There are no courses to view. Try adding some courses..");
        } else {

//            System.out.println("\n List of All Courses:");

            for (int r = 0; r < mygradebook.getCourses().size(); r++) {
                Course rcourse = mygradebook.getCourses().get(r);
                int t = r + 1;
                coursenames.add(t + ". " + rcourse.getName());
//                System.out.println(t + ". " + rcourse.getName());
            }

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bgImage = new ImageIcon("data/shutterstock_301818437.jpg").getImage();
        g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
    }

    public void panelLayout() {
        setLayout(null);
        setBounds(300, 0, 600, 622);
    }

    public void panelMainLabel() {

        JLabel pageTitle = new JLabel("List of All the Courses added :");
        pageTitle.setBounds(100, 100, 360, 50);
        pageTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
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

}
