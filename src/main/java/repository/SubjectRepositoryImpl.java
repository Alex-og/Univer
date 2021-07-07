package repository;

import exceptions.MaxCapacityException;
import exceptions.NoSuchSubjectException;
import model.Subject;

import java.util.HashSet;
import java.util.Set;

public class SubjectRepositoryImpl implements SubjectRepository {

    Set<Subject> subjects;

    public SubjectRepositoryImpl() {
        subjects = new HashSet<>();
    }

    @Override
    public Set<Subject> getAllSubjects() {
        return subjects;
    }

    @Override
    public void addSubject(Subject subject) throws MaxCapacityException {
        if (subjects.size() == Long.MAX_VALUE) {
            throw new MaxCapacityException(this.getClass().toString());
        }
        subjects.add(subject);
    }

    @Override
    public Subject getSubject(String name) throws NoSuchSubjectException {
        return subjects.stream().filter(s -> s.getName().equals(name)).findAny()
                .orElseThrow(() -> new NoSuchSubjectException(name));
    }

    @Override
    public boolean removeSubject(String name) {
        return subjects.removeIf(s -> s.getName().equals(name));
    }
}
