package labs.lab4.builders;

import labs.lab1.Group;
import labs.lab1.Student;
import labs.lab1.Teachers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GroupBuilder {


    public String groupNumber;
    public int yearCreated;
    public String department;
    public Teachers curatorId;
    public List<Student> students;

    public GroupBuilder setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
        return this;
    }

    public GroupBuilder setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
        return this;
    }

    public GroupBuilder setDepartment(String department) {
        this.department = department;
        return this;
    }

    public GroupBuilder setCuratorId(Teachers curatorId) {
        this.curatorId = curatorId;
        return this;
    }

    public GroupBuilder setStudents(List<Student> students) {
        this.students = Objects.requireNonNullElseGet(students, ArrayList::new);
        return this;
    }


    public Group build() {
        List<String> validationErrors = new ArrayList<>();

        if (groupNumber == null || groupNumber.isEmpty()) {
            validationErrors.add("Group number cannot be null or empty.");
        }

        if (yearCreated < 1900 || yearCreated > 2100) {  // Задайте діапазон років
            validationErrors.add("Year created must be between 1900 and 2100.");
        }

        if (department == null || department.isEmpty()) {
            validationErrors.add("Department cannot be null or empty.");
        }

        if (curatorId == null) {
            validationErrors.add("Curator ID cannot be null.");
        }

        if (students == null) {
            validationErrors.add("Students list cannot be null.");
        }

        if (students == null || students.isEmpty()) {
            validationErrors.add("Students list cannot be null or empty.");
        }

        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationErrors));
        }

        return new Group(this);
    }
}
