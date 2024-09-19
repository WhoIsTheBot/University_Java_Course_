package labs.lab2;

import labs.lab1.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Collections {

    // Метод для сортування студентів за прізвищем (Comparable)
    public List<Student> sortStudentsByLastName(List<Student> students) {
        return students.stream()
                .sorted()  // використовує compareTo з Comparable
                .collect(Collectors.toList());
    }

    // Comparator для сортування студентів за датою народження
    public List<Student> sortStudentsByBirthDate(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getBirthDate))  // Сортування за датою народження
                .collect(Collectors.toList());
    }

    // Метод для пошуку студентів за номером залікової книжки
    public Optional<Student> findStudentByRecordBookNumber(List<Student> students, String recordBookNumber) {
        return students.stream()
                .filter(student -> student.getRecordBookNumber().equals(recordBookNumber))
                .findFirst();  // Повертає першого студента з відповідним номером залікової книжки
    }

    // Метод для фільтрації студентів за прізвищем
    public List<Student> filterStudentsByLastName(List<Student> students, String lastName) {
        return students.stream()
                .filter(student -> student.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }
}

