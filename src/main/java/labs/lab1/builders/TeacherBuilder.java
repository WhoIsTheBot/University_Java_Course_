package labs.lab1.builders;

import labs.lab1.Teachers;

public class TeacherBuilder {
    public String id;
    public String fullName;
    public String birthday;
    public String position;
    public String phoneNumber;

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
        return new Teachers(this);
    }
}
