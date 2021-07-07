package repository;

import exceptions.MaxCapacityException;
import model.Group;

import java.util.Map;
import java.util.Set;

public interface GroupRepository {

    Set<Map.Entry<Integer, Group>> getAllGroups();

    Group getGroup(int id);

    void addGroup(Group group) throws MaxCapacityException;
}
