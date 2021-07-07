package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    Department actualDepartment;
    Department expectedDep;

    @Before
    public void setUp() throws Exception {
        expectedDep = new Department("Dep");
        expectedDep.addGroup(new Group(1, 100));

        actualDepartment = new Department("Dep");
        actualDepartment.addGroup(new Group(1, 100));

    }

    @Test
    public void shouldCompareTwoDepartments() {
        assertEquals(expectedDep, actualDepartment);
    }

    @Test
    public void shouldCompareGroupsInDepAndTrue() {
        assertEquals(expectedDep.getGroup(1), actualDepartment.getGroup(1));
    }

    @Test
    public void shouldCompareGroupsInDepAndFalse() {
        expectedDep.addGroup(new Group(2, 200));
        assertNotSame(expectedDep.getGroup(2), actualDepartment.getGroup(1));
    }
}