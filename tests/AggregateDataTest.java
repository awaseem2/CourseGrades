import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AggregateDataTest {
    private ArrayList<Course> exampleCourses;

    @Before
    public void setUp() {
        exampleCourses = LoadData.fileToCourses("ExampleCourses.json");
    }

    @Test
    public void totalStudents() {
        assertEquals(68,
                AggregateData.totalStudents(exampleCourses));
    }

    @Test
    public void totalStudentsByGrade() {
        assertEquals(39,  AggregateData.totalStudentsByGrade(exampleCourses,
                "A+", "A"));
    }

    @Test
    public void gpaAveragesByEnrollment() {
        assertEquals(3.68,
                AggregateData.gpaAveragesByEnrollment(exampleCourses), 0.01);
    }
}