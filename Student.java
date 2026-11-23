import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Student {
    private final String id;
    private String name;
    private double gpa;
    private final Set<String> courses;

    public Student(String id, String name, double gpa) {
        this.id = id;
        setName(name);
        setGpa(gpa);
        this.courses = new HashSet<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public Set<String> getCourses() { return Collections.unmodifiableSet(courses); }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        this.name = name.trim();
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 10.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 10.0.");
        }
        this.gpa = gpa;
    }

    public void enrollCourse(String courseCode) {
        if (courseCode != null && !courseCode.isBlank()) {
            courses.add(courseCode.trim().toUpperCase());
        }
    }

    public void updateDetails(String name) {
        setName(name);
    }

    public void updateDetails(String name, double gpa) {
        setName(name);
        setGpa(gpa);
    }

    public String toCsv() {
        String joinedCourses = String.join("|", courses);
        return String.format("%s,%s,%.2f,%s", id, name.replace(",", " "), gpa, joinedCourses);
    }

    public static Student fromCsv(String csvLine) {
        String[] parts = csvLine.split(",", -1);
        if (parts.length < 3) {
            throw new IllegalArgumentException("Malformed CSV record: " + csvLine);
        }
        Student s = new Student(parts[0].trim(), parts[1].trim(), Double.parseDouble(parts[2].trim()));
        if (parts.length >= 4 && !parts[3].isBlank()) {
            for (String course : parts[3].split("\\|")) {
                s.enrollCourse(course);
            }
        }
        return s;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | GPA: %.2f | Courses: %s", id, name, gpa, courses);
    }
}