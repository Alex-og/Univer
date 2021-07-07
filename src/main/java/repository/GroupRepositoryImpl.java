package repository;

import exceptions.MaxCapacityException;
import model.Group;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GroupRepositoryImpl implements GroupRepository {

    Map<Integer, Group> groups;

    public GroupRepositoryImpl() {
        groups = new HashMap<>();
    }

    @Override
    public Set<Map.Entry<Integer, Group>> getAllGroups() {
        return groups.entrySet();
    }

    @Override
    public Group getGroup(int id) {
        return groups.get(id);
    }

    @Override
    public void addGroup(Group group) throws MaxCapacityException {
        if (groups.size() == Long.MAX_VALUE) {
            throw new MaxCapacityException(this.getClass().toString());
        }
        groups.putIfAbsent(group.getId(), group);
    }
}
