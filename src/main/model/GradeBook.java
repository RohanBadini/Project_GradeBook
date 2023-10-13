package model;

import java.util.ArrayList;
import java.util.List;

public class GradeBook {
    private List<Course> coursesList;
    private int totalCredits;

    public GradeBook() {
        coursesList = new ArrayList<>();
        totalCredits = 0;
    }

    public void addCourse(Course course) {
        coursesList.add(course);
    }

    public void removeCourse(Course course) {
        coursesList.remove(course);
    }

    public int totalCredits() {
        totalCredits = 0;
        for (Course course : coursesList) {
            totalCredits += course.getCredits();
        }
        return totalCredits;
    }

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
