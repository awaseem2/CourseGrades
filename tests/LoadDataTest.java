import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LoadDataTest {

    List<String> coursesExampleList;
    Course[] coursesExampleArray;

    @Before
    public void setUp() {
        Gson gson = new Gson();
        coursesExampleList = Arrays.asList("Fall2013.json");
        coursesExampleArray = gson.fromJson(Data.getFileContentsAsString("Fall2013.json"),
                Course[].class);
    }

    @Test
    public void fileToCourses() {
        assertEquals(Arrays.asList(coursesExampleArray),
                LoadData.fileToCourses("Fall2013.json"));
    }
}