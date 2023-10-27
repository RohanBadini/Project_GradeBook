package persistence;


import model.Course;
import model.GradeBook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads GradeBook from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads GradeBook from file and returns it;
    // throws IOException if an error occurs reading data from file
    public GradeBook read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses GradeBook from JSON object and returns it
    private GradeBook parseWorkRoom(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        GradeBook gb = new GradeBook(name);
        addCourses(gb, jsonObject);
        return gb;
    }

    // MODIFIES: gb
    // EFFECTS: parses courses from JSON object and adds them to GradeBook
    private void addCourses(GradeBook gb, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("courses");
        for (Object json : jsonArray) {
            JSONObject nextCourse = (JSONObject) json;
            addCourse(gb, nextCourse);
        }
    }

    // MODIFIES: gb
    // EFFECTS: parses courses from JSON object and adds it to GradeBook
    private void addCourse(GradeBook gb, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int credits = jsonObject.getInt("credits");
        int grade = jsonObject.getInt("grade");
        Course course = new Course(name, credits, grade);
        gb.addCourse(course);
    }
}
