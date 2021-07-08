package model;

import exceptions.MaxCapacityException;
import exceptions.NoSuchDepartmentException;
import service.FacultyService;
import service.FacultyServiceImpl;

import java.util.Objects;
import java.util.Set;

public class Faculty {
    private final String name;
    private FacultyService facultyService;

    public Faculty(String name) {
        this.name = name;
        facultyService = new FacultyServiceImpl();
    }

    public void setFacultyService(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    public void addDepartment(Department department) {
        try {
            facultyService.addDepartment(department);
        } catch (MaxCapacityException e) {
            e.printStackTrace();
        }
    }

    public Department getDepartment(String name) throws NoSuchDepartmentException {
        return facultyService.getDepartment(name);
    }

    public Set<Department> getAllDepartments() {
        return facultyService.getAllDepartments();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return name.equals(faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name= '" + name +
                "'}";
    }


}
