package persistence;

import model.Course;
import model.GradeBook;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            GradeBook gb = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyGradeBook.json");
        try {
            GradeBook gb = reader.read();
            assertEquals("My grade book", gb.getName());
            assertEquals(0, gb.getCourses().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralGradeBook.json");
        try {
            GradeBook gb = reader.read();
            assertEquals("My grade book", gb.getName());
            List<Course> courses = gb.getCourses();
            assertEquals(2, courses.size());
            checkCourse("CPSC 210", 4, 98, courses.get(0));
            checkCourse("CPSC 110", 4, 89, courses.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}