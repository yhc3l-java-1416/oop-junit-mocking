package se.coredev.junit.repository.test;

import static org.junit.Assert.*;

import org.junit.Test;

import se.coredev.junit.model.User;
import se.coredev.junit.repository.RepositoryException;
import se.coredev.junit.repository.UserRepository;

public final class UserRepositoryTest
{

	@Test(expected = RepositoryException.class)
	public void shouldThrowExceptionWhenUserIdIsNotEmpty()
	{
		final User user = new User(1001, "master");
		final UserRepository repository = new UserRepository();

		repository.addUser(user);
	}

	@Test
	public void shouldCreateUserId()
	{
		final String username = "master";
		final User user = new User(username);
		final UserRepository repository = new UserRepository();

		final User addedUser = repository.addUser(user);

		assertFalse("Added user should have an id", user.getId() == addedUser.getId());
	}

}
