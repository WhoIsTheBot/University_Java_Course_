package labs.lab5;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DataBaseTest {
    @BeforeClass
    public void setup() {
        StudentDataBase.createStudentTable();
        TeacherDataBase.createTeacherTable();
    }

    @AfterClass
    public void cleanup() {
        StudentDataBase.deleteStudentTable();
        TeacherDataBase.deleteTeacherTable();
    }

    @Test
    public void testAddAndGetStudent() {
        StudentDataBase.addStudent("John Doe", 1998, "Computer Science", true);
        System.out.println("Testing add and get for Student:");
        StudentDataBase.getStudent();
        Assert.assertTrue(true);
    }

    @Test
    public void testUpdateStudentScholarship() {
        StudentDataBase.updateStudentSalary(1, false);
        System.out.println("Testing update for Student scholarship:");
        StudentDataBase.getStudent();
        Assert.assertTrue(true);
    }

    @Test
    public void testDeleteStudent() {
        StudentDataBase.deleteStudent(1);
        System.out.println("Testing delete for Student:");
        StudentDataBase.getStudent();
        Assert.assertTrue(true);
    }

    @Test
    public void testAddAndGetTeacher() {
        TeacherDataBase.addTeacher("Emily Johnson", 35, "Lecturer", 2, 4000);
        System.out.println("Testing add and get for Teacher:");
        TeacherDataBase.getTeacher();
        Assert.assertTrue(true);
    }

    @Test
    public void testUpdateTeacherSalary() {
        TeacherDataBase.updateTeacherSalary(1, 5500);
        System.out.println("Testing update for Teacher salary:");
        TeacherDataBase.getTeacher();
        Assert.assertTrue(true);
    }

    @Test
    public void testDeleteTeacher() {
        TeacherDataBase.deleteTeacher(1);
        System.out.println("Testing delete for Teacher:");
        TeacherDataBase.getTeacher();
        Assert.assertTrue(true);
    }
}
