package service;

import exceptions.MaxCapacityException;
import exceptions.NoSuchDepartmentException;
import model.Department;
import repository.DepartmentRepository;
import repository.DepartmentRepositoryImpl;

import java.util.Set;

public class FacultyServiceImpl implements FacultyService {

    private DepartmentRepository departmentRepo;

    public FacultyServiceImpl() {
        departmentRepo = new DepartmentRepositoryImpl();
    }

    public void setDepartmentRepo(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @Override
    public Set<Department> getAllDepartments() {
        return departmentRepo.getDepartments();
    }

    @Override
    public Department getDepartment(String name) throws NoSuchDepartmentException {
        return departmentRepo.getDepartment(name);
    }

    @Override
    public void addDepartment(Department department) throws MaxCapacityException {
        departmentRepo.addDepartment(department);
    }
}
