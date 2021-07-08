package service;

import exceptions.FullGroupException;
import exceptions.MaxCapacityException;
import exceptions.NoSuchStudentException;
import exceptions.NoSuchSubjectException;
import model.Student;
import model.Subject;
import repository.StudentRepository;
import repository.StudentRepositoryImpl;
import repository.SubjectRepository;
import repository.SubjectRepositoryImpl;

import java.util.Map;
import java.util.Set;

public class GroupServiceImpl implements GroupService {

    private StudentRepository studentRepo;
    private SubjectRepository subjectRepo;

    public GroupServiceImpl() {
        subjectRepo = new SubjectRepositoryImpl();
        studentRepo = new StudentRepositoryImpl();
    }

    public StudentRepository getStudentRepo() {
        return studentRepo;
    }

    public void setStudentRepo(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public SubjectRepository getSubjectRepo() {
        return subjectRepo;
    }

    public void setSubjectRepo(SubjectRepository subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    @Override
    public Set<Subject> getAllSubjects() {
        return subjectRepo.getAllSubjects();
    }

    @Override
    public Subject getSubject(String name) throws NoSuchSubjectException {
        return subjectRepo.getSubject(name);
    }

    @Override
    public void addSubject(Subject subject) throws MaxCapacityException {
        subjectRepo.addSubject(subject);
    }

    @Override
    public boolean removeSubject(String name) {
        return subjectRepo.removeSubject(name);
    }

    @Override
    public Map<Integer, Student> getAllStudentsOfGroup() {
        return studentRepo.getAllStudentsOfGroup();
    }

    @Override
    public void addStudentToGroup(Student student) throws FullGroupException {
        studentRepo.addStudentToGroup(student);
    }

    @Override
    public Student getStudentByName(String name, String surName) throws NoSuchStudentException {
        return studentRepo.getStudentByName(name, surName);
    }

    @Override
    public Student getStudentById(int id) throws NoSuchStudentException {
        return studentRepo.getStudentById(id);
    }

    @Override
    public boolean removeStudent(int id) {
        return studentRepo.removeStudent(id);
    }
}
