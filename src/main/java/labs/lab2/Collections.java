package labs.lab2;

import labs.lab1.Group;
import labs.lab1.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class Collections {
    private List<String> items;

    public Collections(){
        this.items = new ArrayList<>();
    }

    public List<String> getAllItems(){
        return new ArrayList<>(items);
    }

    public void clearItems(){
        items.clear();
    }

    public int countIteams(){
        return items.size();
    }

    public void sortItems(){
        java.util.Collections.sort(items);
    }

    public void addItem(String item){
        items.add(item);
    }

    public void removeItem(String item){
        items.remove(item);
    }

    public boolean containsItem(String item){
        return items.contains(item);
    }


    public List<Student> sortStudentsByLastName(List<Student> students) {
        return students.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Student> sortStudentsByBirthDate(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getBirthDate))
                .collect(Collectors.toList());
    }

    public Optional<Student> findStudentByRecordBookNumber(List<Student> students, String recordBookNumber) {
        return students.stream()
                .filter(student -> student.getRecordBookNumber().equals(recordBookNumber))
                .findFirst();
    }

    public List<Student> filterStudentsByLastName(List<Student> students, String lastName) {
        return students.stream()
                .filter(student -> student.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public List<Group> sortGroupsByYearCreated(List<Group> groups) {
        return groups.stream()
                .sorted(Comparator.comparing(Group::getYearCreated))
                .collect(Collectors.toList());
    }

    public Optional<Group> findGroupByGroupNumber(List<Group> groups, String groupNumber) {
        return groups.stream()
                .filter(group -> group.getGroupNumber().equals(groupNumber))
                .findFirst();
    }

    public List<Group> filterGroupsByDepartment(List<Group> groups, String department) {
        return groups.stream()
                .filter(group -> group.getDepartment().equals(department))
                .collect(Collectors.toList());
    }
}
