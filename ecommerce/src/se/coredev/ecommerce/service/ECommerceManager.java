package se.coredev.ecommerce.service;

import java.util.UUID;

import se.coredev.ecommerce.model.User;
import se.coredev.ecommerce.repository.UserRepository;

public final class ECommerceManager
{
	private final UserRepository userRepository;

	public ECommerceManager(final UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	public User addUser(final User userToAdd)
	{
		if (userToAdd.getId() == User.EMPTY_USER_ID)
		{
			User user = new User(getUserId(), userToAdd.getUsername(), userToAdd.getPassword());
			userRepository.addUser(user);

			return user;
		}

		throw new ECommerceManagerException(String.format("User with id:%s already stored. Use updateUser() instead", userToAdd.getId()));
	}

	private String getUserId()
	{
		return UUID.randomUUID().toString();
	}
}
