package labs.lab1;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String birthDate;
    private final String recordBookNumber;

    public Student(String firstName, String lastName, String birthDate, String recordBookNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    @Override
    public String toString() {
        return String.format("Student{firstName='%s', lastName='%s', birthDate='%s', recordBookNumber='%s'}",
                firstName, lastName, birthDate, recordBookNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(recordBookNumber, student.recordBookNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(recordBookNumber);
    }
    @Override
    public int compareTo(Student other) {
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) { return lastNameComparison; }
        return this.firstName.compareTo(other.firstName);
    }

}
