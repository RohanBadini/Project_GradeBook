package ui;

import model.GradeBook;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GradeBookGUI extends JFrame {
    private JFrame homeFrame;
    //    private JPanel leftLogo;
    GradeBook mygradebook;
    private JPanel imageLogoPanel;
    static JPanel mainHomeBtnsPanel;
    private static final String JSON_LOCATION = "./data/CourseListGUI.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
//    public cardLayout = new CardLayout();


    public GradeBookGUI() {
        intializeHomePage();
        mygradebook = new GradeBook("MyGradeBook");
        jsonWriter = new JsonWriter(JSON_LOCATION);
        jsonReader = new JsonReader(JSON_LOCATION);
    }




    public void intializeHomePage() {
        homeFrame = new JFrame("Student GradeBook");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setVisible(true);
//        frame.pack();
        homeFrame.setSize(900, 650);
        homeFrame.setLayout(null);
        initializePanels();


    }

    public void initializePanels() {
        logoPanel();
//        HomePanel mainPanel = new HomePanel(mygradebook);
//        homeFrame.add(mainPanel);
        mainPanel();

    }

    private void logoPanel() {
        imageLogoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image bgImage = new ImageIcon("data/logo2.png").getImage();
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        homeFrame.add(imageLogoPanel);
        imageLogoPanel.setLayout(null);
//        imageLogoPanel.setBackground(Color.green);
        imageLogoPanel.setBounds(0, 0, 300, 622);

        //add images, logos or gifs
    }

    public void mainPanel() {
        mainHomeBtnsPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image bgImage = new ImageIcon("data/shutterstock_301818437.jpg").getImage();
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        homeFrame.add(mainHomeBtnsPanel);
        mainHomeBtnsPanel.setLayout(null);

//        mainHomeBtnsPanel.setBackground(Color.BLUE);
        mainHomeBtnsPanel.setBounds(300, 0, 600, 622);
        initializeActionButtons();



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



//    public void resetToMain(JPanel currentpanel) {
//        getContentPane().remove(currentpanel);
//        currentpanel.removeAll();
//        homeFrame.add(mainHomeBtnsPanel);
//        mainHomeBtnsPanel.validate();
//        mainHomeBtnsPanel.repaint();
//
//    }

    public void addCourseButton() {
        JButton addButn = new JButton("Add Course");
        addButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        addButn.setBounds(205, 120, 190, 70);
        addButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                AddCourseButton window = new AddCourseButton(mygradebook);
//                window.AddCourseButton.setVisible(true);


//                getContentPane().remove(mainHomeBtnsPanel);
//                mainHomeBtnsPanel.removeAll();

                mainHomeBtnsPanel.setVisible(false);


                AddCoursePanel addCoursePanel = new AddCoursePanel(mygradebook);//
//                addCoursePanel.setBackground(Color.BLUE);//
//                addCoursePanel.setLayout(null);//
//                addCoursePanel.setBounds(300, 0, 600, 622);//

                homeFrame.add(addCoursePanel);//
                addCoursePanel.validate();//
                addCoursePanel.repaint();//


            }
        });
        mainHomeBtnsPanel.add(addButn);

    }

    public void removeCourseButton() {
        JButton removeButn = new JButton("Remove Course");
        removeButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        removeButn.setBounds(205, 220, 190, 70);
        removeButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        removeButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainHomeBtnsPanel.setVisible(false);


                RemoveCoursePanel removeCoursePanel = new RemoveCoursePanel(mygradebook);//
                homeFrame.add(removeCoursePanel);//
                removeCoursePanel.validate();//
                removeCoursePanel.repaint();//
            }
        });
        mainHomeBtnsPanel.add(removeButn);

    }

    public void viewAllButton() {
        JButton viewAllButn = new JButton("View All Courses");
        viewAllButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        viewAllButn.setBounds(205, 320, 190, 70);
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
        calcButn.setBounds(205, 420, 190, 70);
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
        saveButn.setBounds(250, 560, 90, 50);
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
        quitButn.setBounds(490, 560, 90, 50);
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



