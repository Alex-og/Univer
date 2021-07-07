package model;

import exceptions.FullGroupException;
import exceptions.MaxCapacityException;
import exceptions.NoSuchStudentException;
import exceptions.NoSuchSubjectException;
import service.GroupService;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Group {
    private final int id;
    private final long specId;
    private Curator curator;
    private GroupService groupService;

    public Group(int id, long specId) {
        this.id = id;
        this.specId = specId;
    }

    public int getId() {
        return id;
    }

    public long getSpecId() {
        return specId;
    }

    public Curator getCurator() {
        if (curator == null) {
            throw new NullPointerException("A curator has not yet been appointed.");
        }
        return curator;
    }

    public void setCurator(Curator curator) {
        this.curator = curator;
    }

    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public Set<Subject> getAllSubjects() {
        return groupService.getAllSubjects();
    }

    public Subject getSubject(String name) throws NoSuchSubjectException {
        return groupService.getSubject(name);
    }

    public void addSubject(Subject subject) {
        try {
            groupService.addSubject(subject);
        } catch (MaxCapacityException e) {
            e.printStackTrace();
        }
    }

    public boolean removeSubject(String name) {
        return groupService.removeSubject(name);
    }

    public Map<Integer, Student> getAllStudentsOfGroup() {
        return groupService.getAllStudentsOfGroup();
    }

    public void addStudentToGroup(Student student) throws FullGroupException {
        groupService.addStudentToGroup(student);
    }

    public Student getStudentByName(String name, String surName) {
        try {
            return groupService.getStudentByName(name, surName);
        } catch (NoSuchStudentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student getStudentById(int id) throws NoSuchStudentException {
        return groupService.getStudentById(id);
    }

    public boolean removeStudent(int id) {
        return groupService.removeStudent(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                specId == group.specId &&
                Objects.equals(curator, group.curator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specId, curator);
    }
}
