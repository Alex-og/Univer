package repository;

import exceptions.MaxCapacityException;
import model.Teacher;

import java.util.List;

public interface TeacherRepository {

    List<Teacher> getAllTeachers();

    Teacher getTeacher(String name, String surName);

    void addTeacher(Teacher teacher) throws MaxCapacityException;
}
