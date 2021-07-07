package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FacultyTest {

    Faculty expectedFaculty;
    Faculty actualFaculty;

    @Before
    public void setUp() throws Exception {
        expectedFaculty = new Faculty("Best");
        actualFaculty = new Faculty("Best");
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
}