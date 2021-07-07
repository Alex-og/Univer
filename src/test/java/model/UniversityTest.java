package model;

import exceptions.NoSuchSubjectException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import service.UniversityService;
import service.UniversityServiceImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

public class UniversityTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    University expected;
    University actualUniversity;
    UniversityService actualUniversityService;

    @Before
    public void setUp() throws Exception {
        expected = new University("KNUCA");

        actualUniversity = new University("KNUCA");
        actualUniversityService = new UniversityServiceImpl();
        actualUniversity.setUniversityService(actualUniversityService);
        actualUniversity.addFaculty(new Faculty("A"));
        actualUniversity.addFaculty(new Faculty("B"));
        actualUniversity.addFaculty(new Faculty("C"));
        actualUniversity.addSubject(new Subject("Math"));


    }

    @Test
    public void shouldCompareTwoUnivercities() {
        assertThat(expected, is(actualUniversity));
    }

    @Test
    public void shouldCompareFacultiesAndEqualTrue() {
        UniversityService universityServiceExp = new UniversityServiceImpl();
        expected.setUniversityService(universityServiceExp);
        expected.addFaculty(new Faculty("A"));
        expected.addFaculty(new Faculty("B"));
        expected.addFaculty(new Faculty("C"));

        assertThat(actualUniversity, is(expected));
    }

    @Test
    public void shouldCompareFacultiesAndEqualFalse() {
        UniversityService universityServiceExp = new UniversityServiceImpl();
        expected.setUniversityService(universityServiceExp);
        expected.addFaculty(new Faculty("A"));
        expected.addFaculty(new Faculty("B"));
        expected.addFaculty(new Faculty("B"));

        assertNotSame(actualUniversity, expected);
    }

    @Test
    public void shouldCompareSubjectsAndEqualTrue() {
        expected.addSubject(new Subject("Math"));
        assertThat(expected.getSubject("Math"), is(actualUniversity.getSubject("Math")));
    }

    @Test/*(expected = NoSuchSubjectException.class)*/
    public void shouldThrowNoSuchSubjectException() {
        exception.expect(NoSuchSubjectException.class);
        actualUniversity.getSubject("Sport");
    }
}