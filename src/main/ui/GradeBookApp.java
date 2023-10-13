package ui;

import model.Course;
import model.GradeBook;

import java.util.Scanner;

///This class is modeled after Teller App https://github.students.cs.ubc.ca/CPSC210/TellerApp

public class GradeBookApp {
    private Scanner input;
    private GradeBook gradeBook;


    public GradeBookApp() {
        runGradeBook();
    }


    public void runGradeBook() {
        boolean running = true;
        String givenCommand = null;

        initialize();

        while (running) {
            chooseOptions();
            givenCommand = input.next();
            givenCommand = givenCommand.toLowerCase();

            if (givenCommand.equals("q")) {
                running = false;
            } else {
                processGivenCmd(givenCommand);
            }
        }

        System.out.println("\nBye for now!");


    }

    public void processGivenCmd(String command) {
        if (command.equals("a")) {
            runAddCourse();
        } else if (command.equals("r")) {
            runRemoveCourse();
        } else if (command.equals("v")) {
            runViewAllCourses();
        } else if (command.equals("g")) {
            runAverageAndCredits();
        } else {
            System.out.println("Sorry! Invalid Selection. Please try again...");
        }
    }


    public void initialize() {
        gradeBook = new GradeBook();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }


    public void chooseOptions() {
        System.out.println("\nWelcome to Student Grade Book. Please select an option:");
        System.out.println("\ta -> Add Course to the Grade Book");
        System.out.println("\tr -> Remove Course from the Grade Book");
        System.out.println("\tv -> View All Courses in the Grade Book");
        System.out.println("\tg -> View Total Average and Credits Earned");
    }


    public void runAddCourse() {
        System.out.println("Enter the Course that you would like to add:");
        String name = input.next();
        System.out.println("Enter course credits:");
        int credits = input.nextInt();
        System.out.println("Enter your Grade:");
        int grade = input.nextInt();


        Course course = new Course(name, credits, grade);
        gradeBook.addCourse(course);

        System.out.println("Course has been added successfully!");
    }


    public void runRemoveCourse() {
        if (gradeBook.getCourses().isEmpty()) {
            System.out.println("\n Grade Book is empty!!!");
        } else {
            boolean state = true;
            while (state) {
                removeOps();
                String removeinput = input.next();
                if (removeinput.equals("r")) {
                    deleteCourse();
                    state = false;
                } else if (removeinput.equals("c")) {
                    clearAllCourses();
                    state = false;
                } else {
                    System.out.println("Sorry! Invalid Selection. Please try again...");
                }

            }


        }

    }

    public void removeOps() {
        System.out.println("\n Please select an option:");
        System.out.println("\tr -> Remove a Course");
        System.out.println("\tc -> Clear all courses");
    }

    public void deleteCourse() {

        System.out.println("\n Enter the course name to delete:");
        boolean isRemoved = false;
        String removeInput = input.next();
        for (Course rcourse : gradeBook.getCourses()) {
            if (removeInput.equals(rcourse.getName())) {
                gradeBook.removeCourse(rcourse);
                System.out.println("Course Removed Successfully");
                isRemoved = true;
                break;
            }
        }
        if (!isRemoved) {
            System.out.println("There is no course named " + removeInput);

        }


    }


    public void clearAllCourses() {

        gradeBook.getCourses().clear();
        System.out.println("All the courses are now removed");


    }

    public void runViewAllCourses() {
        if (gradeBook.getCourses().isEmpty()) {
            System.out.println("There are no courses to view. Try adding some courses..");
        } else {

            System.out.println("\n List of All Courses:");

            for (int r = 0; r < gradeBook.getCourses().size(); r++) {
                Course rcourse = gradeBook.getCourses().get(r);
                int t = r + 1;

                System.out.println(t + ". " + rcourse.getName());
            }

        }
    }

    public void runAverageAndCredits() {
        if (gradeBook.getCourses().isEmpty()) {
            System.out.println("\n Grade Book is empty!!! Add some courses..");
        } else {

            System.out.println("\n List of All Courses:");
            System.out.println("\t");
            for (int r = 0; r < gradeBook.getCourses().size(); r++) {
                Course rcourse = gradeBook.getCourses().get(r);
                int t = r + 1;

                System.out.println(t + ")" + " " + rcourse.getName() + "   "
                        + "credits: " + rcourse.getCredits() + "   " + "Grade: " + rcourse.getGrade() + "%");
            }

            System.out.println("\t");
            System.out.println("Total Average Grade of All Courses: " + gradeBook.totalAverage() + " %");
            System.out.println("\t");
            System.out.println("Total Credits Earned: " + gradeBook.totalCredits());

        }

    }

}







