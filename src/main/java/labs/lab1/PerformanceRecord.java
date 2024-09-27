package labs.lab1;

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

    private PerformanceRecord(Builder builder) {
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
                ", teacher='" + teacher + '\'' +
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

    /**
     * Builder для створення екземплярів PerformanceRecord.
     */
    public static class Builder {
        private String subject;
        private Teachers teacher;
        private String date;
        private int grade;
        private Student student;

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder setTeacher(Teachers teacher) {
            this.teacher = teacher;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setGrade(int grade) {
            this.grade = grade;
            return this;
        }

        public Builder setStudent(Student student) {
            this.student = student;
            return this;
        }

        public PerformanceRecord build() {
            return new PerformanceRecord(this);
        }
    }
}

