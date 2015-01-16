package se.coredev.ecommerce.repository;

import se.coredev.ecommerce.model.User;

public interface UserRepository
{
	User addUser(User user) throws RepositoryException;
	User getUserById(int userId) throws RepositoryException;
	User updateUser(User user) throws RepositoryException;
	User deleteUser(int userId) throws RepositoryException;
}
