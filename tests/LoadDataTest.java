import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LoadDataTest {

    private ArrayList<Course> coursesExample = new ArrayList<Course>();


    @Before
    public void setUp() {
        Gson gson = new Gson();
        coursesExample = gson.fromJson(Data.getFileContentsAsString("Fall2013.json"), ArrayList.class);
    }

    @Test
    public void fileToCourses() {
        assertEquals(coursesExample, LoadData.fileToCourses("Fall2013.json"));
    }

    /*@Test
    public void filesToCourses() {
        assertEquals(coursesExample, LoadData.fileToCourses(coursesExample));

    }
    */
}