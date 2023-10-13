package ui;

import model.Course;
import model.GradeBook;

import java.util.List;
import java.util.Scanner;

///This class is inspired from Teller App https://github.students.cs.ubc.ca/CPSC210/TellerApp

//Represents Student Grade Book Application
public class GradeBookApp {
    private Scanner input;
    private GradeBook gradeBook;

    // EFFECTS: runs the Grade Book application
    public GradeBookApp() {
        runGradeBook();
    }

    // MODIFIES: this
    // EFFECTS: processes user's input
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

    // MODIFIES: this
    // EFFECTS: processes user given command
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

    // MODIFIES: this
    // EFFECTS: initializes GradeBook
    public void initialize() {
        gradeBook = new GradeBook();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays the available options to user
    public void chooseOptions() {
        System.out.println("\nWelcome to Student Grade Book. Please select an option:");
        System.out.println("\ta -> Add Course to the Grade Book");
        System.out.println("\tr -> Remove Course from the Grade Book");
        System.out.println("\tv -> View All Courses in the Grade Book");
        System.out.println("\tg -> View Total Average and Credits Earned");
        System.out.println("\tq -> Quit Application");
    }

    //MODIFIES: this, coursesList
    //EFFECTS: Adds a Course with details provided by user
    public void runAddCourse() {
        System.out.println("Enter the Course that you would like to add:");
        String name = input.next().toUpperCase();
        System.out.println("Enter course credits:");
        int credits = input.nextInt();
        System.out.println("Enter your Grade:");
        int grade = input.nextInt();

        Course course = new Course(name, credits, grade);

        if (!gradeBook.getCourses().isEmpty() && isCourseAlreadyAdded(name)) {
            System.out.println("Sorry! This course has already been added!!!");
        } else {
            gradeBook.addCourse(course);
            System.out.println("Course has been added successfully!");
        }

    }

    //EFFECTS: Helper for runAddCourse to check if the course is already there
    public boolean isCourseAlreadyAdded(String courseName) {
        for (Course exCourse : gradeBook.getCourses()) {
            if (courseName.equals(exCourse.getName())) {
                return true;
            }
        }
        return false;
    }


    // MODIFIES: this
    // EFFECTS: Processes the user input to remove a course
    public void runRemoveCourse() {
        if (gradeBook.getCourses().isEmpty()) {
            System.out.println("\n Grade Book is empty!!!");
        } else {
            boolean state = true;
            while (state) {
                removeOps();
                String removeInput = input.next();
                if (removeInput.equals("r")) {
                    deleteCourse();
                    state = false;
                } else if (removeInput.equals("c")) {
                    clearAllCourses();
                    state = false;
                } else {
                    System.out.println("Sorry! Invalid Selection. Please try again...");
                }

            }


        }

    }

    // EFFECTS: displays the available remove options to user
    public void removeOps() {
        System.out.println("\n Please select an option:");
        System.out.println("\tr -> Remove a Course");
        System.out.println("\tc -> Clear all courses");
    }

    // MODIFIES: this, coursesList
    // EFFECTS: deletes a Course using the name input provided by user
    public void deleteCourse() {

        System.out.println("\n Enter the course name to delete:");
        boolean isRemoved = false;
        String removeInput = input.next().toUpperCase();
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

    // MODIFIES: this, coursesList
    // EFFECTS: Removes all the Courses from the Grade Book
    public void clearAllCourses() {

        gradeBook.getCourses().clear();
        System.out.println("All the courses are now removed");


    }

    // EFFECTS: Displays all the names of the courses in the coursesList
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

    //EFFECTS: displays the total average and credits of all courses in the coursesList along with
    // all the details of each course including the grade and credits.
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







