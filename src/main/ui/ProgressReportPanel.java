package ui;

import model.Course;
import model.GradeBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProgressReportPanel extends JPanel {
    private JLabel pageTitle;
    private JLabel averageTotalLabel;
    private JLabel creditsTotalLabel;
    private JScrollPane reportDisplay;
    GradeBook mygradebook;
    private List<String> coursenames;
    private int average;


    public ProgressReportPanel(GradeBook mygradebook) {
        super();
        this.mygradebook = mygradebook;
        backbutton();
        panelLayout();
        panelMainLabel();
        panelSubLabels();
        panelScroller();
        averageAndCreditsLabel();
    }

    public void panelScroller() {
        runViewAllCourses();
        String[] array = coursenames.toArray(new String[coursenames.size()]);
        JList<String> list = new JList<>(array);
        reportDisplay = new JScrollPane(list);
        list.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        reportDisplay.setBounds(100, 170, 360, 330);
        reportDisplay.setVisible(true);
        add(reportDisplay);

    }

    public void runViewAllCourses() {
        coursenames = new ArrayList<>();
        if (mygradebook.getCourses().isEmpty()) {
//            coursenames = <>;
        } else {
            for (int r = 0; r < mygradebook.getCourses().size(); r++) {
                Course rcourse = mygradebook.getCourses().get(r);
                coursenames.add(rcourse.getName() + "           " + rcourse.getCredits()
                        + "                   " + rcourse.getGrade());
            }

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bgImage = new ImageIcon("data/shutterstock_301818437.jpg").getImage();
        g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
    }

    public void panelMainLabel() {

        pageTitle = new JLabel("<html><u>Overall Progress</u></html>");
        pageTitle.setBounds(200, 80, 200, 50);
        pageTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        pageTitle.setForeground(Color.orange);
        pageTitle.setBackground(Color.black);
        pageTitle.setOpaque(true);

        add(pageTitle);

    }

    public void panelSubLabels() {

        creditsTotalLabel = new JLabel("Total Credits Earned :");
        creditsTotalLabel.setBounds(90, 500, 180, 50);
        creditsTotalLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        creditsTotalLabel.setForeground(Color.green);
        creditsTotalLabel.setBackground(Color.black);
        creditsTotalLabel.setOpaque(true);

        averageTotalLabel = new JLabel("Grade Average :");
        averageTotalLabel.setBounds(140, 550, 130, 50);
        averageTotalLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        averageTotalLabel.setForeground(Color.green);
        averageTotalLabel.setBackground(Color.black);
        averageTotalLabel.setOpaque(true);

        JLabel columnNameLabel = new JLabel("Name" + "            " + "Credits" + "         " + "Grade");
        columnNameLabel.setBounds(100, 145, 360, 27);
        columnNameLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        columnNameLabel.setForeground(Color.black);
        columnNameLabel.setBackground(Color.white);
        columnNameLabel.setOpaque(true);

        add(averageTotalLabel);
        add(creditsTotalLabel);
        add(columnNameLabel);

    }

    public void averageAndCreditsLabel() {

        if (mygradebook.getCourses().size() == 0) {
            average = 0;
        } else {
            average = mygradebook.totalAverage();
        }

        JLabel valAverageLabel = new JLabel("  " + average + " %");
        valAverageLabel.setBounds(280, 567, 60, 20);
        valAverageLabel.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        valAverageLabel.setForeground(Color.black);
        valAverageLabel.setBackground(Color.white);
        valAverageLabel.setOpaque(true);

        add(valAverageLabel);


        JLabel valCreditsLabel = new JLabel("   " + mygradebook.totalCredits());
        valCreditsLabel.setBounds(280, 517, 60, 20);
        valCreditsLabel.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        valCreditsLabel.setForeground(Color.black);
        valCreditsLabel.setBackground(Color.white);
        valCreditsLabel.setOpaque(true);

        add(valAverageLabel);
        add(valCreditsLabel);

    }


    public void panelLayout() {
        setLayout(null);
        setBounds(300, 0, 600, 622);
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
