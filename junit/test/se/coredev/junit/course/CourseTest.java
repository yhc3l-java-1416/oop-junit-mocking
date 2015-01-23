package se.coredev.junit.course;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseTest
{

	@Test
	public void twoCoursesWithSameValueShouldBeEqual()
	{
		Course courseOne = new Course("1", "one");
		Course courseTwo = new Course("1", "one");
		
		assertEquals(courseOne, courseTwo);
	}
	
	@Test
	public void twoCoursesWithSameValueShouldProduceSameHashCode()
	{
		Course courseOne = new Course("1", "one");
		Course courseTwo = new Course("1", "one");
		
		assertEquals(courseOne.hashCode(), courseTwo.hashCode());
	}

}
