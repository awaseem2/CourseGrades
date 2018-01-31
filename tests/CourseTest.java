import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    private String singleCourseData = "{ \"CRN\": 36552, \"Subject\": \"ACCY\", \"Number\": 202, \"Title\": \"Accounting and Accountancy II\", \"Section\": \"AD1\", \"Type\": \"DIS\", \"Term\": 120138, \"Instructor\": \"Le, Nga H\", \"Grades\": [1, 9, 6, 4, 10, 1, 3, 3, 3, 0, 1, 0, 1, 0], \"Average\": 3.02 }";
    private Course courseExample = new Course();

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        courseExample = gson.fromJson(singleCourseData, Course.class);
    }

    @Test
    public void getCrn() {
        assertEquals(36552, courseExample.getCrn());
    }

    @Test
    public void getSubject() {
        assertEquals("ACCY", courseExample.getSubject());
    }

    @Test
    public void getNumber() {
        assertEquals(202, courseExample.getNumber());
    }

    @Test
    public void getTitle() {
        assertEquals("Accounting and Accountancy II", courseExample.getTitle());
    }

    @Test
    public void getSection() {
        assertEquals("AD1", courseExample.getSection());
    }

    @Test
    public void getType() {
        assertEquals("DIS", courseExample.getType());
    }

    @Test
    public void getTerm() {
        assertEquals(120138, courseExample.getTerm());
    }

    @Test
    public void getInstructor() {
        assertEquals("Le, Nga H", courseExample.getInstructor());
    }

    @Test
    public void getGrades() {
        assertArrayEquals(new int[] {1, 9, 6, 4, 10, 1, 3, 3, 3, 0, 1, 0, 1, 0}, courseExample.getGrades());
    }

    @Test
    public void getAverage() {
        assertEquals(3.02, courseExample.getAverage(), 0);
    }
}