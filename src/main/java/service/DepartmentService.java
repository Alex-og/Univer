package service;

import exceptions.MaxCapacityException;
import model.Group;
import model.Teacher;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DepartmentService {

    Set<Map.Entry<Integer, Group>> getAllGroups();

    Group getGroup(int id);

    void addGroup(Group group) throws MaxCapacityException;

    List<Teacher> getAllTeachers();

    Teacher getTeacher(String name, String surName);

    void addTeacher(Teacher teacher) throws MaxCapacityException;
}
