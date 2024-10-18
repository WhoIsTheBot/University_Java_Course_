package labs.lab4.builders;

import labs.lab1.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentBuilder {
    public String firstName;
    public String lastName;
    public String birthDate;
    public String recordBookNumber;

    // Методи для встановлення значень
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

        if (firstName == null || firstName.isEmpty() || firstName.length() < 2 || firstName.length() > 50) {
            validationErrors.add("First name is invalid: '" + firstName + "'. Must be between 2 and 50 characters.");
        }

        if (lastName == null || lastName.isEmpty() || lastName.length() < 2 || lastName.length() > 50) {
            validationErrors.add("Last name is invalid: '" + lastName + "'. Must be between 2 and 50 characters.");
        }

        if (birthDate == null || !isValidDate(birthDate)) {
            validationErrors.add("Birth date is invalid: '" + birthDate + "'. Must be in format YYYY-MM-DD.");
        }

        if (recordBookNumber == null || !recordBookNumber.matches("^RB\\d{4}$")) {
            validationErrors.add("Record book number is invalid: '" + recordBookNumber + "'. Must start with 'RB' followed by exactly 4 digits.");
        }

        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: \n" + String.join("\n", validationErrors));
        }

        return new Student(this);
    }

    // Перевірка валідності дати
    private boolean isValidDate(String date) {
        return date.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }
}
