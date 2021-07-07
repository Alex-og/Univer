package service;

import exceptions.MaxCapacityException;
import exceptions.NoSuchFacultyException;
import exceptions.NoSuchSubjectException;
import model.Faculty;
import model.Subject;
import repository.FacultyRepository;
import repository.FacultyRepositoryImpl;
import repository.SubjectRepository;
import repository.SubjectRepositoryImpl;

import java.util.Set;

public class UniversityServiceImpl implements UniversityService {

    private FacultyRepository facultyRepo;
    private SubjectRepository subjectRepo;

    public UniversityServiceImpl() {
        facultyRepo = new FacultyRepositoryImpl();
        subjectRepo = new SubjectRepositoryImpl();
    }

    public void setFacultyRepo(FacultyRepository facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    public SubjectRepository getSubjectRepo() {
        return subjectRepo;
    }

    public void setSubjectRepo(SubjectRepository subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    @Override
    public Set<Faculty> getFaculties() {
        return facultyRepo.getFaculties();
    }

    @Override
    public void setFaculty(Faculty faculty) throws MaxCapacityException {
        facultyRepo.addFaculty(faculty);
    }

    @Override
    public Faculty getFaculty(String name) throws NoSuchFacultyException {
        return facultyRepo.getFaculty(name);
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

}
