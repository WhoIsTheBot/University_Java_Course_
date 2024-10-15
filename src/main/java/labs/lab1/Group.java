package labs.lab1;

import labs.lab4.builders.GroupBuilder;

import java.util.List;
import java.util.Objects;

/**
 * Клас представляє інформацію про групу.
 */
public class Group {
    private String groupNumber;
    private int yearCreated;
    private String department;
    private Teachers curatorId;
    private List<Student> students;

    // Приватний конструктор, який приймає об'єкт GroupBuilder
    // Приватний конструктор, який приймає об'єкт GroupBuilder
    public Group(GroupBuilder builder) {
        this.groupNumber = builder.groupNumber;
        this.yearCreated = builder.yearCreated;
        this.department = builder.department;
        this.curatorId = builder.curatorId;
        this.students = builder.students;
    }



    public String getGroupNumber() {
        return groupNumber;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public String getDepartment() {
        return department;
    }

    public Teachers getCuratorId() {
        return curatorId;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return String.format("Group{groupNumber='%s', yearCreated=%d, department='%s', curatorFullName='%s', students=%s}",
                groupNumber, yearCreated, department, curatorId.getFullName(), students);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return yearCreated == group.yearCreated &&
                Objects.equals(groupNumber, group.groupNumber) &&
                Objects.equals(department, group.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupNumber, yearCreated, department);
    }
}
