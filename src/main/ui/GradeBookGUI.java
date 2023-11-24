package ui;

import model.GradeBook;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


public class GradeBookGUI extends JFrame {
    private JFrame homeFrame;
    GradeBook mygradebook;
    private JPanel imageLogoPanel;
    static JPanel mainHomeBtnsPanel;
    private static final String JSON_LOCATION = "./data/CourseListGUI.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JDialog removeBox;
    private JButton removeButn;

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
        homeFrame.setSize(900, 650);
        homeFrame.setLayout(null);
        initializePanels();


    }

    public void initializePanels() {
        logoPanel();
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
        imageLogoPanel.setBounds(0, 0, 300, 622);


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


    public void addCourseButton() {
        JButton addButn = new JButton("Add Course");
        addButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        addButn.setBounds(205, 120, 190, 70);
        addButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                mainHomeBtnsPanel.setVisible(false);
                AddCoursePanel addCoursePanel = new AddCoursePanel(mygradebook);
                homeFrame.add(addCoursePanel);//
                addCoursePanel.validate();//
                addCoursePanel.repaint();//


            }
        });
        mainHomeBtnsPanel.add(addButn);

    }

    public void removeCourseButton() {
        removeButn = new JButton("Remove Course");
        removeButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        removeButn.setBounds(205, 220, 190, 70);
        removeButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        removeButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                removeops();
            }
        });
        mainHomeBtnsPanel.add(removeButn);

    }

    public void removeops() {
        removeBox = new JDialog();
        removeBox.setSize(300, 200);
        removeBox.setLayout(null);
        removeBox.setTitle("Select an option to proceed");
        removeBox.setLocationRelativeTo(removeButn);
        removeBox.getContentPane().setBackground(Color.gray);
        removeBox.setBackground(Color.blue);
        deleteAllButton();
        deleteOneButton();
        removeBox.setVisible(true);
    }

    public void deleteAllButton() {
        JButton deleteAll = new JButton("Remove All Courses");
        deleteAll.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        deleteAll.setBounds(25, 100, 250, 50);
        deleteAll.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeBox.add(deleteAll);

        deleteAll.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                removeBox.dispose();
                clearAllCourses();
                JOptionPane.showMessageDialog(null,
                        "All courses are removed!!!");
            }
        });
    }

    //
    public void deleteOneButton() {
        JButton deleteOne = new JButton("Remove a course");
        deleteOne.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        deleteOne.setBounds(25, 20, 250, 50);
        deleteOne.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeBox.add(deleteOne);

        deleteOne.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveCoursePanel removeCoursePanel = new RemoveCoursePanel(mygradebook);
                homeFrame.add(removeCoursePanel);
                mainHomeBtnsPanel.setVisible(false);
                removeCoursePanel.validate();
                removeCoursePanel.repaint();
                removeBox.dispose();
            }
        });
    }


    public void clearAllCourses() {
        mygradebook.getCourses().clear();
    }


    public void viewAllButton() {
        JButton viewAllButn = new JButton("View All Courses");
        viewAllButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        viewAllButn.setBounds(205, 320, 190, 70);
        viewAllButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        viewAllButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainHomeBtnsPanel.setVisible(false);


                ViewAllPanel viewAllPanel = new ViewAllPanel(mygradebook);
                homeFrame.add(viewAllPanel);
                viewAllPanel.validate();
                viewAllPanel.repaint();
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
                mainHomeBtnsPanel.setVisible(false);


                ProgressReportPanel progressReportPanel = new ProgressReportPanel(mygradebook);
                homeFrame.add(progressReportPanel);
                progressReportPanel.validate();
                progressReportPanel.repaint();
            }
        });
        mainHomeBtnsPanel.add(calcButn);

    }


    public void saveButton() {
        JButton saveButn = new JButton("Save");
        saveButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        saveButn.setBounds(250, 560, 90, 50);
        saveButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        saveButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveGradeBook();
            }
        });
        mainHomeBtnsPanel.add(saveButn);


    }


    // EFFECTS: saves the GradeBook to file
    private void saveGradeBook() {
        try {
            jsonWriter.open();
            jsonWriter.write(mygradebook);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null,
                    "Saved " + mygradebook.getName() + " to " + JSON_LOCATION);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to write to file: " + JSON_LOCATION);
        }
    }

    public void loadButton() {
        JButton loadButn = new JButton("Load");
        loadButn.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        loadButn.setBounds(30, 560, 90, 50);
        loadButn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        loadButn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loadGradeBook();
            }
        });
        mainHomeBtnsPanel.add(loadButn);

    }

    private void loadGradeBook() {
        try {
            mygradebook = jsonReader.read();
            JOptionPane.showMessageDialog(null,
                    "Loaded " + mygradebook.getName() + " from " + JSON_LOCATION);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to read from file: " + JSON_LOCATION);
        }
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

}



