package model;

import java.util.Objects;

public class Student extends Person {
    private final int id;
    private Group group;

    public Student(int id, String name, String surName) {
        super(name, surName);
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return super.getName();
    }

    public String getSurName() {
        return super.getSurName();
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", group=" + group +
                '}';
    }
}
