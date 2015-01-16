package se.coredev.ecommerce.repository.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import se.coredev.ecommerce.model.User;
import se.coredev.ecommerce.repository.RepositoryException;
import se.coredev.ecommerce.repository.UserRepository;

public final class InMemoryUserRepository implements UserRepository
{
	private static final AtomicInteger userIds = new AtomicInteger();
	private final Map<Integer, User> users = new HashMap<>();

	@Override
	public User addUser(final User user)
	{
		int userId = userIds.incrementAndGet();
		User userToStore = new User(userId, user.getUsername(), user.getPassword());

		users.put(userToStore.getId(), userToStore);

		return userToStore;
	}

	@Override
	public User getUserById(int userId) throws RepositoryException
	{
		if (users.containsKey(userId))
		{
			return users.get(userId);
		}
		throw new RepositoryException("Could not find user with id" + userId);
	}

	@Override
	public User updateUser(User user) throws RepositoryException
	{
		User previousUser = users.replace(user.getId(), user);
		
		if(previousUser == null)
		{
			throw new RepositoryException("User not in storage");
		}

		return user;	
	}

	@Override
	public User deleteUser(int userId) throws RepositoryException
	{
		if (users.containsKey(userId))
		{
			return users.remove(userId);
		}
		throw new RepositoryException("User with id:" + userId + " could not be deleted");
	}

}












