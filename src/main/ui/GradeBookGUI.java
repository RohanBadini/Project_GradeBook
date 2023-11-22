package ui;

import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GradeBookGUI extends JFrame {
    private JFrame hFrame;
    private JPanel leftLogo;
    private JPanel mainActionBtns;
    private JPanel lowerSmallBtns;
    private static final String JSON_LOCATION = "./data/CourseListGUI.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    public GradeBookGUI() {
        intializeHomePage();
        jsonWriter = new JsonWriter(JSON_LOCATION);
        jsonReader = new JsonReader(JSON_LOCATION);
    }

    public void initializeLowerButtons() {
        saveButton();
        quitButton();
        loadButton();
        addCourseButton();

    }


    public void initializeMainButtons() {
//        addCourseButton();
//        removeCourseButton();
//        viewAllButton();
//        calculateButton();
    }



    public void intializeHomePage() {
        hFrame = new JFrame("Student GradeBook");
        hFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hFrame.setVisible(true);
//        frame.pack();
        hFrame.setSize(800, 650);
        initializePanels();



    }

    public void initializePanels() {
        leftLogo = new JPanel();
        rightHomePanel();
        lowerRightPanel();

    }

//    private void leftHomePanel() {
//
//        //add images
//    }
//
    private void rightHomePanel() {
        mainActionBtns = new JPanel();
        hFrame.getContentPane().add(mainActionBtns);
        mainActionBtns.setLayout(null);
        initializeMainButtons();

        //add buttons add,remove, viewall, calculate
    }

    public void lowerRightPanel() {
        lowerSmallBtns = new JPanel();
        hFrame.add(lowerSmallBtns);
        lowerSmallBtns.setLayout(null);
//        lowerSmallBtns.setBounds(100, 50, 200, 100);
        initializeLowerButtons();
    }

    public void addCourseButton() {
        JButton addButn = new JButton("Add Course");
        addButn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        addButn.setBounds(40, 60, 999, 40);

        addButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        lowerSmallBtns.add(addButn);


    }

    public void saveButton() {
        JButton saveButn = new JButton("Save");
        saveButn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        saveButn.setBounds(480, 550, 80, 40);

        saveButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        lowerSmallBtns.add(saveButn);


    }

    public void loadButton() {
        JButton loadButn = new JButton("Load");
        loadButn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        loadButn.setBounds(280, 550, 80, 40);

        loadButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        lowerSmallBtns.add(loadButn);


    }



    public void quitButton() {
        JButton quitButn = new JButton("Quit");
        quitButn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        quitButn.setBounds(680, 550, 80, 40);

        quitButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        lowerSmallBtns.add(quitButn);

    }
//        quitButn.setBackground(new Color(255, 255, 255));
//        quitButn.setForeground(new Color(0, 0, 0));


//        frame.getContentPane().add(quitButn);















}

