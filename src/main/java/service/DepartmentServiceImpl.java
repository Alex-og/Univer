package service;

import exceptions.MaxCapacityException;
import model.Group;
import model.Teacher;
import repository.GroupRepository;
import repository.GroupRepositoryImpl;
import repository.TeacherRepository;
import repository.TeacherRepositoryImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DepartmentServiceImpl implements DepartmentService {

    private GroupRepository groupRepo;
    private TeacherRepository teacherRepo;

    public DepartmentServiceImpl() {
        groupRepo = new GroupRepositoryImpl();
        teacherRepo = new TeacherRepositoryImpl();
    }

    public GroupRepository getGroupRepo() {
        return groupRepo;
    }

    public void setGroupRepo(GroupRepository groupRepo) {
        this.groupRepo = groupRepo;
    }

    public TeacherRepository getTeacherRepo() {
        return teacherRepo;
    }

    public void setTeacherRepo(TeacherRepository teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public Set<Map.Entry<Integer, Group>> getAllGroups() {
        return groupRepo.getAllGroups();
    }

    @Override
    public Group getGroup(int id) {
        return groupRepo.getGroup(id);
    }

    @Override
    public void addGroup(Group group) throws MaxCapacityException {
        groupRepo.addGroup(group);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.getAllTeachers();
    }

    @Override
    public Teacher getTeacher(String name, String surName) {
        return teacherRepo.getTeacher(name, surName);
    }

    @Override
    public void addTeacher(Teacher teacher) throws MaxCapacityException {
        teacherRepo.addTeacher(teacher);
    }
}
