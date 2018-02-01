import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadData {

    /**
     *
     * @param fileName is the .json file string name that is to be converted to an Array List.
     * @return an Array List of Course converted from the .json file.
     */
    public static ArrayList<Course> fileToCourses(String fileName) {
        Gson gson = new Gson();
        Course[] coursesArray = gson.fromJson(Data.getFileContentsAsString(fileName),
                Course[].class);
        return new ArrayList<>(Arrays.asList(coursesArray));
    }

    /**
     *
     * @param fileNames is an Array List of .json file string names.
     * @return an Array List of Course converted from the .json files.
     */
    public ArrayList<Course> filesToCourses (List<String> fileNames) {
        ArrayList<Course> courses = new ArrayList<>();
        for(String currentFile : fileNames) {
            courses.addAll(fileToCourses(currentFile));
        }

        return courses;
    }
}
