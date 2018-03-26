import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CourseTest {

    private String singleCourseData = "{ \"CRN\": 36552, \"Subject\": \"ACCY\", \"Number\": 202," +
            "\"Title\": \"Accounting and Accountancy II\", \"Section\": \"AD1\", \"Type\": " +
            "\"DIS\", \"Term\": 120138, \"Instructor\": \"Le, Nga H\", \"Grades\": " +
            "[1, 9, 6, 4, 10, 1, 3, 3, 3, 0, 1, 0, 1, 0], \"Average\": 3.02 }";
    private String multipleCoursesData = "[{ \"CRN\": 32330, \"Subject\": \"GER\", \"Number\": " +
            "103, \"Title\": \"Intermediate German I\", \"Section\": \"D\", \"Type\": \"LCD\", " +
            "\"Term\": 120138, \"Instructor\": \"Grotovsky, Zachary P\", \"Grades\": " +
            "[0, 6, 6, 4, 3, 0, 3, 0, 1, 0, 1, 0, 1, 0], \"Average]\": 3.12 }," +
            "{ \"CRN\": 34128, \"Subject\": \"HIST\", \"Number\": 171, \"Title\": " +
            "\"US Hist to 1877\", \"Section\": \"AD7\", \"Type\": \"DIS\", \"Term\": 120138, " +
            "\"Instructor\": \"Lehman, David B\", \"Grades\": " +
            "[0, 1, 6, 5, 2, 3, 1, 4, 0, 0, 0, 0, 0, 0], \"Average\": 3.05 }," +
            "{ \"CRN\": 43953, \"Subject\": \"LAW\", \"Number\": 629, \"Title\": " +
            "\"Bankruptcy\", \"Section\": \"A\", \"Type\": \"LCD\", \"Term\": 120138, " +
            "\"Instructor\": \"Foohey, Pamela\", \"Grades\": " +
            "[1, 4, 12, 10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0], \"Average\": 3.44 }]";
    private Course singleCourse = new Course();
    private Course[] multipleCourses;

    @Before
    public void setUp() {
        Gson gson = new Gson();
        singleCourse = gson.fromJson(singleCourseData, Course.class);
        multipleCourses = gson.fromJson(multipleCoursesData, Course[].class);
    }

    @Test
    public void getCrnSingleCourse() {
        assertEquals(36552, singleCourse.getCrn());
    }

    @Test
    public void getCrnMultipleCourses() {
        int[] courseCrns = {32330, 34128, 43953};
        for (int i = 0; i < multipleCourses.length; i++) {
            assertEquals(courseCrns[i], multipleCourses[i].getCrn());
        }
    }

    @Test
    public void getSubjectSingleCourse() {
        assertEquals("ACCY", singleCourse.getSubject());
    }

    @Test
    public void getSubjectMultipleCourses() {
        String[] courseSubjects = {"GER", "HIST", "LAW"};
        for (int i = 0; i < multipleCourses.length; i++) {
            assertEquals(courseSubjects[i], multipleCourses[i].getSubject());
        }
    }

    @Test
    public void getNumberSingleCourse() {
        assertEquals(202, singleCourse.getNumber());
    }

    @Test
    public void getNumberMultipleCourses() {
        int[] courseNumbers = {103, 171, 629};
        for (int i = 0; i < multipleCourses.length; i++) {
            assertEquals(courseNumbers[i], multipleCourses[i].getNumber());
        }
    }

    @Test
    public void getTitleSingleCourse() {
        assertEquals("Accounting and Accountancy II", singleCourse.getTitle());
    }

    @Test
    public void getTitleMultipleCourses() {
        String[] courseTitles = {"Intermediate German I", "US Hist to 1877", "Bankruptcy"};
        for (int i = 0; i < multipleCourses.length; i++) {
            assertEquals(courseTitles[i], multipleCourses[i].getTitle());
        }
    }

    @Test
    public void getSectionSingleCourse() {
        assertEquals("AD1", singleCourse.getSection());
    }

    @Test
    public void getSectionMultipleCourses() {
        String[] courseSections = {"D", "AD7", "A"};
        for (int i = 0; i < multipleCourses.length; i++) {
            assertEquals(courseSections[i], multipleCourses[i].getSection());
        }
    }

    @Test
    public void getTypeSingleCourse() {
        assertEquals("DIS", singleCourse.getType());
    }

    @Test
    public void getTypeMultipleCourses() {
        String[] courseTypes = {"LCD", "DIS", "LCD"};
        for (int i = 0; i < multipleCourses.length; i++) {
            assertEquals(courseTypes[i], multipleCourses[i].getType());
        }
    }

    @Test
    public void getTermSingleCourse() {
        assertEquals(120138, singleCourse.getTerm());
    }

    @Test
    public void getTermMultipleCourses() {
        int[] courseTerms = {120138, 120138, 120138};
        for (int i = 0; i < multipleCourses.length; i++) {
            assertEquals(courseTerms[i], multipleCourses[i].getTerm());
        }
    }

    @Test
    public void getInstructorSingleCourse() {
        assertEquals("Le, Nga H", singleCourse.getInstructor());
    }

    @Test
    public void getInstructorMultipleCourses() {
        String[] courseInstructors = {"Grotovsky, Zachary P", "Lehman, David B", "Foohey, Pamela"};
        for (int i = 0; i < multipleCourses.length; i++) {
            assertEquals(courseInstructors[i], multipleCourses[i].getInstructor());
        }
    }

    @Test
    public void getGradesSingleCourse() {
        assertArrayEquals(new int[] {1, 9, 6, 4, 10, 1, 3, 3, 3, 0, 1, 0, 1, 0},
                singleCourse.getGrades());
    }

    @Test
    public void getGradesMultipleCourses() {
        List<int[]> courseGrades = Arrays.asList(new int[] {0, 6, 6, 4, 3, 0, 3, 0, 1, 0, 1,
                0, 1, 0}, new int[] {0, 1, 6, 5, 2, 3, 1, 4, 0, 0, 0, 0, 0, 0},
                new int[] {1, 4, 12, 10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0});
        for (int i = 0; i < multipleCourses.length; i++) {
            assertArrayEquals(courseGrades.get(i), multipleCourses[i].getGrades());
        }
    }

    @Test
    public void getAverageSingleCourse() {
        assertEquals(3.02, singleCourse.getAverage(), 0.01);
    }

    @Test
    public void getAverageMultipleCourses() {
        double[] courseAverages = {3.12, 3.05, 3.44};
        for (int i = 0; i < multipleCourses.length; i++) {
            assertEquals(courseAverages[i], multipleCourses[i].getAverage(), 0.01);
        }
    }
}