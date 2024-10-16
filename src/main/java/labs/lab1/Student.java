package labs.lab1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import labs.lab4.builders.StudentBuilder;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String birthDate;
    private final String recordBookNumber;

    @JsonCreator
    public Student(@JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("birthDate") String birthDate,
                   @JsonProperty("recordBookNumber") String recordBookNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    public Student(StudentBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.birthDate = builder.birthDate;
        this.recordBookNumber = builder.recordBookNumber;
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
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        return this.firstName.compareTo(other.firstName);
    }
}
