import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FilterDataTest {
    private ArrayList<Course> exampleCourses;

    @Before
    public void setUp() {
        exampleCourses = LoadData.fileToCourses("Fall2013.json");
    }

    @Test
    public void subjectFilter() {
        assertEquals(7, FilterData.subjectFilter(exampleCourses, "AAS").size());
    }

    @Test
    public void instructorFilter() {
        assertEquals(2, FilterData.instructorFilter(exampleCourses, "Sayuri").size());
    }

    @Test
    public void numberFilter() {
        assertEquals(2, FilterData.numberFilter(exampleCourses, 592, 594).size());
    }

    @Test
    public void classSizeFilter() {
    }

    @Test
    public void averageGradeFilter() {
    }

    @Test
    public void titleFilter() {
    }
}