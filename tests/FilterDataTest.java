import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FilterDataTest {
    private ArrayList<Course> exampleCourses;

    @Before
    public void setUp() {
        exampleCourses = LoadData.singleFileToCourses("Fall2013.json");
    }

    @Test
    public void validInputSubjectFilter() {
        assertEquals(7, FilterData.subjectFilter(exampleCourses, "AAS").size());
    }

    @Test
    public void nullInputSubjectFilter(){
        try {
            FilterData.subjectFilter(exampleCourses, null);
        }
        catch(IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void inputWithNumberSubjectFilter(){
        try {
            FilterData.subjectFilter(exampleCourses, "L4S");
        }
        catch(IllegalArgumentException e){
            assertEquals(ErrorConstants.CONTAINS_DIGIT, e.getMessage());
        }
    }

    @Test
    public void validInputInstructorFilter() {
        assertEquals(2, FilterData.instructorFilter(exampleCourses,
                "Sayuri").size());
    }

    @Test
    public void nullInputInstructor(){
        try {
            FilterData.instructorFilter(exampleCourses, null);
        }
        catch(IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void inputWithNumberInstructorFilter(){
        try {
            FilterData.subjectFilter(exampleCourses, "Say6ri");
        }
        catch(IllegalArgumentException e){
            assertEquals(ErrorConstants.CONTAINS_DIGIT, e.getMessage());
        }
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
    public void outOfBoundsAverageGradeFilter() {
        try {
            FilterData.averageGradeFilter(exampleCourses, 5.2, 3.1);
        }
        catch(IllegalArgumentException e){
            assertEquals(ErrorConstants.OUT_OF_BOUNDS_INPUT, e.getMessage());
        }
    }

    @Test
    public void validInputTitleFilter() {
        assertEquals(3, FilterData.titleFilter(exampleCourses, "federal").size());
    }

    @Test
    public void nullInputTitle(){
        try {
            assertEquals("", FilterData.titleFilter(exampleCourses, null));
        }
        catch(IllegalArgumentException e){
            assertEquals(ErrorConstants.NULL_INPUT, e.getMessage());
        }
    }

    @Test
    public void inputWithNumberTitleFilter(){
        try {
            FilterData.subjectFilter(exampleCourses, "f3deral");
        }
        catch(IllegalArgumentException e){
            assertEquals(ErrorConstants.CONTAINS_DIGIT, e.getMessage());
        }
    }


}

