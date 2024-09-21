package org.example;

class Scientist {
    String lastName;
    int birthYear;
    String gender;
    String fieldOfScience;

    public Scientist(String lastName, int birthYear, String gender, String fieldOfScience) {
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.gender = gender;
        this.fieldOfScience = fieldOfScience;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public String getFieldOfScience() {
        return fieldOfScience;
    }
}