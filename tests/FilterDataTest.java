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
        assertEquals(2, FilterData.instructorFilter(exampleCourses,
                "Sayuri").size());
    }

    @Test
    public void numberFilter() {
        assertEquals(9, FilterData.numberFilter(exampleCourses,
                592, 594).size());
    }

    @Test
    public void classSizeFilter() {
        assertEquals(2586, FilterData.classSizeFilter(exampleCourses,
                0, 1000000).size());
    }

    @Test
    public void averageGradeFilter() {
        assertEquals(499, FilterData.averageGradeFilter(exampleCourses,
                0.0, 2.99).size());
    }

    @Test
    public void titleFilter() {
        assertEquals(3, FilterData.titleFilter(exampleCourses, "federal").size());
    }
}