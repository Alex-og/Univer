package repository;

import exceptions.MaxCapacityException;
import exceptions.NoSuchDepartmentException;
import model.Department;

import java.util.Set;

public interface DepartmentRepository {

    Set<Department> getDepartments();

    void addDepartment(Department department) throws MaxCapacityException;

    Department getDepartment(String name) throws NoSuchDepartmentException;
}
