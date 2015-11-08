package com.demo.person.model;

/**
 * @author Juan Manuel Pérez Rodríguez
 */
public class Person {
    private String name;
    private String surname;
    private String location;
    private int age;
    private String uuid;

    public Person() {
    }

    public Person(PersonBuilder builder) {
        name = builder.name;
        surname = builder.surname;
        age = builder.age;
        location = builder.location;
        uuid = builder.uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static class PersonBuilder {
        private String name;
        private String surname;
        private String location;
        private int age;
        private String uuid;

        public PersonBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder withLocation(String location) {
            this.location = location;
            return this;
        }

        public PersonBuilder withUuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append(", age=").append(age);
        sb.append(", uuid='").append(uuid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}