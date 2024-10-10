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

        Collections service = new Collections();

        service.addItem("Coffee");
        service.addItem("Tea");
        service.addItem("Cake");
        service.addItem("Tost");
        service.addItem("Late");

        System.out.println(service.containsItem("Tost"));
        System.out.println(service.containsItem("Bread"));

        service.removeItem("Late");

        System.out.println(service.containsItem("Late"));

        System.out.println(service.getAllItems());
        System.out.println(service.countIteams());

        service.sortItems();
        System.out.println(service.getAllItems());
        service.clearItems();
        System.out.println(service.getAllItems());
    }
}
