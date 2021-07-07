package repository;

import exceptions.NoSuchStudentException;
import model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {


    private final int capacity = 30;
    private Map<Integer, Student> students;

    public StudentRepositoryImpl() {
        this.students = new HashMap<>(capacity);
    }

    @Override
    public Map<Integer, Student> getAllStudentsOfGroup() {
        return students;
    }

    @Override
    public void addStudentToGroup(Student student) {
        students.putIfAbsent(student.getId(), student);
    }

    @Override
    public Student getStudentByName(String name, String surName) throws NoSuchStudentException {
        return students.values().stream().filter(s -> s.getName().equals(name) && s.getSurName().equals(surName))
                .findAny().orElseThrow(() -> new NoSuchStudentException(name, surName));
    }

    @Override
    public Student getStudentById(int id) {
        return students.get(id);
    }

    @Override
    public boolean removeStudent(int id) {
        return students.remove(id) != null;
    }
}
