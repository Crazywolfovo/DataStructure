package com.datastructure.Arrays;

import java.util.Objects;

public class Student {

    private String name;
    private int score;

    Student(String studentName, int studentScore) {
        name = studentName;
        score = studentScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }


}
