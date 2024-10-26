package labs.lab5_lab6;

import labs.lab1.Student;
import labs.lab4.builders.StudentBuilder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDataBase {
    private static final Logger logger = Logger.getLogger(StudentDataBase.class.getName());

    public static void createStudentTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Student ("
                + "id SERIAL PRIMARY KEY, "
                + "firstName VARCHAR(100) NOT NULL, "
                + "lastName VARCHAR(100) NOT NULL, "
                + "birthDate VARCHAR(100) NOT NULL, "
                + "recordBookNumber VARCHAR(100) NOT NULL "
                + ");";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            logger.info("Table 'Student' is created!");

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creating 'Student' table", e);
        }
    }

    public static void deleteStudentTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS Student";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(dropTableSQL);
            logger.info("Table 'Student' has been deleted!");

        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error deleting 'Student' table", e);
        }
    }

    public static void addStudent(String firstName, String lastName, String birthDate, String recordBookNumber) {
        String insertSQL = "INSERT INTO Student (firstName, lastName, birthDate, recordBookNumber) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, birthDate);
            preparedStatement.setString(4, recordBookNumber);
            preparedStatement.executeUpdate();

            logger.info("Student added successfully: " + firstName + " " + lastName);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error adding student", e);
        }
    }

    public static void getStudent() {
        String selectSQL = "SELECT * FROM Student";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            logger.info("Fetching students from database...");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String birthDate = resultSet.getString("birthDate");
                String recordBookNumber = resultSet.getString("recordBookNumber");

                logger.info("Student ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName
                        + ", Date of Birth: " + birthDate + ", Record Book Number: " + recordBookNumber);
            }

        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error fetching students", e);
        }
    }

    public static void updateStudentRecordBookNumber(int id, String recordBookNumber) {
        String updateSQL = "UPDATE Student SET recordBookNumber = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            preparedStatement.setString(1, recordBookNumber);
            preparedStatement.setInt(2, id);
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                logger.info("Student record book number updated for ID: " + id);
            } else {
                logger.warning("No student found with ID: " + id);
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating student record book number", e);
        }
    }

    public static void deleteStudent(int id) {
        String deleteSQL = "DELETE FROM Student WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                logger.info("Student deleted with ID: " + id);
            } else {
                logger.warning("No student found with ID: " + id);
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting student", e);
        }
    }

    // Fetch students from the database
    public static List<Student> fetchStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT firstName, lastName, birthDate, recordBookNumber FROM Student";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            logger.info("Fetching student list from database...");
            while (resultSet.next()) {
                Student student = new StudentBuilder()
                        .setFirstName(resultSet.getString("firstName"))
                        .setLastName(resultSet.getString("lastName"))
                        .setBirthDate(resultSet.getString("birthDate"))
                        .setRecordBookNumber(resultSet.getString("recordBookNumber"))
                        .build();
                students.add(student);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error fetching student list", e);
        }
        return students;
    }

    public static void main(String[] args) {
        logger.info("Starting Student Database operations...");

        deleteStudentTable();
        createStudentTable();

        addStudent("John", "Doe", "2000-01-01", "RB1234");
        addStudent("Mari", "Ray", "2002-11-21", "RB2234");
        addStudent("Ken", "Mireya", "2001-09-21", "RB2114");

        logger.info("Current students in database:");
        getStudent();

        updateStudentRecordBookNumber(1, "RB2235");

        logger.info("Updated students in database:");
        getStudent();

        deleteStudent(2);

        logger.info("Final students in database:");
        getStudent();

        logger.info("Adding students to class:");
        List<Student> students = fetchStudents();

        for (Student student : students) {
            logger.info(student.toString());
        }
    }
}
