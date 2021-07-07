package model;

import java.util.Objects;
import java.util.Set;

public class Teacher extends Person {
    private Set<Subject> subjects;

    public Teacher(String name, String surName) {
        super(name, surName);
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return super.getName();
    }

    public String getSurName() {
        return super.getSurName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(subjects, teacher.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjects);
    }
}
