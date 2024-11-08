package labs.lab2;

import labs.lab1.Group;
import labs.lab1.Student;
import labs.lab1.Teachers;
import labs.lab4.builders.GroupBuilder;
import labs.lab4.builders.StudentBuilder;
import labs.lab4.builders.TeacherBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CollectionsTest {

    private Collections collections;
    private List<Student> students;
    private List<Group> groups;

    @BeforeMethod

    public void setUp() {
        collections = new Collections();
        students = new ArrayList<>();
        groups = new ArrayList<>();

        Teachers teacher1 = new TeacherBuilder()
                .setId("AB2341")
                .setFullName("Nina Boyko")
                .setBirthday("1985-06-15")
                .setPosition("Mathematics Teacher")
                .setPhoneNumber("380123456789")
                .build();

        students.add(new StudentBuilder()
                .setFirstName("Rayan")
                .setLastName("Gosling")
                .setBirthDate("2001-02-12")
                .setRecordBookNumber("RB1237")
                .build());

        students.add(new StudentBuilder()
                .setFirstName("Emma")
                .setLastName("Atoyn")
                .setBirthDate("2006-09-12")
                .setRecordBookNumber("RB1236")
                .build());

        students.add(new StudentBuilder()
                .setFirstName("Rayan")
                .setLastName("Slipers")
                .setBirthDate("2000-11-22")
                .setRecordBookNumber("RB1235")
                .build());

        students.add(new StudentBuilder()
                .setFirstName("Anna")
                .setLastName("Rinzon")
                .setBirthDate("2001-02-12")
                .setRecordBookNumber("RB1234")
                .build());

        groups.add(new GroupBuilder()
                .setGroupNumber("101")
                .setYearCreated(2022)
                .setDepartment("Computer Science")
                .setCuratorId(teacher1)
                .setStudents(students)
                .build());

        groups.add(new GroupBuilder()
                .setGroupNumber("301")
                .setYearCreated(2020)
                .setDepartment("Computer Science")
                .setCuratorId(teacher1)
                .setStudents(students)
                .build());

        groups.add(new GroupBuilder()
                .setGroupNumber("201")
                .setYearCreated(2022)
                .setDepartment("Computer Science")
                .setCuratorId(teacher1)
                .setStudents(students)
                .build());

    }


    @Test
    public void testSortStudentsByLastName() {
        List<Student> sortedStudents = collections.sortStudentsByLastName(students);

        assertEquals(sortedStudents.getFirst().getLastName(), "Atoyn");
    }

    @Test
    public void testFindStudentByRecordBookNumber() {
        Optional<Student> foundStudent = collections.findStudentByRecordBookNumber(students, "RB1234");

        assertTrue(foundStudent.isPresent());
        assertEquals(foundStudent.get().getFirstName(), "Anna");
    }

    @Test
    public void testFilterStudentsByLastName() {
        List<Student> filteredStudents = collections.filterStudentsByLastName(students, "Gosling");

        assertEquals(filteredStudents.size(), 1);
        assertEquals(filteredStudents.getFirst().getFirstName(), "Rayan");
    }

    @Test
    public void testSortGroupsByYearCreated() {
        List<Group> sortedGroups = collections.sortGroupsByYearCreated(groups);

        assertEquals(sortedGroups.getFirst().getYearCreated(), 2020);
    }

    @Test
    public void testFindGroupByGroupNumber() {
        Optional<Group> foundGroup = collections.findGroupByGroupNumber(groups, "101");

        assertTrue(foundGroup.isPresent());
        assertEquals(foundGroup.get().getDepartment(), "Computer Science");
    }

    @Test
    public void testFilterGroupsByDepartment() {
        List<Group> filteredGroups = collections.filterGroupsByDepartment(groups, "Computer Science");

        assertEquals(filteredGroups.size(), 3);
    }

    @Test
    public void testAddAndRemoveItems() {
        collections.addItem("Coffee");

        assertTrue(collections.containsItem("Coffee"));

        collections.removeItem("Coffee");

        assertFalse(collections.containsItem("Coffee"));
    }

    @Test
    public void testCountItems() {
        collections.addItem("Tea");
        collections.addItem("Cake");

        assertEquals(collections.countIteams(), 2);

        collections.clearItems();

        assertEquals(collections.countIteams(), 0);
    }

    @Test
    public void testSortItems() {
        collections.addItem("Cake");
        collections.addItem("Tea");

        collections.sortItems();

        List<String> expectedOrder = List.of("Cake", "Tea");

        assertEquals(collections.getAllItems(), expectedOrder);
    }
}
