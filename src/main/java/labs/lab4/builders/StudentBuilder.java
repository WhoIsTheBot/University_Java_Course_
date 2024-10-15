package labs.lab4.builders;

import labs.lab1.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBuilder {
    public String firstName;
    public String lastName;
    public String birthDate; // Consider using LocalDate for better date handling
    public String recordBookNumber;

    public StudentBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentBuilder setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public StudentBuilder setRecordBookNumber(String recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
        return this;
    }

    public Student build() {
        List<String> validationErrors = new ArrayList<>();

        if (firstName == null || firstName.isEmpty()) {
            validationErrors.add("First name cannot be null or empty.");
        }

        if (lastName == null || lastName.isEmpty()) {
            validationErrors.add("Last name cannot be null or empty.");
        }

        if (birthDate == null || !isValidDate(birthDate)) {
            validationErrors.add("Birth date must be a valid date in the format YYYY-MM-DD.");
        }

        if (recordBookNumber == null || recordBookNumber.isEmpty()) {
            validationErrors.add("Record book number cannot be null or empty.");
        }

        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationErrors));
        }

        return new Student(this);
    }

    private boolean isValidDate(String date) {
        return date.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }
}
