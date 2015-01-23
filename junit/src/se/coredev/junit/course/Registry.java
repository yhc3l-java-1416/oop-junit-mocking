package se.coredev.junit.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Registry
{
	private Map<String, Student> students;
	private Map<Course, List<Student>> courses;
	

	public Registry()
	{
		students = new HashMap<>();
		courses = new HashMap<>();
	}
	
	public void addStudent(Student student)
	{
		students.put(student.getId(), student);
	}

	public Student getStudentById(String studentId)
	{
		return students.get(studentId);
	}

	public void addCourse(Course course)
	{
		courses.put(course, new ArrayList<Student>());
	}

	public Course getCourseById(String courseId)
	{
		for(Course course : courses.keySet())
		{
			if(course.getId().equals(courseId))
			{
				return course;
			}
		}
		return null;
	}

	public void register(Student student, Course course)
	{
		courses.get(course).add(student);
	}

	public List<Student> getStudentsInCourse(Course course)
	{
		return courses.get(course);
	}

	public void removeStudent(Student student, Course course) throws RegistryException
	{
		courses.get(course).remove(student);		
	}

}









