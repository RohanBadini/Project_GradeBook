package model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Represents the Test for Course class with name, credits and grade
class CourseTest {

    private Course cpsc310;
    private Course cpsc213;

    @BeforeEach

    void runBefore() {
        cpsc310 = new Course("CPSC 310",3,82);
        cpsc213 = new Course("CPSC 213",4,91);
    }

    @Test

    void testConstructor() {
        assertEquals("CPSC 213", cpsc213.getName());
        assertEquals("CPSC 310",cpsc310.getName());
        assertEquals(3, cpsc310.getCredits());
        assertEquals(4,cpsc213.getCredits());
        assertEquals(82,cpsc310.getGrade());
        assertEquals(91,cpsc213.getGrade());

    }


}