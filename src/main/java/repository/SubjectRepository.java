package repository;

import exceptions.MaxCapacityException;
import exceptions.NoSuchSubjectException;
import model.Subject;

import java.util.Set;

public interface SubjectRepository {

    Set<Subject> getAllSubjects();

    void addSubject(Subject subject) throws MaxCapacityException;

    Subject getSubject(String name) throws NoSuchSubjectException;

    boolean removeSubject(String name);
}
