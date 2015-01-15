package se.coredev.ecommerce.model;

public final class User
{
	public static final String EMPTY_USER_ID = "-1";
	
	private final String id;
	private final String username;
	private final String password;

	public User(String username, String password)
	{
		this(EMPTY_USER_ID, username, password);
	}

	public User(String id, String username, String password)
	{
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public String getId()
	{
		return id;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	public User setPassword(String password)
	{
		return new User(this.id, this.username, password);
	}

	@Override
	public boolean equals(Object other)
	{
		if (other instanceof User)
		{
			User otherUser = (User) other;
			return id.equals(otherUser.id) && username.equals(otherUser.username);
		}

		return false;
	}

	@Override
	public int hashCode()
	{
		int result = 1;
		result *= 37 + id.hashCode();
		result *= 37 + username.hashCode();

		return result;
	}

}
