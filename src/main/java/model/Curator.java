package model;

import java.util.Objects;
import java.util.Set;

public class Curator extends Person {
    private Set<Group> groups;

    public Curator(String name, String surName) {
        super(name, surName);
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public String getName() {
        return super.getName();
    }

    public String getSurName() {
        return super.getSurName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;
        Curator curator = (Curator) o;
        return Objects.equals(groups, curator.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groups);
    }

    @Override
    public String toString() {
        return "Curator{" +
                "name = " + this.getName() +
                " surName = " + this.getSurName() +
                "}";
    }
}
