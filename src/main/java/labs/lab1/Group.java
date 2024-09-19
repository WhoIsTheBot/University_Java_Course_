package labs.lab1;

import java.util.List;
import java.util.Objects;

/**
 * Клас представляє інформацію про групу.
 */
public class Group {
    private final String groupNumber;
    private final int yearCreated;
    private final String department;
    private final String curatorFullName;
    private final List<Student> students;

    public Group(String groupNumber, int yearCreated, String department, String curatorFullName, List<Student> students) {
        this.groupNumber = groupNumber;
        this.yearCreated = yearCreated;
        this.department = department;
        this.curatorFullName = curatorFullName;
        this.students = students;
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

    public String getCuratorFullName() {
        return curatorFullName;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return String.format("Group{groupNumber='%s', yearCreated=%d, department='%s', curatorFullName='%s', students=%s}",
                groupNumber, yearCreated, department, curatorFullName, students);
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
