import java.util.ArrayList;

public class FilterData {

    /**
     * Takes in a list of Courses and returns a list of the courses with the given subject.
     *
     * @param courses an Array List of Course containing courses that are to be filtered.
     * @param subject the subject that the user is filtering by.
     * @return an Array List of Course that only contains the courses of the subject that
     *         was passed in.
     */
    public static ArrayList<Course> subjectFilter(ArrayList<Course> courses, String subject) {
        handleStringErrors(subject);

        ArrayList<Course> filtered = new ArrayList<>();
        for (Course currentCourse : courses) {
            if (currentCourse.getSubject().equals(subject)) {
                filtered.add(currentCourse);
            }
        }

        return filtered;
    }

    /**
     * Takes in a list of Courses and returns a list of the courses with the given instructor.
     *
     * @param courses an Array List of Course containing courses that are to be filtered.
     * @param instructor the instructor the user is searching for.
     * @return an Array List of Course that only contains the courses of the instructor that
     *         was passed in.
     */
    public static ArrayList<Course> instructorFilter(ArrayList<Course> courses, String instructor) {
        handleStringErrors(instructor);

        ArrayList<Course> filtered = new ArrayList<>();
        for (Course currentCourse : courses) {
            if (currentCourse.getInstructor().toLowerCase().contains(instructor.toLowerCase())) {
                filtered.add(currentCourse);
            }
        }

        return filtered;
    }

    /**
     * Takes in a list of Courses and returns a list of the courses with a number between
     * a given range.
     *
     * @param courses an Array List of Course containing courses that are to be filtered.
     * @param low the initial number of the range being searched.
     * @param high the final number of the range being searched.
     * @return an Array List of Course that only contains the courses of the range that
     *         was passed in.
     */
    public static ArrayList<Course> numberFilter(ArrayList<Course> courses, int low, int high) {
        if (low > high) {
            int temp = low;
            low = high;
            high = temp;
        }

        ArrayList<Course> filtered = new ArrayList<>();
        for (Course currentCourse : courses) {
            if (currentCourse.getNumber() >= low && currentCourse.getNumber() <= high) {
                filtered.add(currentCourse);
            }
        }

        return filtered;
    }

    /**
     * Takes in a list of Courses and returns a list of the courses with a class size between
     * a given range.
     *
     * @param courses an Array List of Course containing courses that are to be filtered.
     * @param low the initial number of the range being searched.
     * @param high the final number of the range being searched.
     * @return an Array List of Course that only contains the courses of the range that
     *         was passed in.
     */
    public static ArrayList<Course> classSizeFilter(ArrayList<Course> courses, int low, int high) {
        if (low > high) {
            int temp = low;
            low = high;
            high = temp;
        }

        ArrayList<Course> filtered = new ArrayList<>();
        for (Course currentCourse : courses) {
            if (currentCourse.getClassSize() >= low && currentCourse.getClassSize() <= high) {
                filtered.add(currentCourse);
            }
        }

        return filtered;
    }

    /**
     * Takes in a list of Courses and returns a list of the courses with an average between
     * a given range.
     *
     * @param courses an Array List of Course containing courses that are to be filtered.
     * @param low the initial number of the range being searched.
     * @param high the final number of the range being searched.
     * @return an Array List of Course that only contains the courses of the range that
     *         was passed in.
     */
    public static ArrayList<Course> averageGradeFilter(ArrayList<Course> courses,
                                                       double low, double high) {
        if (low > high) {
            double temp = low;
            low = high;
            high = temp;
        }

        double  highestGradePossible = 4.0;
        if (low > highestGradePossible) {
            throw new IllegalArgumentException(ErrorConstants.OUT_OF_BOUNDS_INPUT);
        }

        ArrayList<Course> filtered = new ArrayList<>();
        for (Course currentCourse : courses) {
            if (currentCourse.getAverage() >= low && currentCourse.getAverage() <= high) {
                filtered.add(currentCourse);
            }
        }

        return filtered;
    }

    /**
     * Takes in a list of Courses and returns a list of the courses with the given title.
     *
     * @param courses an Array List of Course containing courses that are to be filtered.
     * @param title the title of the class being searched for.
     * @return an Array List of Course that only contains the courses of the title that
     *         was passed in.
     */
    public static ArrayList<Course> titleFilter(ArrayList<Course> courses, String title) {
        handleStringErrors(title);

        ArrayList<Course> filtered = new ArrayList<>();
        for (Course currentCourse : courses) {
            if (currentCourse.getTitle().toLowerCase().contains(title.toLowerCase())) {
                filtered.add(currentCourse);
            }
        }

        return filtered;
    }

    private static void handleStringErrors(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        for (char c : inputString.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorConstants.CONTAINS_DIGIT);
            }
        }
    }
}




