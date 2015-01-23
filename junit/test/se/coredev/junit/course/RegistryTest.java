package se.coredev.junit.course;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public final class RegistryTest
{
	private Registry registry;
	
	@Before
	public void setup()
	{
		registry = new Registry();
	}
	
	@Test
	public void canAddStudentToRegistry()
	{
		String studentId = "1001";
		Student student = new Student(studentId, "Master Yoda");
		registry.addStudent(student);

		Student studentFromRegistry = registry.getStudentById(studentId);

		// Hamcrest style
		assertThat("Added student should be in registry", studentFromRegistry, is(student));
		// JUnit style
		//assertEquals("Added student should be in registry", student, studentFromRegistry);
	}

	@Test
	public void canAddCourseToRegistry()
	{
		String courseId = "jp-1416";
		Course course = new Course(courseId, "Java Programming");
		registry.addCourse(course);

		Course courseFromRegistry = registry.getCourseById(courseId);
		
		// Hamcrest style
		assertThat("Added course should be in registry", course, is(courseFromRegistry));
		// JUnit style
		//assertEquals("Added course should be in registry", course, courseFromRegistry);
	}

	@Test
	public void canRegisterStudentForCourse()
	{
		Course javaCourse = new Course("jp-1416", "Java programming");
		Student student = new Student("1001", "Master Yoda");

		registry.addCourse(javaCourse);
		registry.register(student, javaCourse);

		List<Student> javaStudents = registry.getStudentsInCourse(javaCourse);

		// Hamcrest style
		assertThat(javaStudents, is(notNullValue()));
		assertThat(javaStudents.size(), is(1));
		assertThat(javaStudents, hasItem(student));
		
		// JUnit style
//		assertNotNull(javaStudents);
//		assertEquals(javaStudents.size(), 1);
//		assertEquals(javaStudents.get(0), student);
	}

	@Test
	public void canRemoveStudentFromCourse()
	{
		Course javaCourse = new Course("jp-1416", "Java programming");
		Student student = new Student("1001", "Master Yoda");

		registry.addCourse(javaCourse);
		registry.register(student, javaCourse);
		
		List<Student> javaStudents = registry.getStudentsInCourse(javaCourse);
		assertTrue(javaStudents.contains(student));
		
		registry.removeStudent(student, javaCourse);
		
		javaStudents = registry.getStudentsInCourse(javaCourse);
		
		assertFalse(javaStudents.contains(student));
	}
	
	@Test
	public void shouldThrowExceptionOnRemoveNonexistingStudent()
	{
		fail();
	}

}

















