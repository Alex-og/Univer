package model;

import exceptions.MaxCapacityException;
import service.DepartmentService;
import service.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Department {
    private String name;
    private DepartmentService departmentService;

    public Department(String name) {
        this.name = name;
        departmentService = new DepartmentServiceImpl();
    }

    public String getName() {
        return name;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public Set<Map.Entry<Integer, Group>> getAllGroups() {
        return departmentService.getAllGroups();
    }

    public Group getGroup(int id) {
        return departmentService.getGroup(id);
    }

    public void addGroup(Group group) {
        try {
            departmentService.addGroup(group);
        } catch (MaxCapacityException e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> getAllTeachers() {
        return departmentService.getAllTeachers();
    }

    public Teacher getTeacher(String name, String surName) {
        return departmentService.getTeacher(name, surName);
    }

    public void addTeacher(Teacher teacher) {
        try {
            departmentService.addTeacher(teacher);
        } catch (MaxCapacityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;
        Department that = (Department) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
