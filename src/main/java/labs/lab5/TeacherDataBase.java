package labs.lab5;

import java.sql.*;

public class TeacherDataBase {
    public static void createTeacherTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Teacher ("
                + "id SERIAL PRIMARY KEY, "
                + "fullName VARCHAR(100) NOT NULL, "
                + "age INT NOT NULL, "
                + "position VARCHAR(100), "
                + "id_department INT, "
                + "salary INT"
                + ");";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            System.out.println("Table 'Teacher' is created!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTeacherTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS Teacher";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(dropTableSQL);
            System.out.println("Table 'Teacher' has been deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void addTeacher(String fullName, int age, String position, int id_department, int salary) {
        String insertSQL = "INSERT INTO Teacher (fullName, age, position, id_department , salary ) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, fullName);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, position);
            preparedStatement.setInt(4, id_department);
            preparedStatement.setInt(5, salary);
            preparedStatement.executeUpdate();

            System.out.println("Teacher added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getTeacher() {
        String selectSQL = "SELECT * FROM Teacher";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName");
                int age = resultSet.getInt("age");
                String position = resultSet.getString("position");
                int id_department = resultSet.getInt("id_department");
                int salary = resultSet.getInt("salary");

                System.out.println("ID: " + id + ", Full Name: " + fullName + ", Age: " + age +
                        ", Position: " + position + ", Department ID: " + id_department + ", Salary: " + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateTeacherSalary(int id, int newSalary) {
        String updateSQL = "UPDATE Teacher SET salary = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            preparedStatement.setInt(1, newSalary);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

            System.out.println("Teacher salary updated!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTeacher(int id) {
        String deleteSQL = "DELETE FROM Teacher WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Teacher deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        deleteTeacherTable();
        createTeacherTable();

        addTeacher("John Smith", 40, "Professor", 1, 5000);
        addTeacher("Emily Johnson", 35, "Lecturer", 2, 4000);
        addTeacher("Michael Brown", 50, "Head of Department", 3, 7000);

        System.out.println("List of teachers:");
        getTeacher();

        System.out.println("Updating salary for teacher with ID = 1");
        updateTeacherSalary(1, 5500);

        System.out.println("List of teachers after salary update:");
        getTeacher();

        System.out.println("Deleting teacher with ID = 2");
        deleteTeacher(2);

        System.out.println("List of teachers after deletion:");
        getTeacher();
    }

}
