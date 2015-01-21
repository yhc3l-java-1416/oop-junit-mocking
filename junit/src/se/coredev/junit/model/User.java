package se.coredev.junit.model;

public final class User
{
	public static final Integer EMPTY_USER_ID = -1;
	private final Integer id;
	private final String username;

	public User(String username)
	{
		this(EMPTY_USER_ID, username);
	}
	
	public User(Integer id, String username)
	{
		this.id = id;
		this.username = username;
	}

	public Integer getId()
	{
		return id;
	}
	
	public String getUsername()
	{
		return username;
	}
}
