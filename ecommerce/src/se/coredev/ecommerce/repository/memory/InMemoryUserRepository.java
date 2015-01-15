package se.coredev.ecommerce.repository.memory;

import java.util.HashMap;
import java.util.Map;

import se.coredev.ecommerce.model.User;
import se.coredev.ecommerce.repository.UserRepository;

public final class InMemoryUserRepository implements UserRepository
{
	private final Map<String, User> users = new HashMap<>();

	@Override
	public void addUser(final User user)
	{
		users.put(user.getId(), user);
	}
}
