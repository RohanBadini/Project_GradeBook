package persistence;

import model.Course;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
        protected void checkCourse(String name, int credits, int grade, Course course) {
            assertEquals(name, course.getName());
            assertEquals(credits, course.getCredits());
            assertEquals(grade, course.getGrade());
        }
    }
