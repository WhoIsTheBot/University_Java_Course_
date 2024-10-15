package labs.lab1;

import labs.lab4.builders.PerformanceRecordBuilder;

import java.util.Objects;

/**
 * Клас представляє інформацію про успішність студента.
 */
public class PerformanceRecord {
    private String subject;
    private Teachers teacher;
    private String date;
    private int grade;
    private Student student;

    /**
    *Публічний конструктор для використання Builder
     * */
    public PerformanceRecord(PerformanceRecordBuilder builder) {
        this.subject = builder.subject;
        this.teacher = builder.teacher;
        this.date = builder.date;
        this.grade = builder.grade;
        this.student = builder.student;
    }

    public String getSubject() {
        return subject;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public String getDate() {
        return date;
    }

    public int getGrade() {
        return grade;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "PerformanceRecord{" +
                "subject='" + subject + '\'' +
                ", teacher=" + teacher + // Виправлено на правильний тип
                ", date='" + date + '\'' +
                ", grade=" + grade +
                ", student=" + student +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerformanceRecord that = (PerformanceRecord) o;
        return grade == that.grade &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(teacher, that.teacher) &&
                Objects.equals(date, that.date) &&
                Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, teacher, date, grade, student);
    }
}
