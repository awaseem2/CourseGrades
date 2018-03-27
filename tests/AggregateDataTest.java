import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AggregateDataTest {
    private ArrayList<Course> exampleCourses;

    @Before
    public void setUp() {
        exampleCourses = LoadData.singleFileToCourses("TwoExampleCourses.json");
    }

    @Test
    public void totalStudents() {
        assertEquals(68,
                AggregateData.totalStudents(exampleCourses));
    }

    @Test
    public void totalStudentsByGradeCorrectIndexOrder() {
        assertEquals(39,  AggregateData.totalStudentsByGrade(exampleCourses,
                "A+", "A"));
    }

    @Test
    public void totalStudentsByGradeBackwardsIndexOrder() {
        assertEquals(39,  AggregateData.totalStudentsByGrade(exampleCourses,
                "A", "A+"));
    }

    @Test
    public void gradeStringToIndexValidInput() {
        assertEquals(3, AggregateData.gradeStringToIndex("B+"));
    }

    @Test
    public void gradeStringToIndexInvalidInput() {
        try {
            AggregateData.gradeStringToIndex("E");
        } catch(IllegalArgumentException e) {
            assertEquals(ErrorConstants.INVALID_GRADE, e.getMessage());
        }
    }

    @Test
    public void gpaAveragesByEnrollment() {
        assertEquals(3.68,
                AggregateData.gpaAveragesByEnrollment(exampleCourses), 0.01);
    }
}

