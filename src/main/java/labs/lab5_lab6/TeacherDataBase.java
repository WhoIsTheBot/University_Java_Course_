package labs.lab5_lab6;


import labs.lab1.Teachers;
import labs.lab4.builders.TeacherBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherDataBase {
    private static final Logger logger = Logger.getLogger(TeacherDataBase.class.getName());

    public static void createTeacherTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Teacher ("
                + "id SERIAL PRIMARY KEY, "
                + "fullName VARCHAR(100) NOT NULL, "
                + "birthday VARCHAR(100) NOT NULL, "
                + "position VARCHAR(100) NOT NULL, "
                + "phoneNumber VARCHAR(100) NOT NULL, "
                + "salary INT"
                + ");";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            logger.info("Table 'Teacher' is created!");

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creating 'Teacher' table", e);
        }
    }

    public static void deleteTeacherTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS Teacher";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(dropTableSQL);
            logger.info("Table 'Teacher' has been deleted!");

        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error deleting 'Teacher' table", e);
        }
    }

    public static void addTeacher(String fullName, String birthday, String position, String phoneNumber, int salary) {
        String insertSQL = "INSERT INTO Teacher (fullName, birthday, position, phoneNumber, salary) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, birthday);
            preparedStatement.setString(3, position);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setInt(5, salary);
            preparedStatement.executeUpdate();

            logger.info("Teacher added successfully: " + fullName);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error adding teacher", e);
        }
    }

    public static void getTeacher() {

        String selectSQL = "SELECT * FROM Teacher";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            logger.info("Fetching teachers from database...");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName");
                String birthday = resultSet.getString("birthday");
                String position = resultSet.getString("position");
                String phoneNumber = resultSet.getString("phoneNumber");
                int salary = resultSet.getInt("salary");

                logger.info("ID: " + id + ", Full Name: " + fullName + ", Birthday: " + birthday +
                        ", Position: " + position + ", Phone: " + phoneNumber + ", Salary: " + salary);
            }

        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error fetching teachers", e);
        }
    }

    public static void updateTeacherBirthday(int id, String birthday) {
        String updateSQL = "UPDATE Teacher SET birthday = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            preparedStatement.setString(1, birthday);
            preparedStatement.setInt(2, id);
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                logger.info("Teacher salary updated for ID: " + id);
            } else {
                logger.warning("No teacher found with ID: " + id);
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating teacher salary", e);
        }
    }

    public static void deleteTeacher(int id) {
        String deleteSQL = "DELETE FROM Teacher WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                logger.info("Teacher deleted with ID: " + id);
            } else {
                logger.warning("No teacher found with ID: " + id);
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting teacher", e);
        }
    }

    public static List<Teachers> fetchTeachers() {
        List<Teachers> teachers = new ArrayList<>();
        String sql = "SELECT id, fullName, birthday, position, phoneNumber, salary FROM Teacher";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            logger.info("Fetching teacher list from database...");
            while (resultSet.next()) {
                Teachers teacher = new TeacherBuilder()
                        .setId(resultSet.getString("id"))
                        .setFullName(resultSet.getString("fullName"))
                        .setBirthday(resultSet.getString("birthday"))
                        .setPosition(resultSet.getString("position"))
                        .setPhoneNumber(resultSet.getString("phoneNumber"))
                        .build();
                teachers.add(teacher);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error fetching teacher list", e);
        }
        return teachers;
    }

    public static void main(String[] args) {
        logger.info("Starting Teacher Database operations...");

        deleteTeacherTable();
        createTeacherTable();

        addTeacher("John Smith", "1985-05-15", "Professor", "+3804567890", 5000);
        addTeacher("Emily Johnson", "1990-01-15", "Lecturer", "+3804567890", 4000);
        addTeacher("Michael Brown", "2000-11-15", "Head of Department", "+3804567890", 7000);

        logger.info("Current teachers in database:");
        getTeacher();

        updateTeacherBirthday(1, "2100-11-15");
        logger.info("List of teachers after salary update:");
        getTeacher();

        deleteTeacher(2);
        logger.info("List of teachers after deletion:");
        getTeacher();

        logger.info("Adding teachers to class:");
        List<Teachers> teachers = fetchTeachers();

        for (Teachers teacher : teachers) {
            logger.info(teacher.toString());
        }
    }
}

