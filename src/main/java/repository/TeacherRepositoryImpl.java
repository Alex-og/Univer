package repository;

import exceptions.MaxCapacityException;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryImpl implements TeacherRepository {

    List<Teacher> teachers;

    public TeacherRepositoryImpl() {
        teachers = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    @Override
    public Teacher getTeacher(String name, String surName) {
        for (Teacher tch : teachers) {
            if (tch.getName().equals(name) && tch.getSurName().equals(surName)) {
                return tch;
            }
        }
        return null;
    }

    @Override
    public void addTeacher(Teacher teacher) throws MaxCapacityException {
        if (teachers.size() == Long.MAX_VALUE) {
            throw new MaxCapacityException(this.getClass().toString());
        }
        teachers.add(teacher);
    }
}
