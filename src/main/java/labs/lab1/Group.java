package labs.lab1;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Клас представляє інформацію про групу.
 */
public class Group implements Comparator<Group> {
    private String groupNumber;
    private int yearCreated;
    private String department;
    private Teachers curatorId;
    private List<Student> students;

    public Group(String groupNumber, int yearCreated, String department, Teachers curatorId, List<Student> students) {
        this.groupNumber = groupNumber;
        this.yearCreated = yearCreated;
        this.department = department;
        this.curatorId = curatorId;
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

    public Teachers getCuratorId() {
        return curatorId;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return String.format("Group{groupNumber='%s', yearCreated=%d, department='%s', curatorFullName='%s', students=%s}",
                groupNumber, yearCreated, department, curatorId, students);
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

    @Override
    public int compare(Group g1, Group g2) {
        int yearComparison = Integer.compare(g1.yearCreated, g2.yearCreated);
        if (yearComparison != 0) {
            return yearComparison;
        }
        return g1.groupNumber.compareTo(g2.groupNumber);
    }
}
