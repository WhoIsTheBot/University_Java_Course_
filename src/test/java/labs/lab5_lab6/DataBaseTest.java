package labs.lab5_lab6;


import labs.lab1.Student;
import labs.lab1.Teachers;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DataBaseTest {

    @BeforeClass
    public void setUp() {
        // Очистка та створення таблиць перед початком тестування
        TeacherDataBase.deleteTeacherTable();
        TeacherDataBase.createTeacherTable();

        StudentDataBase.deleteStudentTable();
        StudentDataBase.createStudentTable();
    }

    @AfterClass
    public void tearDown() {
        // Очищення таблиць після завершення тестування
        TeacherDataBase.deleteTeacherTable();
        StudentDataBase.deleteStudentTable();
    }

    @Test
    public void testAddStudent() {
        StudentDataBase.addStudent("Alice", "Johnson", "2003-05-12", "RB3344");
        List<Student> students = StudentDataBase.fetchStudents();

        assertEquals(students.size(), 1);
        assertEquals(students.getFirst().getFirstName(), "Alice");
        assertEquals(students.getFirst().getLastName(), "Johnson");
    }

    @Test
    public void testUpdateStudentRecordBookNumber() {
        StudentDataBase.addStudent("Bob", "Miller", "2002-10-10", "RB1234");
        List<Student> students = StudentDataBase.fetchStudents();

        StudentDataBase.updateStudentRecordBookNumber(1, "RB5678");
        students = StudentDataBase.fetchStudents();

        assertEquals(students.getFirst().getRecordBookNumber(), "RB5678");
    }

    @Test
    public void testDeleteStudent() {
        StudentDataBase.addStudent("Charlie", "Brown", "2001-08-21", "RB4321");
        List<Student> students = StudentDataBase.fetchStudents();

        StudentDataBase.deleteStudent(1);
        students = StudentDataBase.fetchStudents();
        System.out.println(students);

        assertTrue(students.isEmpty());
    }

    @Test
    public void testAddTeacher() {
        TeacherDataBase.addTeacher("John Doe", "1980-12-15", "Professor", "+380500000000", 6000);
        List<Teachers> teachers = TeacherDataBase.fetchTeachers();

        assertEquals(teachers.size(), 1);
        assertEquals(teachers.getFirst().getFullName(), "John Doe");
        assertEquals(teachers.getFirst().getPosition(), "Professor");
    }

    @Test
    public void testUpdateTeacherSalary() {
        TeacherDataBase.addTeacher("Emily Clark", "1985-03-20", "Lecturer", "+380501234567", 5000);
        List<Teachers> teachers = TeacherDataBase.fetchTeachers();

        TeacherDataBase.updateTeacherBirthday(1, "2000-11-15");
        teachers = TeacherDataBase.fetchTeachers();

        assertEquals(teachers.getFirst().getBirthday(), "2000-11-15");
    }

    @Test
    public void testDeleteTeacher() {
        TeacherDataBase.addTeacher("Michael Scott", "1975-05-05", "Head of Department", "+380503456789", 7500);
        List<Teachers> teachers = TeacherDataBase.fetchTeachers();

        TeacherDataBase.deleteTeacher(1);
        teachers = TeacherDataBase.fetchTeachers();

        assertTrue(teachers.isEmpty());
    }
}
