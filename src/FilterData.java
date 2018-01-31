import java.util.ArrayList;

public class FilterData {

    /**
     *
     * @param courses an Array List of Course containing courses that are to be filtered.
     * @param subject the subject that the user is filtering by.
     * @return an Array List of Course that only contains the courses of the subject that was passed in.
     */
    public static ArrayList<Course> subjectFilter(ArrayList<Course> courses, String subject){
        ArrayList<Course> filtered = new ArrayList<Course>();
        for(Course currentCourse : courses){
            if(currentCourse.getSubject().equals(subject)){
                filtered.add(currentCourse);
            }
        }
        return filtered;
    }

    /**
     *
     * @param courses an Array List of Course containing courses that are to be filtered.
     * @param instructor the instructor the user is searching for.
     * @return an Array List of Course that only contains the courses of the instructor that was passed in.
     */
    public static ArrayList<Course> instructorFilter(ArrayList<Course> courses, String instructor){
        ArrayList<Course> filtered = new ArrayList<Course>();
        for(Course currentCourse : courses){
            if(currentCourse.getInstructor().toLowerCase().contains(instructor.toLowerCase())){
                filtered.add(currentCourse);
            }
        }
        return filtered;
    }

    /**
     *
     * @param courses an Array List of Course containing courses that are to be filtered.
     * @param low the initial number of the range being searched.
     * @param high the final number of the range being searched.
     * @return an Array List of Course that only contains the courses of the range that was passed in.
     */
    public static ArrayList<Course> numberFilter(ArrayList<Course> courses, int low, int high){
        ArrayList<Course> filtered = new ArrayList<Course>();
        for(Course currentCourse : courses){
            if(currentCourse.getNumber() >= low && currentCourse.getNumber() <= high){
                filtered.add(currentCourse);
            }
        }
        return filtered;
    }

    /**
     *
     * @param courses an Array List of Course containing courses that are to be filtered.
     * @param low the initial number of the range being searched.
     * @param high the final number of the range being searched.
     * @return an Array List of Course that only contains the courses of the range that was passed in.
     */
    public static ArrayList<Course> classSizeFilter(ArrayList<Course> courses, int low, int high){
        ArrayList<Course> filtered = new ArrayList<Course>();
        for(Course currentCourse : courses){
            if(currentCourse.getClassSize() >= low && currentCourse.getClassSize() <= high){
                filtered.add(currentCourse);
            }
        }
        return filtered;
    }

    /**
     *
     * @param courses an Array List of Course containing courses that are to be filtered.
     * @param low the initial number of the range being searched.
     * @param high the final number of the range being searched.
     * @return an Array List of Course that only contains the courses of the range that was passed in.
     */
    public static ArrayList<Course> averageGradeFilter(ArrayList<Course> courses, double low, double high){
        ArrayList<Course> filtered = new ArrayList<Course>();
        for(Course currentCourse : courses){
            if(currentCourse.getAverage() >= low && currentCourse.getAverage() <= high){
                filtered.add(currentCourse);
            }
        }
        return filtered;
    }

    /**
     *
     * @param courses an Array List of Course containing courses that are to be filtered.
     * @param title the title of the class being searched for.
     * @return an Array List of Course that only contains the courses of the title that was passed in.
     */
    public static ArrayList<Course> titleFilter(ArrayList<Course> courses, String title){
        ArrayList<Course> filtered = new ArrayList<Course>();
        for(Course currentCourse : courses){
            if(currentCourse.getTitle().toLowerCase().contains(title.toLowerCase())){
                filtered.add(currentCourse);
            }
        }
        return filtered;
    }



}
