package labs.lab4.builders;

import labs.lab1.Group;
import labs.lab1.PerformanceRecord;
import labs.lab1.Student;
import labs.lab1.Teachers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BuilderTest {

    @Test
    public void testStudentBuilder() {
        StudentBuilder studentBuilder = new StudentBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setBirthDate("2000-01-01")
                .setRecordBookNumber("RB12345");

        Student student = studentBuilder.build();

        Assert.assertEquals(student.getFirstName(), "John");
        Assert.assertEquals(student.getLastName(), "Doe");
        Assert.assertEquals(student.getBirthDate(), "2000-01-01");
        Assert.assertEquals(student.getRecordBookNumber(), "RB12345");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidStudentBuilder() {
        new StudentBuilder().build(); // Should throw an exception due to missing required fields
    }

    @Test
    public void testTeacherBuilder() {
        TeacherBuilder teacherBuilder = new TeacherBuilder()
                .setId("T123")
                .setFullName("Jane Smith")
                .setBirthday("1985-05-15")
                .setPosition("Mathematics Teacher")
                .setPhoneNumber("+1234567890");

        Teachers teacher = teacherBuilder.build();

        Assert.assertEquals(teacher.getId(), "T123");
        Assert.assertEquals(teacher.getFullName(), "Jane Smith");
        Assert.assertEquals(teacher.getBirthday(), "1985-05-15");
        Assert.assertEquals(teacher.getPosition(), "Mathematics Teacher");
        Assert.assertEquals(teacher.getPhoneNumber(), "+1234567890");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTeacherBuilder() {
        new TeacherBuilder().build(); // Should throw an exception due to missing required fields
    }

    @Test
    public void testPerformanceRecordBuilder() {
        Student student = new StudentBuilder()
                .setFirstName("Alice")
                .setLastName("Johnson")
                .setBirthDate("1999-03-12")
                .setRecordBookNumber("RB54321")
                .build();

        Teachers teacher = new TeacherBuilder()
                .setId("T456")
                .setFullName("Mr. Brown")
                .setBirthday("1980-07-20")
                .setPosition("Science Teacher")
                .setPhoneNumber("+0987654321")
                .build();

        PerformanceRecordBuilder recordBuilder = new PerformanceRecordBuilder()
                .setSubject("Biology")
                .setTeacher(teacher)
                .setDate("2024-10-11")
                .setGrade(85)
                .setStudent(student);

        PerformanceRecord record = recordBuilder.build();

        Assert.assertEquals(record.getSubject(), "Biology");
        Assert.assertEquals(record.getTeacher(), teacher);
        Assert.assertEquals(record.getDate(), "2024-10-11");
        Assert.assertEquals(record.getGrade(), 85);
        Assert.assertEquals(record.getStudent(), student);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidPerformanceRecordBuilder() {
        new PerformanceRecordBuilder().build(); // Should throw an exception due to missing required fields
    }

    @Test
    public void testGroupBuilder() {
        Teachers curator = new TeacherBuilder()
                .setId("T789")
                .setFullName("Dr. White")
                .setBirthday("1975-02-28")
                .setPosition("Group Curator")
                .setPhoneNumber("+1234567890")
                .build();

        Student student1 = new StudentBuilder()
                .setFirstName("Tom")
                .setLastName("Hanks")
                .setBirthDate("1998-08-20")
                .setRecordBookNumber("RB10001")
                .build();

        Student student2 = new StudentBuilder()
                .setFirstName("Emma")
                .setLastName("Stone")
                .setBirthDate("1997-04-10")
                .setRecordBookNumber("RB10002")
                .build();

        GroupBuilder groupBuilder = new GroupBuilder()
                .setGroupNumber("G1")
                .setYearCreated(2022)
                .setDepartment("Computer Science")
                .setCuratorId(curator)
                .setStudents(List.of(student1, student2));

        Group group = groupBuilder.build();

        Assert.assertEquals(group.getGroupNumber(), "G1");
        Assert.assertEquals(group.getYearCreated(), 2022);
        Assert.assertEquals(group.getDepartment(), "Computer Science");
        Assert.assertEquals(group.getCuratorId(), curator);
        Assert.assertEquals(group.getStudents().size(), 2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidGroupBuilder() {
        new GroupBuilder().build(); // Should throw an exception due to missing required fields
    }
}
