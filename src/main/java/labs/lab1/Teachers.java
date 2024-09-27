package labs.lab1;

public class Teachers {
    private String id;
    private String fullName;
    private String birthday; // Виправлено на правильну назву
    private String position;
    private String phoneNumber;

    // Приватний конструктор, щоб запобігти створенню об'єктів без використання Builder
    private Teachers(Builder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.birthday = builder.birthday;
        this.position = builder.position;
        this.phoneNumber = builder.phoneNumber;
    }

    // Геттери для доступу до полів
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

    // Статичний клас Builder
    public static class Builder {
        private String id;
        private String fullName;
        private String birthday;
        private String position;
        private String phoneNumber;

        // Метод для встановлення id
        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        // Метод для встановлення fullName
        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        // Метод для встановлення birthday
        public Builder setBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        // Метод для встановлення position
        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }

        // Метод для встановлення phoneNumber
        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        // Метод для створення об'єкта Teachers
        public Teachers build() {
            return new Teachers(this);
        }
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

    public static void main(String[] args) {
        Teachers teacher = new Teachers.Builder()
                .setId("AB2341")
                .setFullName("Nina Boyko")
                .setBirthday("1985-06-15")
                .setPosition("Mathematics Teacher")
                .setPhoneNumber("380123456789")
                .build();

        System.out.println(teacher);
    }
}

