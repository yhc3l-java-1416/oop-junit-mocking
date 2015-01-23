package se.coredev.junit.course;

public final class Student
{
	private final String id;
	private final String name;

	public Student(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if (other instanceof Student)
		{
			Student otherStudent = (Student) other;
			return id.equals(otherStudent.id);
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		int result = 1;
		result += 37 * id.hashCode();

		return result;
	}

}
