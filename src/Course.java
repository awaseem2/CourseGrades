import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Objects;

public class Course {

    /**
     * Global variables.
     */
    @SerializedName("CRN") private int crn;
    @SerializedName("Subject") private String subject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return crn == course.crn &&
                number == course.number &&
                term == course.term &&
                Double.compare(course.average, average) == 0 &&
                Objects.equals(subject, course.subject) &&
                Objects.equals(title, course.title) &&
                Objects.equals(section, course.section) &&
                Objects.equals(type, course.type) &&
                Objects.equals(instructor, course.instructor) &&
                Arrays.equals(grades, course.grades);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(crn, subject, number, title, section, type, term, instructor, average);
        result = 31 * result + Arrays.hashCode(grades);
        return result;
    }

    @SerializedName("Number") private int number;
    @SerializedName("Title") private String title;
    @SerializedName("Section") private String section;
    @SerializedName("Type") private String type;
    @SerializedName("Term") private int term;
    @SerializedName("Instructor") private String instructor;
    @SerializedName("Grades") private int[] grades;
    @SerializedName("Average") private double average;


    /**
     *
     * @return the course crn.
     */
    public int getCrn() {
        return crn;
    }

    /**
     *
     * @return the course subject.
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @return the course number.
     */
    public int getNumber() {
        return number;
    }

    /**
     *
     * @return the course title.
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return the course section.
     */
    public String getSection() {
        return section;
    }

    /**
     *
     * @return the course type.
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return the course term.
     */
    public int getTerm() {
        return term;
    }

    /**
     *
     * @return the course instructor.
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     *
     * @return the course grades array.
     */
    public int[] getGrades() {
        return grades;
    }

    /**
     *
     * @return the avarage gpa of the course.
     */
    public double getAverage() {
        return average;
    }

    /**
     *
     * @return the course class size.
     */
    public int getClassSize() {
        int sum = 0;
        for(int i = 0; i < grades.length; i++){
            sum += grades[i];
        }
        return sum;
    }

}
