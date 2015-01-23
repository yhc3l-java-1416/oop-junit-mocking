package se.coredev.junit.repository.test;

import static org.junit.Assert.assertFalse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import se.coredev.junit.model.User;
import se.coredev.junit.repository.RepositoryException;
import se.coredev.junit.repository.UserRepository;

public final class UserRepositoryTest
{
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void shouldThrowExceptionWhenUserIdIsNotEmpty()
	{
		exception.expect(RepositoryException.class);
		exception.expectMessage("User must not have an id");
		
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
