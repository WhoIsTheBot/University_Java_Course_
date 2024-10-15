package labs.lab1;

import labs.lab4.builders.TeacherBuilder;

import java.util.Objects;

/**
 * Клас представляє інформацію про вчителя.
 */
public class Teachers {
    private String id;
    private String fullName;
    private String birthday;
    private String position;
    private String phoneNumber;

    public Teachers(TeacherBuilder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.birthday = builder.birthday;
        this.position = builder.position;
        this.phoneNumber = builder.phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", position='" + position + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teachers teacher = (Teachers) o;
        return Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
