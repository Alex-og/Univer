package service;

import exceptions.MaxCapacityException;
import exceptions.NoSuchFacultyException;
import exceptions.NoSuchSubjectException;
import model.Faculty;
import model.Subject;

import java.util.Set;

public interface UniversityService {

    Set<Faculty> getFaculties();

    void setFaculty(Faculty faculty) throws MaxCapacityException;

    Faculty getFaculty(String name) throws NoSuchFacultyException;

    Set<Subject> getAllSubjects();

    Subject getSubject(String name) throws NoSuchSubjectException;

    void addSubject(Subject subject) throws MaxCapacityException;

    boolean removeSubject(String name);
}
