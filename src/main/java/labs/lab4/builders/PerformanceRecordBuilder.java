package labs.lab4.builders;

import labs.lab1.PerformanceRecord;
import labs.lab1.Teachers;
import labs.lab1.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PerformanceRecordBuilder {
    public String subject;
    public Teachers teacher;
    public String date;
    public int grade;
    public Student student;

    private static final Pattern SUBJECT_PATTERN = Pattern.compile("^[A-Za-z\\s]+$"); // Літери і пробіли
    private static final int MIN_GRADE = 0;
    private static final int MAX_GRADE = 100;
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$"); // YYYY-MM-DD

    public PerformanceRecordBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public PerformanceRecordBuilder setTeacher(Teachers teacher) {
        this.teacher = teacher;
        return this;
    }

    public PerformanceRecordBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public PerformanceRecordBuilder setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public PerformanceRecordBuilder setStudent(Student student) {
        this.student = student;
        return this;
    }

    public PerformanceRecord build() {
        List<String> validationErrors = new ArrayList<>();

        if (subject == null || !SUBJECT_PATTERN.matcher(subject).matches()) {
            validationErrors.add("Subject is invalid: " + subject + ". It must contain only letters and spaces.");
        }

        if (teacher == null) {
            validationErrors.add("Teacher cannot be null.");
        }

        if (date == null || !DATE_PATTERN.matcher(date).matches()) {
            validationErrors.add("Date is invalid: " + date + ". It must be in the format YYYY-MM-DD.");
        }

        if (grade < MIN_GRADE || grade > MAX_GRADE) {
            validationErrors.add("Grade is invalid: " + grade + ". It must be between " + MIN_GRADE + " and " + MAX_GRADE + ".");
        }

        if (student == null) {
            validationErrors.add("Student cannot be null.");
        }

        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationErrors));
        }

        return new PerformanceRecord(this);
    }
}
