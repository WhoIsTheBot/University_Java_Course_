package labs.lab2;

import labs.lab1.Group;
import labs.lab1.Student;
import labs.lab1.Teachers;

import java.util.*;
import java.util.stream.Collectors;

public class Collections {

    // Метод для сортування студентів за прізвищем (Comparable)
    public List<Student> sortStudentsByLastName(List<Student> students) {
        return students.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // Comparator для сортування студентів за датою народження
    public List<Student> sortStudentsByBirthDate(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getBirthDate))
                .collect(Collectors.toList());
    }

    // Метод для пошуку студентів за номером залікової книжки
    public Optional<Student> findStudentByRecordBookNumber(List<Student> students, String recordBookNumber) {
        return students.stream()
                .filter(student -> student.getRecordBookNumber().equals(recordBookNumber))
                .findFirst();
    }

    // Метод для фільтрації студентів за прізвищем
    public List<Student> filterStudentsByLastName(List<Student> students, String lastName) {
        return students.stream()
                .filter(student -> student.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    // Метод для сортування груп за роком створення
    public List<Group> sortGroupsByYearCreated(List<Group> groups) {
        return groups.stream()
                .sorted(Comparator.comparing(Group::getYearCreated))
                .collect(Collectors.toList());
    }

    // Метод для пошуку групи за номером групи
    public Optional<Group> findGroupByGroupNumber(List<Group> groups, String groupNumber) {
        return groups.stream()
                .filter(group -> group.getGroupNumber().equals(groupNumber))
                .findFirst();
    }

    // Метод для фільтрації груп за департаментом
    public List<Group> filterGroupsByDepartment(List<Group> groups, String department) {
        return groups.stream()
                .filter(group -> group.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Collections collections = new Collections();
        List<Student> students = new ArrayList<>();
        List<Group> groups = new ArrayList<>();

        students.add(new Student("Rayan", "Gosling", "2001-02-12","AB567" ));
        students.add(new Student("Emma", "Atoyn", "2006-09-12","AB167" ));
        students.add(new Student("Rayan", "Slipers", "2000-11-22","AB967" ));
        students.add(new Student("Anna", "Rinzon", "2001-02-12","AB507" ));

        groups.add(new Group("101", 2022,"Computer Science",null, new ArrayList<>()));
        groups.add(new Group("311", 2020,"Computer Science",null, new ArrayList<>()));
        groups.add(new Group("302", 2020,"Mathematics",null, new ArrayList<>()));

        System.out.println(collections.sortStudentsByLastName(students));
        System.out.println(collections.findGroupByGroupNumber(groups,"101"));
    }
}
