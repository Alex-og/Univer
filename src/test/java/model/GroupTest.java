package model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class GroupTest {

    Group expectedGroup;
    Group actualGroup;

    @Before
    public void setUp() throws Exception {
        expectedGroup = new Group(3, 300);
        expectedGroup.setCurator(new Curator("Name", "Surname"));

        actualGroup = new Group(3, 300);
        actualGroup.setCurator(new Curator("Name", "Surname"));
    }

    @Test
    public void shouldCompareTwoGroupsAndTrue() {
        assertEquals(expectedGroup, actualGroup);
    }

    @Test
    public void shouldCompareTwoGroupsAndFalse() {
        Group expectedGroup2 = new Group(4, 400);
        assertNotSame(expectedGroup2, actualGroup);
    }

    @Test
    public void shouldCompareCuratorsAndTrue() {
        assertEquals(expectedGroup.getCurator(), actualGroup.getCurator());
    }

    @Test
    public void shouldCompareCuratorsAndFalse() {
        Group expectedGroup2 = new Group(4, 400);
        expectedGroup2.setCurator(new Curator("Name2", "Surname2"));
        assertNotSame(expectedGroup2.getCurator(), actualGroup.getCurator());
    }

    @Test
    public void shouldThrowNPE() {
        Group expectedGroup5 = new Group(5, 500);
        NullPointerException exception = Assertions.assertThrows(NullPointerException.class,
                () -> expectedGroup5.getCurator());
        assertEquals("A curator has not yet been appointed.", exception.getMessage());
    }
}