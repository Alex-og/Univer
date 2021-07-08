package model;

import exceptions.NoSuchDepartmentException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FacultyTest {

    Faculty expectedFaculty;
    Faculty actualFaculty;

    @Before
    public void setUp() throws Exception {
        expectedFaculty = new Faculty("Best");
        expectedFaculty.addDepartment(new Department("Dep1"));
        actualFaculty = new Faculty("Best");
        actualFaculty.addDepartment(new Department("Dep1"));
    }

    @Test
    public void shouldCompareTwoFacultiesAndTrue() {
        assertEquals(expectedFaculty, actualFaculty);
    }

    @Test
    public void shouldCompareTwoFacultiesAndFalse() {
        Faculty actualFaculty2 = new Faculty("No Best");
        assertNotSame(expectedFaculty, actualFaculty2);
    }

    @Test
    public void shouldGetDepartmentAndCompareAndTrue() throws NoSuchDepartmentException {
        assertThat(expectedFaculty.getDepartment("Dep1"), is(actualFaculty.getDepartment("Dep1")));
    }
}