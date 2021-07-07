package service;

import exceptions.FullGroupException;
import exceptions.MaxCapacityException;
import exceptions.NoSuchStudentException;
import model.Student;
import model.Subject;
import repository.StudentRepository;
import repository.SubjectRepository;

import java.util.Map;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository groupRepo;
    private final SubjectRepository subjectRepo;

    public StudentServiceImpl(StudentRepository groupRepo, SubjectRepository subjectRepo) {
        this.groupRepo = groupRepo;
        this.subjectRepo = subjectRepo;
    }

    @Override
    public void addSubject(Subject subject) throws MaxCapacityException {
        subjectRepo.addSubject(subject);
    }

    @Override
    public void addStudent(Student student) throws FullGroupException {
        groupRepo.addStudentToGroup(student);
    }

    @Override
    public Map<Integer, Student> getAllStudents() {
        return groupRepo.getAllStudentsOfGroup();
    }

    @Override
    public Student getStudent(int id) throws NoSuchStudentException {
        return groupRepo.getStudentById(id);
    }

    @Override
    public void removeStudent(int id) {
        groupRepo.removeStudent(id);
    }
}
