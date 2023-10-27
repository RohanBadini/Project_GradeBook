package model;

import org.json.JSONObject;
import persistence.Writable;

//Represents a Course with name, credits and grade
public class Course implements Writable {
    private String name;
    private int credits;
    private int grade;


    // REQUIRES: credits > 0, and credits, grade should be int
    // EFFECTS: constructs a Course with a given name, gained credits and earned grade
    public Course(String name, int credits, int grade) {
        this.name = name.toUpperCase();
        this.credits = credits;
        this.grade = grade;
    }


    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("credits", credits);
        json.put("grade", grade);
        return json;
    }



}
