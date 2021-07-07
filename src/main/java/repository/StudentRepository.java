package repository;

import exceptions.FullGroupException;
import exceptions.NoSuchStudentException;
import model.Student;

import java.util.Map;

public interface StudentRepository {

    Map<Integer, Student> getAllStudentsOfGroup();

    void addStudentToGroup(Student student) throws FullGroupException;

    Student getStudentByName(String name, String surName) throws NoSuchStudentException;

    Student getStudentById(int id) throws NoSuchStudentException;

    boolean removeStudent(int id);
}
