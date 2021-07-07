package model;

import exceptions.MaxCapacityException;
import exceptions.NoSuchFacultyException;
import exceptions.NoSuchSubjectException;
import service.UniversityService;
import service.UniversityServiceImpl;

import java.util.Objects;
import java.util.Set;

public class University {
    private final String name;
    private UniversityService universityService;

    public University(String name) {
        this.name = name;
        universityService = new UniversityServiceImpl();
    }

    public void addFaculty(Faculty faculty) {
        try {
            universityService.setFaculty(faculty);
        } catch (MaxCapacityException e) {
            e.printStackTrace();
        }
    }

    public Faculty getFaculty(String name) {
        try {
            return universityService.getFaculty(name);
        } catch (NoSuchFacultyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Faculty> getAllFaculties() {
        return universityService.getFaculties();
    }

    public Set<Subject> getAllSubjects() {
        return universityService.getAllSubjects();
    }

    public Subject getSubject(String name) {
        try {
            return universityService.getSubject(name);
        } catch (NoSuchSubjectException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addSubject(Subject subject) {
        try {
            universityService.addSubject(subject);
        } catch (MaxCapacityException e) {
            e.printStackTrace();
        }
    }

    public boolean removeSubject(String name) {
        return universityService.removeSubject(name);
    }

    public String getName() {
        return name;
    }

    public void setUniversityService(UniversityService universityService) {
        this.universityService = universityService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;
        University that = (University) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, universityService);
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", faculties = " + getAllFaculties().toString() +
                '}';
    }
}
