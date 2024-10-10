package labs.lab2;

import labs.lab1.Group;
import labs.lab1.Student;
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

        students.add(new Student("Rayan", "Gosling", "2001-02-12", "AB567"));
        students.add(new Student("Emma", "Atoyn", "2006-09-12", "AB167"));
        students.add(new Student("Rayan", "Slipers", "2000-11-22", "AB967"));
        students.add(new Student("Anna", "Rinzon", "2001-02-12", "AB507"));

        groups.add(new Group("101", 2022, "Computer Science", null, new ArrayList<>()));
        groups.add(new Group("311", 2020, "Computer Science", null, new ArrayList<>()));
        groups.add(new Group("302", 2020, "Mathematics", null, new ArrayList<>()));
    }

    @Test
    public void testSortStudentsByLastName() {
        List<Student> sortedStudents = collections.sortStudentsByLastName(students);

        assertEquals(sortedStudents.get(0).getLastName(), "Atoyn");
    }

    @Test
    public void testFindStudentByRecordBookNumber() {
        Optional<Student> foundStudent = collections.findStudentByRecordBookNumber(students, "AB567");

        assertTrue(foundStudent.isPresent());
        assertEquals(foundStudent.get().getFirstName(), "Rayan");
    }

    @Test
    public void testFilterStudentsByLastName() {
        List<Student> filteredStudents = collections.filterStudentsByLastName(students, "Gosling");

        assertEquals(filteredStudents.size(), 1);
        assertEquals(filteredStudents.get(0).getFirstName(), "Rayan");
    }

    @Test
    public void testSortGroupsByYearCreated() {
        List<Group> sortedGroups = collections.sortGroupsByYearCreated(groups);

        assertEquals(sortedGroups.get(0).getYearCreated(), 2020);
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

        assertEquals(filteredGroups.size(), 2);
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
