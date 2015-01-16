package se.coredev.ecommerce.service;

import se.coredev.ecommerce.model.User;
import se.coredev.ecommerce.repository.RepositoryException;
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
			try
			{
				return userRepository.addUser(userToAdd);
			}
			catch (RepositoryException e)
			{
				throw new ECommerceManagerException("Could not add user", e);
			}
		}
		throw new ECommerceManagerException(String.format("User with id:%s already stored. Use updateUser() instead", 
														  userToAdd.getId()));
	}
	
	public User getUser(final int userId)
	{
		try
		{
			return userRepository.getUserById(userId);
		}
		catch (RepositoryException e)
		{
			throw new ECommerceManagerException("Could not get user with id:" + userId, e);
		}
	}
	
	public User updateUser(final User user)
	{
		try
		{
			return userRepository.updateUser(user);
		}
		catch (RepositoryException e)
		{
			throw new ECommerceManagerException("Could not update user", e);
		}
	}
	
	public User deleteUser(int userId)
	{
		try
		{
			return userRepository.deleteUser(userId);
		}
		catch (RepositoryException e)
		{
			throw new ECommerceManagerException("Could not delete user", e);
		}
	}
	
}















