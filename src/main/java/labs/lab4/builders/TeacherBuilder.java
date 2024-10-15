package labs.lab4.builders;

import labs.lab1.Teachers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TeacherBuilder {
    public String id;
    public String fullName;
    public String birthday;
    public String position;
    public String phoneNumber;

    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9]{10,15}$");

    public TeacherBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public TeacherBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public TeacherBuilder setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public TeacherBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public TeacherBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Teachers build() {
        List<String> validationErrors = new ArrayList<>();

        if (id == null || id.isEmpty()) {
            validationErrors.add("ID cannot be null or empty.");
        }

        if (fullName == null || fullName.isEmpty()) {
            validationErrors.add("Full name cannot be null or empty.");
        }

        if (birthday == null || !isValidDate(birthday)) {
            validationErrors.add("Birthday must be a valid date in the format YYYY-MM-DD.");
        }

        if (position == null || position.isEmpty()) {
            validationErrors.add("Position cannot be null or empty.");
        }

        if (phoneNumber == null || !PHONE_PATTERN.matcher(phoneNumber).matches()) {
            validationErrors.add("Phone number must be valid (10 to 15 digits, optional leading '+').");
        }

        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationErrors));
        }

        return new Teachers(this);
    }

    private boolean isValidDate(String date) {
        return date.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }
}
