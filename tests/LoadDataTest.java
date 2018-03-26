import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LoadDataTest {

    ArrayList<Course> singleJsonExample;
    List<String> listOfJsonFiles = Arrays.asList("TwoExampleCourses.json",
            "ThreeExampleCourses.json");
    ArrayList<Course> multipleJsonsExample;

    @Before
    public void setUp() {
        singleJsonExample = LoadData.singleFileToCourses("TwoExampleCourses.json");
        multipleJsonsExample = LoadData.multipleFilesToCourses(listOfJsonFiles);
    }

    @Test
    public void singleFileToCourses() {
        assertEquals(41758, singleJsonExample.get(0).getCrn());
        assertEquals(47100, singleJsonExample.get(1).getCrn());
    }

    @Test
    public void multipleFilesToCourses() {
        assertEquals(41758, multipleJsonsExample.get(0).getCrn());
        assertEquals(47100, multipleJsonsExample.get(1).getCrn());
        assertEquals(57705, multipleJsonsExample.get(2).getCrn());
        assertEquals(56301, multipleJsonsExample.get(3).getCrn());
        assertEquals(42926, multipleJsonsExample.get(4).getCrn());
    }
}

