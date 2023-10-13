package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Represents a Test for GradeBook with List of Courses and total credits
public class GradeBookTest {
    private GradeBook testGradeBook;
    private Course cpsc310;
    private Course cpsc110;
    private Course cpsc121;


    @BeforeEach
    void runBefore() {
        testGradeBook = new GradeBook();
        cpsc310 = new Course("CPSC 310", 3,89);
        cpsc110 = new Course("CPSC 110", 4, 92);
        cpsc121 = new Course("CPSC 121", 4, 78);

    }

    @Test

    void testConstructor() {
        assertTrue(testGradeBook.getCourses().isEmpty());
        assertEquals(0, testGradeBook.totalCredits());
    }

    @Test

    void testAddOneCourse() {
        testGradeBook.addCourse(cpsc310);
        assertEquals(1, testGradeBook.getCourses().size());
        assertEquals("CPSC 310", testGradeBook.getCourses().get(0).getName());
        assertEquals(3,testGradeBook.getCourses().get(0).getCredits());
        assertEquals(89,testGradeBook.getCourses().get(0).getGrade());

    }

   @Test

    void testAddTwoCourses() {
        testGradeBook.addCourse(cpsc310);
        testGradeBook.addCourse(cpsc110);
        assertEquals(2, testGradeBook.getCourses().size());
        assertEquals("CPSC 310", testGradeBook.getCourses().get(0).getName());
        assertEquals(3,testGradeBook.getCourses().get(0).getCredits());
        assertEquals(89,testGradeBook.getCourses().get(0).getGrade());


        assertEquals("CPSC 110", testGradeBook.getCourses().get(1).getName());
        assertEquals(4,testGradeBook.getCourses().get(1).getCredits());
        assertEquals(92,testGradeBook.getCourses().get(1).getGrade());

    }

    @Test

    void testRemoveOnlyCourse() {
        testGradeBook.addCourse(cpsc310);
        testGradeBook.removeCourse(cpsc310);

        assertTrue(testGradeBook.getCourses().isEmpty());
        assertEquals(0, testGradeBook.totalCredits());

    }

    @Test

    void testRemoveCourse() {
        testGradeBook.addCourse(cpsc310);
        testGradeBook.addCourse(cpsc110);
        testGradeBook.addCourse(cpsc121);

        testGradeBook.removeCourse(cpsc110);
        assertEquals(2, testGradeBook.getCourses().size());
        assertEquals("CPSC 310", testGradeBook.getCourses().get(0).getName());
        assertEquals("CPSC 121", testGradeBook.getCourses().get(1).getName());



    }

    @Test

    void testRemoveCourseMore() {
        testGradeBook.addCourse(cpsc310);
        testGradeBook.addCourse(cpsc110);
        testGradeBook.addCourse(cpsc121);

        testGradeBook.removeCourse(cpsc110);
        testGradeBook.removeCourse(cpsc310);
        assertEquals(1, testGradeBook.getCourses().size());
        assertEquals("CPSC 121", testGradeBook.getCourses().get(0).getName());



    }

    @Test

    void testTotalCreditsOne() {
        assertTrue(testGradeBook.getCourses().isEmpty());
        testGradeBook.addCourse(cpsc110);

        assertEquals(1,testGradeBook.getCourses().size());
        assertEquals("CPSC 110", testGradeBook.getCourses().get(0).getName());
        assertEquals(4,testGradeBook.totalCredits());

    }

    @Test

    void testTotalCreditsMany() {
        assertTrue(testGradeBook.getCourses().isEmpty());
        testGradeBook.addCourse(cpsc110);
        testGradeBook.addCourse(cpsc310);
        testGradeBook.addCourse(cpsc121);
        assertEquals(3,testGradeBook.getCourses().size());
        assertEquals(11,testGradeBook.totalCredits());
    }

    @Test

    void testTotalCreditsEmpty() {
        assertTrue(testGradeBook.getCourses().isEmpty());

        assertEquals(0, testGradeBook.getCourses().size());
        assertEquals(0, testGradeBook.totalCredits());
    }


    @Test

    void testTotalAverageOne() {
        testGradeBook.addCourse(cpsc110);
        assertEquals(1, testGradeBook.getCourses().size());
        assertEquals(92, testGradeBook.totalAverage());

    }


@Test
    void testTotalAverageMany() {
    assertTrue(testGradeBook.getCourses().isEmpty());
    testGradeBook.addCourse(cpsc110);
    testGradeBook.addCourse(cpsc310);
    testGradeBook.addCourse(cpsc121);

    assertEquals(3, testGradeBook.getCourses().size());
    assertEquals(86,testGradeBook.totalAverage());



}


}
