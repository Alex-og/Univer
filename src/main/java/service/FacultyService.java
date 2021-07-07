package service;

import exceptions.MaxCapacityException;
import exceptions.NoSuchDepartmentException;
import model.Department;

import java.util.Set;

public interface FacultyService {

    Set<Department> getAllDepartments();

    Department getDepartment(String name) throws NoSuchDepartmentException;

    void addDepartment(Department department) throws MaxCapacityException;
}
