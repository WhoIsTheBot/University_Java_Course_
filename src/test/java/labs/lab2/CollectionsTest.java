package labs.lab2;

import labs.lab1.Student;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionsTest {

    private List<Student> students;
    private Collections collectionsService;

    @BeforeMethod
    public void setUp() {
        students = new ArrayList<>();
        students.add(new Student("John", "Doe", "1999-04-12", "12345"));
        students.add(new Student("Alice", "Smith", "2000-01-05", "54321"));
        students.add(new Student("Bob", "Doe", "1998-09-22", "67890"));
        collectionsService = new Collections();
    }

    @Test
    //перевіряє правильність сортування за прізвищем.
    public void testSortStudentsByLastName() {
        List<Student> sortedByLastName = collectionsService.sortStudentsByLastName(students);
        Assert.assertEquals(sortedByLastName.get(0).getLastName(), "Doe");
        Assert.assertEquals(sortedByLastName.get(1).getLastName(), "Doe");
        Assert.assertEquals(sortedByLastName.get(2).getLastName(), "Smith");
    }

    @Test
    //перевіряє сортування за датою народження.
    public void testSortStudentsByBirthDate() {
        List<Student> sortedByBirthDate = collectionsService.sortStudentsByBirthDate(students);
        Assert.assertEquals(sortedByBirthDate.get(0).getBirthDate(), "1998-09-22");
        Assert.assertEquals(sortedByBirthDate.get(1).getBirthDate(), "1999-04-12");
        Assert.assertEquals(sortedByBirthDate.get(2).getBirthDate(), "2000-01-05");
    }

    @Test
    //перевіряє пошук студента за номером залікової книжки.
    public void testFindStudentByRecordBookNumber() {
        Optional<Student> student = collectionsService.findStudentByRecordBookNumber(students, "54321");
        Assert.assertTrue(student.isPresent());
        Assert.assertEquals(student.get().getRecordBookNumber(), "54321");
    }

    @Test
    //перевіряє фільтрацію студентів за прізвищем.
    public void testFilterStudentsByLastName() {
        List<Student> filteredByLastName = collectionsService.filterStudentsByLastName(students, "Doe");
        Assert.assertEquals(filteredByLastName.size(), 2);
        Assert.assertTrue(filteredByLastName.stream().allMatch(student -> student.getLastName().equals("Doe")));
    }
}

