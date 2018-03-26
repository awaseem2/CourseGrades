import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadData {

    /**
     * Converts the name of a Json file to an ArrayList of Courses.
     *
     * @param fileName the .json file string name that is to be converted to an Array List.
     * @return an Array List of Course converted from the .json file.
     */
    public static ArrayList<Course> singleFileToCourses(String fileName) {
        Gson gson = new Gson();
        Course[] coursesArray = gson.fromJson(Data.getFileContentsAsString(fileName),
                Course[].class);

        return new ArrayList<>(Arrays.asList(coursesArray));
    }

    /**
     * Converts multiple file names of Jsons to an ArrayList of Courses.
     *
     * @param fileNames an Array List of .json file string names.
     * @return an Array List of Course converted from the .json files.
     */
    public static ArrayList<Course> multipleFilesToCourses(List<String> fileNames) {
        ArrayList<Course> courses = new ArrayList<>();
        for (String currentFile : fileNames) {
            courses.addAll(singleFileToCourses(currentFile));
        }

        return courses;
    }
}


