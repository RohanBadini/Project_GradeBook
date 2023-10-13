package model;

public class Course {
    private String name;
    private int credits;
    private int grade;



    public Course(String name, int credits, int grade) {
        this.name = name;
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


}
