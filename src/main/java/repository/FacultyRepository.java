package repository;

import exceptions.MaxCapacityException;
import exceptions.NoSuchFacultyException;
import model.Faculty;

import java.util.Set;

public interface FacultyRepository {

    Set<Faculty> getFaculties();

    void addFaculty(Faculty faculty) throws MaxCapacityException;

    Faculty getFaculty(String name) throws NoSuchFacultyException;
}
