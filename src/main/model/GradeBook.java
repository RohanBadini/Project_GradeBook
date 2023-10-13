package model;

import java.util.ArrayList;
import java.util.List;

//Represents a GradeBook with List of Courses and total credits
public class GradeBook {
    private List<Course> coursesList;
    private int totalCredits;

    // EFFECTS: Constructs a grade book with an empty list and 0 gained credits
    public GradeBook() {
        coursesList = new ArrayList<>();
        totalCredits = 0;
    }

    //REQUIRES: credits > 0
    //MODIFIES: this, coursesList
    //EFFECTS: Adds the given course to the coursesList
    public void addCourse(Course course) {
        coursesList.add(course);

    }

    //MODIFIES: this,coursesList
    //EFFECTS: Removes a course from the coursesList
    public void removeCourse(Course course) {
        coursesList.remove(course);
    }

    //MODIFIES: this, totalCredits
    //EFFECTS: Adds up all the credits earned in every course of the coursesList
    public int totalCredits() {
        totalCredits = 0;
        for (Course course : coursesList) {
            totalCredits += course.getCredits();
        }
        return totalCredits;
    }


    //MODIFIES: this
    //EFFECTS: Calculate the overall average of all the courses in the coursesList
    public int totalAverage() {
        int totalCredsTimesGrade = 0;
        for (Course course : coursesList) {
            totalCredsTimesGrade = totalCredsTimesGrade + (course.getGrade() * course.getCredits());
        }
        return (totalCredsTimesGrade / totalCredits());
    }

    public List<Course> getCourses() {
        return coursesList;
    }


}
