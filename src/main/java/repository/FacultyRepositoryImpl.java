package repository;

import exceptions.MaxCapacityException;
import exceptions.NoSuchFacultyException;
import model.Faculty;

import java.util.HashSet;
import java.util.Set;

public class FacultyRepositoryImpl implements FacultyRepository {

    private Set<Faculty> faculties;

    public FacultyRepositoryImpl() {
        faculties = new HashSet<>();
    }

    @Override
    public Set<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public void addFaculty(Faculty faculty) throws MaxCapacityException {
        if (faculties.size() == Long.MAX_VALUE) {
            throw new MaxCapacityException(this.getClass().toString());
        }
        faculties.add(faculty);
    }

    @Override
    public Faculty getFaculty(String name) throws NoSuchFacultyException {
        return faculties.stream().filter(s -> s.getName().equals(name)).findAny()
                .orElseThrow(() -> new NoSuchFacultyException(name));
    }
}
