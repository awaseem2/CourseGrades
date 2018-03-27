import java.util.ArrayList;
import java.util.Arrays;

public class AggregateData {

    /**
     * Adds up the amount of students in a given list of courses.
     *
     * @param courses an Array List of Course that is being aggregated.
     * @return an int of the total number of students in the courses.
     */
    public static int totalStudents(ArrayList<Course> courses) {
        int sum = 0;
        for (Course currentCourse : courses) {
            sum += currentCourse.getClassSize();
        }

        return sum;
    }

    /**
     * Adds up the number of students who have a grade within the given range.
     *
     * @param courses an Array List of Course that is being aggregated.
     * @param firstGrade the initial grade of the desired range.
     * @param secondGrade the final grade of the desired range.
     * @return an int of the total students that have a grade within that range in that Array List.
     */
    public static int totalStudentsByGrade(ArrayList<Course> courses,
                                           String firstGrade, String secondGrade) {
        int sum = 0;
        int firstIndex = gradeStringToIndex(firstGrade);
        int secondIndex = gradeStringToIndex(secondGrade);
        if (firstIndex > secondIndex) {
            int temp = firstIndex;
            firstIndex = secondIndex;
            secondIndex = temp;
        }

        for (Course currentCourse : courses) {
            for (int i = firstIndex; i <= secondIndex; i++) {
                sum += currentCourse.getGrades()[i];
            }
        }

        return sum;
    }

    /**
     * Helper method that returns the index of a grade given the grade.
     *
     * @param grade the desired grade needed to be found in the array of grades.
     * @return the index in the grades array.
     */
    public static int gradeStringToIndex(String grade) {
        String[] gradesArray = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-",
                "D+", "D", "D-", "F", "W"};
        int index = Arrays.asList(gradesArray).indexOf(grade.toUpperCase());
        if (index == -1) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_GRADE);
        }

        return index;
    }

    /**
     * Returns the average gpa given a list of courses.
     *
     * @param courses Array List of Course to determine the weighted average gpa of the courses.
     * @return a double of the average weighted gpa of the courses.
     */
    public static double gpaAveragesByEnrollment(ArrayList<Course> courses) {
        double sum = 0;
        for (Course currentCourse : courses) {
            sum += currentCourse.getAverage() * currentCourse.getClassSize();
        }

        double totalStudents = totalStudents(courses);
        return sum / totalStudents;
    }
}


