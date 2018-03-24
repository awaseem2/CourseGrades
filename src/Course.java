import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Objects;

public class Course {

    @SerializedName("CRN") private int crn;
    @SerializedName("Subject") private String subject;
    @SerializedName("Number") private int number;
    @SerializedName("Title") private String title;
    @SerializedName("Section") private String section;
    @SerializedName("Type") private String type;
    @SerializedName("Term") private int term;
    @SerializedName("Instructor") private String instructor;
    @SerializedName("Grades") private int[] grades;
    @SerializedName("Average") private double average;

    public int getCrn() {
        return crn;
    }

    public String getSubject() {
        return subject;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getType() {
        return type;
    }

    public int getTerm() {
        return term;
    }

    public String getInstructor() {
        return instructor;
    }

    public int[] getGrades() {
        return grades;
    }

    public double getAverage() {
        return average;
    }

    /**
     * Sums up the total amount of people per class by counting the amount of grades there are.
     *
     * @return an int of the class size.
     */
    public int getClassSize() {
        int sum = 0;

        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }

        return sum;
    }

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
        int result = Objects.hash(crn, subject, number, title, section,
                type, term, instructor, average);
        result = 31 * result + Arrays.hashCode(grades);
        return result;
    }

}
