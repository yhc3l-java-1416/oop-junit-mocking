package se.coredev.junit.repository;

import static se.coredev.junit.model.User.EMPTY_USER_ID;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import se.coredev.junit.model.User;

public final class UserRepository
{
	private static final AtomicInteger userIds = new AtomicInteger();
	private final Map<String, User> users;

	public UserRepository()
	{
		this.users = new HashMap<>();
	}

	public User addUser(final User user) throws RepositoryException
	{
		if (user.getId() == EMPTY_USER_ID)
		{
			User userToAdd = new User(getNextUserId(), user.getUsername());
			users.put(user.getUsername(), user);

			return userToAdd;
		} 
		
		throw new RepositoryException();
	}

	public User getUser(final String username)
	{
		return users.get(username);
	}

	private static Integer getNextUserId()
	{
		return userIds.incrementAndGet();
	}

}
