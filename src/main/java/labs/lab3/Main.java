package labs.lab3;

import labs.lab1.Student;
import labs.lab4.builders.StudentBuilder;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Створення студента за допомогою StudentBuilder
        Student student = new StudentBuilder()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setBirthDate("2000-01-01")
                .setRecordBookNumber("123456")
                .build();

        // Використання JsonSerializer
        JsonSerializer<Student> jsonSerializer = new JsonSerializer<>(Student.class);

        try {
            // Серіалізація в JSON
            String json = jsonSerializer.serialize(student);
            System.out.println("Serialized JSON: " + json);

            // Запис в файл
            File jsonFile = new File("student.json");
            jsonSerializer.writeToFile(student, jsonFile);

            // Читання з файлу
            Student readStudent = jsonSerializer.readFromFile(jsonFile);
            System.out.println("Read Student from file: " + readStudent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
