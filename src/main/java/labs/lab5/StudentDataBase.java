package labs.lab5;

import java.sql.*;

public class StudentDataBase {

    public static void createStudentTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Student ("
                + "id SERIAL PRIMARY KEY, "
                + "fullName VARCHAR(100) NOT NULL, "
                + "dateOfBirth INT NOT NULL, "
                + "specialty VARCHAR(100), "
                + "hasScholarship BOOLEAN"
                + ");";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            System.out.println("Table 'Student' is created!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudentTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS Student";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(dropTableSQL);
            System.out.println("Table 'Student' has been deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void addStudent(String fullName, int dateOfBirth, String specialty, boolean hasScholarship) {
        String insertSQL = "INSERT INTO Student (fullName, dateOfBirth, specialty, hasScholarship) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, fullName);
            preparedStatement.setInt(2, dateOfBirth);
            preparedStatement.setString(3, specialty);
            preparedStatement.setBoolean(4, hasScholarship);
            preparedStatement.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getStudent() {
        String selectSQL = "SELECT * FROM Student";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("fullName");
                int age = resultSet.getInt("dateOfBirth");
                String position = resultSet.getString("specialty");
                boolean salary = resultSet.getBoolean("hasScholarship");

                System.out.println("ID: " + id + ", Full Name: " + name + ", Date Of Birth: " + age
                        + ", Specialty: " + position + ", has a scholarship: " + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudentSalary(int id, boolean hasScholarship) {
        String updateSQL = "UPDATE Student SET hasScholarship = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            preparedStatement.setBoolean(1, hasScholarship);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

            System.out.println("Student salary updated!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(int id) {
        String deleteSQL = "DELETE FROM Student WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Student deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        deleteStudentTable();
        createStudentTable();

        addStudent("John Doe", 1998, "Computer Science", true);
        addStudent("Mari Anna", 1997, "Mathematics", false);

        System.out.println("Current students in database:");
        getStudent();

        updateStudentSalary(1, false);

        System.out.println("Updated students in database:");

        getStudent();
        deleteStudent(2);

        System.out.println("Final students in database:");
        getStudent();
    }


}
