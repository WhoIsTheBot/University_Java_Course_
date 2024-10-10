package labs.lab1;

import labs.lab1.builders.PerformanceRecordBuilder;
import labs.lab1.builders.TeacherBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Test class to verify the Student, Group, PerformanceRecord, and Teachers classes using TestNG.
 */
public class TestClass {

    private Student student1;
    private Student student2;
    private Group group;
    private Teachers teacher1;
    private PerformanceRecord performanceRecord;

    /**
     * Set up test data before each test method.
     */
    @BeforeMethod
    public void setUp() {
        // Create students
        student1 = new Student("Ivan", "Petrenko", "2000-01-15", "12345");
        student2 = new Student("Maria", "Ivanova", "2001-05-20", "54321");

        teacher1 = new TeacherBuilder()
                .setId("AB2341")
                .setFullName("Nina Boyko")
                .setBirthday("1985-06-15")
                .setPosition("Mathematics Teacher")
                .setPhoneNumber("380123456789")
                .build();

        // Create a group with two students
        List<Student> students = Arrays.asList(student1, student2);
        group = new Group("KP-01", 2019, "Computer Science", teacher1, students);

        // Create a performance record using the Builder pattern
        performanceRecord = new PerformanceRecordBuilder()
                .setSubject("Mathematics")
                .setTeacher(teacher1)
                .setDate("2023-09-01")
                .setGrade(90)
                .setStudent(student1)
                .build();
    }

    /**
     * Test the toString method of the Student class.
     */
    @Test
    public void testStudentToString() {
        String expected = "Student{firstName='Ivan', lastName='Petrenko', birthDate='2000-01-15', recordBookNumber='12345'}";
        assertEquals(student1.toString(), expected);
    }

    /**
     * Test the equals and hashCode methods of the Student class.
     */
    @Test
    public void testStudentEqualsAndHashCode() {
        Student duplicateStudent = new Student("Ivan", "Petrenko", "2000-01-15", "12345");
        assertEquals(student1, duplicateStudent);
        assertEquals(student1.hashCode(), duplicateStudent.hashCode());
    }

    /**
     * Test the correctness of the PerformanceRecord object creation using the Builder pattern.
     */
    @Test
    public void testPerformanceRecordBuilder() {
        assertEquals(performanceRecord.getSubject(), "Mathematics");
        assertEquals(performanceRecord.getTeacher(), teacher1);
        assertEquals(performanceRecord.getDate(), "2023-09-01");
        assertEquals(performanceRecord.getGrade(), 90);
        assertEquals(performanceRecord.getStudent(), student1);
    }

    /**
     * Test the equals and hashCode methods of the PerformanceRecord class.
     */
    @Test
    public void testPerformanceRecordEqualsAndHashCode() {
        PerformanceRecord duplicateRecord = new PerformanceRecordBuilder()
                .setSubject("Mathematics")
                .setTeacher(teacher1)
                .setDate("2023-09-01")
                .setGrade(90)
                .setStudent(student1)
                .build();

        assertEquals(performanceRecord, duplicateRecord);
        assertEquals(performanceRecord.hashCode(), duplicateRecord.hashCode());
    }

    /**
     * Test the toString method of the Group class.
     */
    @Test
    public void testGroupToString() {
        String expected = String.format(
                "Group{groupNumber='%s', yearCreated=%d, department='%s', curatorFullName='%s', students=%s}",
                group.getGroupNumber(), group.getYearCreated(), group.getDepartment(),
                teacher1.getFullName(), Arrays.asList(student1, student2)
        );
        assertEquals(group.toString(), expected);
    }

    /**
     * Test the equals and hashCode methods of the Group class.
     */
    @Test
    public void testGroupEqualsAndHashCode() {
        Group duplicateGroup = new Group("KP-01", 2019, "Computer Science", teacher1, Arrays.asList(student1, student2));

        assertEquals(group, duplicateGroup);
        assertEquals(group.hashCode(), duplicateGroup.hashCode());
    }

    /**
     * Test the toString method of the Teachers class.
     */
    @Test
    public void testTeachersToString() {
        String expected = "Teachers{id='AB2341', fullName='Nina Boyko', birthday='1985-06-15', position='Mathematics Teacher', phoneNumber='380123456789'}";
        assertEquals(teacher1.toString(), expected);
    }

    /**
     * Test the equals and hashCode methods of the Teachers class.
     */
    @Test
    public void testTeachersEqualsAndHashCode() {
        Teachers duplicateTeacher = new TeacherBuilder()
                .setId("AB2341")
                .setFullName("Nina Boyko")
                .setBirthday("1985-06-15")
                .setPosition("Mathematics Teacher")
                .setPhoneNumber("380123456789")
                .build();

        assertEquals(teacher1, duplicateTeacher);
        assertEquals(teacher1.hashCode(), duplicateTeacher.hashCode());
    }
}
