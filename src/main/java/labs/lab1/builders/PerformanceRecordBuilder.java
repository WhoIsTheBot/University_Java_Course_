package labs.lab1.builders;

import labs.lab1.PerformanceRecord;
import labs.lab1.Teachers;
import labs.lab1.Student;

public class PerformanceRecordBuilder {
    public String subject;
    public Teachers teacher;
    public String date;
    public int grade;
    public Student student;

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
        return new PerformanceRecord(this);
    }
}
