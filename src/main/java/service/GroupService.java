package service;

import exceptions.FullGroupException;
import exceptions.MaxCapacityException;
import exceptions.NoSuchStudentException;
import exceptions.NoSuchSubjectException;
import model.Student;
import model.Subject;

import java.util.Map;
import java.util.Set;

public interface GroupService {

    Set<Subject> getAllSubjects();

    Subject getSubject(String name) throws NoSuchSubjectException;

    void addSubject(Subject subject) throws MaxCapacityException;

    boolean removeSubject(String name);

    Map<Integer, Student> getAllStudentsOfGroup();

    void addStudentToGroup(Student student) throws FullGroupException;

    Student getStudentByName(String name, String surName) throws NoSuchStudentException;

    Student getStudentById(int id) throws NoSuchStudentException;

    boolean removeStudent(int id);
}
