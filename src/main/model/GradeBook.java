package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

//Represents a GradeBook with List of Courses and total credits
public class GradeBook implements Writable {
    private List<Course> coursesList;
    private int totalCredits;
    private String name;

    // EFFECTS: Constructs a grade book with an empty list and 0 gained credits
    public GradeBook(String name) {
        this.name = name;
        coursesList = new ArrayList<>();
        totalCredits = 0;
    }

    public String getName() {
        return name;
    }

    //REQUIRES: credits > 0
    //MODIFIES: this, coursesList
    //EFFECTS: Adds the given course to the coursesList
    public void addCourse(Course course) {
        EventLog.getInstance().logEvent(new Event(course.getName() + " has been added to the GradeBook"));
        coursesList.add(course);

    }

    //MODIFIES: this,coursesList
    //EFFECTS: Removes a course from the coursesList
    public void removeCourse(Course course) {
        EventLog.getInstance().logEvent(new Event(course.getName() + " has been removed from the GradeBook"));
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


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("courses", coursesToJson());
        return json;
    }

    // EFFECTS: returns courses in this GradeBook as a JSON array
    private JSONArray coursesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Course c : coursesList) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }


}
