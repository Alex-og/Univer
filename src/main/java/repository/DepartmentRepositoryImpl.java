package repository;

import exceptions.MaxCapacityException;
import exceptions.NoSuchDepartmentException;
import model.Department;

import java.util.HashSet;
import java.util.Set;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    Set<Department> departments;

    public DepartmentRepositoryImpl() {
        departments = new HashSet<>();
    }

    @Override
    public Set<Department> getDepartments() {
        return departments;
    }

    @Override
    public void addDepartment(Department department) throws MaxCapacityException {
        if (departments.size() == Long.MAX_VALUE) {
            throw new MaxCapacityException(this.getClass().toString());
        }
        departments.add(department);
    }

    @Override
    public Department getDepartment(String name) throws NoSuchDepartmentException {
        return departments.stream().filter(s -> s.getName().equals(name))
                .findAny().orElseThrow(() -> new NoSuchDepartmentException(name));
    }
}
