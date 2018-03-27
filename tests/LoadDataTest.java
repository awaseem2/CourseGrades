import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class LoadDataTest {

    ArrayList<Course> singleJsonCourses;
    ArrayList<Course> multipleJsonsCourses;
    List<String> multipleJsonFileNames = Arrays.asList("TwoExampleCourses.json",
            "ThreeExampleCourses.json");

    @Before
    public void setUp() {
        singleJsonCourses = LoadData.singleFileToCourses("TwoExampleCourses.json");
        multipleJsonsCourses = LoadData.multipleFilesToCourses(multipleJsonFileNames);
    }

    @Test
    public void singleFileToCourses() {
        assertTrue(singleJsonCourses.size() == 2);

        int[] courseCrns = {41758, 47100};
        for (int i = 0; i < courseCrns.length; i++) {
            assertEquals(courseCrns[i], singleJsonCourses.get(i).getCrn());
        }
    }

    @Test
    public void multipleFilesToCourses() {
        assertTrue(multipleJsonsCourses.size() == 5);

        int[] courseCrns = {41758, 47100, 57705, 56301, 42926};
        for (int i = 0; i < courseCrns.length; i++) {
            assertEquals(courseCrns[i], multipleJsonsCourses.get(i).getCrn());
        }
    }
}

