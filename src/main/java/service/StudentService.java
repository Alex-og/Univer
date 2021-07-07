package service;

import exceptions.FullGroupException;
import exceptions.MaxCapacityException;
import exceptions.NoSuchStudentException;
import model.Student;
import model.Subject;

import java.util.Map;

public interface StudentService {

    void addSubject(Subject subject) throws MaxCapacityException;

    void addStudent(Student student) throws FullGroupException;

    Map<Integer, Student> getAllStudents();

    Student getStudent(int id) throws NoSuchStudentException;

    void removeStudent(int id);
}
