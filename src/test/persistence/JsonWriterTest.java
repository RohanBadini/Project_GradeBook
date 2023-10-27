package persistence;

import model.Course;
import model.GradeBook;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            GradeBook wr = new GradeBook("My grade book");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            GradeBook gb = new GradeBook("My grade book");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyGradeBook.json");
            writer.open();
            writer.write(gb);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyGradeBook.json");
            gb = reader.read();
            assertEquals("My grade book", gb.getName());
            assertEquals(0, gb.getCourses().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            GradeBook gb = new GradeBook("My grade book");
            gb.addCourse(new Course("CPSC 210", 4, 98));
            gb.addCourse(new Course("CPSC 110", 4, 89));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralGradeBook.json");
            writer.open();
            writer.write(gb);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralGradeBook.json");
            gb = reader.read();
            assertEquals("My grade book", gb.getName());
            List<Course> courses = gb.getCourses();
            assertEquals(2, courses.size());
            checkCourse("CPSC 210", 4, 98, courses.get(0));
            checkCourse("CPSC 110", 4, 89, courses.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}