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
    private JPanel imageLogoPanel;
    private JPanel mainHomeBtnsPanel;
    private static final String JSON_LOCATION = "./data/CourseListGUI.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    public GradeBookGUI() {
        intializeHomePage();
        jsonWriter = new JsonWriter(JSON_LOCATION);
        jsonReader = new JsonReader(JSON_LOCATION);
    }

    public void initializeActionButtons() {
        saveButton();
        quitButton();
        loadButton();
        addCourseButton();
        removeCourseButton();
        viewAllButton();
        calculateGradeButton();

    }



    public void intializeHomePage() {
        hFrame = new JFrame("Student GradeBook");
        hFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hFrame.setVisible(true);
//        frame.pack();
        hFrame.setSize(800, 650);
        hFrame.setLayout(null);
        initializePanels();


    }

    public void initializePanels() {
        logoPanel();
        mainPanel();

    }

    private void logoPanel() {
        imageLogoPanel = new JPanel();
        hFrame.add(imageLogoPanel);
        imageLogoPanel.setLayout(null);
        imageLogoPanel.setBackground(Color.green);
        imageLogoPanel.setBounds(0, 0, 268, 622);

        //add images, logos or gifs
    }

    public void mainPanel() {
        mainHomeBtnsPanel = new JPanel();
        hFrame.add(mainHomeBtnsPanel);
        mainHomeBtnsPanel.setLayout(null);

        mainHomeBtnsPanel.setBackground(Color.BLUE);
        mainHomeBtnsPanel.setBounds(268, 0, 532, 622);
        initializeActionButtons();




    }

    public void addCourseButton() {
        JButton addButn = new JButton("Add Course");
        addButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        addButn.setBounds(185, 120, 190, 70);
        addButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainHomeBtnsPanel.add(addButn);

    }

    public void removeCourseButton() {
        JButton removeButn = new JButton("Remove Course");
        removeButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        removeButn.setBounds(185, 220, 190, 70);
        removeButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        removeButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainHomeBtnsPanel.add(removeButn);

    }

    public void viewAllButton() {
        JButton viewAllButn = new JButton("View All Courses");
        viewAllButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        viewAllButn.setBounds(185, 320, 190, 70);
        viewAllButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        viewAllButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainHomeBtnsPanel.add(viewAllButn);

    }

    public void calculateGradeButton() {
        JButton calcButn = new JButton("Progress Report");
        calcButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        calcButn.setBounds(185, 420, 190, 70);
        calcButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        calcButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainHomeBtnsPanel.add(calcButn);

    }




    public void saveButton() {
        JButton saveButn = new JButton("Save");
        saveButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        saveButn.setBounds(230, 560, 90, 50);
        saveButn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //saveButn.setBounds(480, 550, 80, 40);

        saveButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainHomeBtnsPanel.add(saveButn);


    }

    public void loadButton() {
        JButton loadButn = new JButton("Load");
        loadButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        loadButn.setBounds(30, 560, 90, 50);
        loadButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        loadButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainHomeBtnsPanel.add(loadButn);


    }


    public void quitButton() {
        JButton quitButn = new JButton("Quit");
        quitButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        quitButn.setBounds(420, 560, 90, 50);
        quitButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        quitButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainHomeBtnsPanel.add(quitButn);

    }
//        quitButn.setBackground(new Color(255, 255, 255));
//        quitButn.setForeground(new Color(0, 0, 0));


//        frame.getContentPane().add(quitButn);


}

