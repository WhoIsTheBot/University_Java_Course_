package labs.lab2;

import labs.lab1.Group;
import labs.lab1.Student;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionsTest {

    private final Collections collectionsUtil = new Collections();

    @Test
    public void testSortStudentsByLastName() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", "2001-01-01", "AB123"));
        students.add(new Student("Jane", "Smith", "2002-02-02", "AB124"));

        List<Student> sortedStudents = collectionsUtil.sortStudentsByLastName(students);

        Assert.assertEquals(sortedStudents.get(0).getLastName(), "Doe");
        Assert.assertEquals(sortedStudents.get(1).getLastName(), "Smith");
    }

    @Test
    public void testSortStudentsByBirthDate() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", "2001-01-01", "AB123"));
        students.add(new Student("Jane", "Smith", "2000-02-02", "AB124"));

        List<Student> sortedStudents = collectionsUtil.sortStudentsByBirthDate(students);

        Assert.assertEquals(sortedStudents.get(0).getBirthDate(), "2000-02-02");
        Assert.assertEquals(sortedStudents.get(1).getBirthDate(), "2001-01-01");
    }

    @Test
    public void testFindStudentByRecordBookNumber() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", "2001-01-01", "AB123"));
        students.add(new Student("Jane", "Smith", "2002-02-02", "AB124"));

        Optional<Student> foundStudent = collectionsUtil.findStudentByRecordBookNumber(students, "AB123");

        Assert.assertTrue(foundStudent.isPresent());
        Assert.assertEquals(foundStudent.get().getFirstName(), "John");
    }

    @Test
    public void testFilterStudentsByLastName() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", "2001-01-01", "AB123"));
        students.add(new Student("Jane", "Smith", "2002-02-02", "AB124"));
        students.add(new Student("Jack", "Doe", "2003-03-03", "AB125"));

        List<Student> filteredStudents = collectionsUtil.filterStudentsByLastName(students, "Doe");

        Assert.assertEquals(filteredStudents.size(), 2);
        Assert.assertEquals(filteredStudents.get(0).getFirstName(), "John");
        Assert.assertEquals(filteredStudents.get(1).getFirstName(), "Jack");
    }

    @Test
    public void testSortGroupsByYearCreated() {
        List<Group> groups = new ArrayList<>();
        groups.add(new Group("A1", 2022, "Computer Science", null, new ArrayList<>()));
        groups.add(new Group("B1", 2020, "Mathematics", null, new ArrayList<>()));

        List<Group> sortedGroups = collectionsUtil.sortGroupsByYearCreated(groups);

        Assert.assertEquals(sortedGroups.get(0).getYearCreated(), 2020);
        Assert.assertEquals(sortedGroups.get(1).getYearCreated(), 2022);
    }

    @Test
    public void testFindGroupByGroupNumber() {
        List<Group> groups = new ArrayList<>();
        groups.add(new Group("A1", 2022, "Computer Science", null, new ArrayList<>()));
        groups.add(new Group("B1", 2020, "Mathematics", null, new ArrayList<>()));

        Optional<Group> foundGroup = collectionsUtil.findGroupByGroupNumber(groups, "A1");

        Assert.assertTrue(foundGroup.isPresent());
        Assert.assertEquals(foundGroup.get().getDepartment(), "Computer Science");
    }

    @Test
    public void testFilterGroupsByDepartment() {
        List<Group> groups = new ArrayList<>();
        groups.add(new Group("A1", 2022, "Computer Science", null, new ArrayList<>()));
        groups.add(new Group("B1", 2020, "Mathematics", null, new ArrayList<>()));
        groups.add(new Group("C1", 2021, "Computer Science", null, new ArrayList<>()));

        List<Group> filteredGroups = collectionsUtil.filterGroupsByDepartment(groups, "Computer Science");

        Assert.assertEquals(filteredGroups.size(), 2);
        Assert.assertEquals(filteredGroups.get(0).getGroupNumber(), "A1");
        Assert.assertEquals(filteredGroups.get(1).getGroupNumber(), "C1");
    }
}

