package se.coredev.ecommerce;

import se.coredev.ecommerce.model.User;
import se.coredev.ecommerce.repository.UserLogRepository;
import se.coredev.ecommerce.repository.UserRepository;
import se.coredev.ecommerce.repository.memory.InMemoryUserRepository;
import se.coredev.ecommerce.service.ECommerceManager;

public class Main
{
	public static void main(String[] args)
	{
		final UserRepository inMemoryUserRepository = new InMemoryUserRepository();
		// Decorate inMemoryUserRepository with logging
		final UserRepository userRepository = new UserLogRepository(inMemoryUserRepository);
		
		final ECommerceManager manager = new ECommerceManager(userRepository);
		
		User user = new User("master", "secret");
		user = manager.addUser(user);		
			
		System.out.println(String.format("%s, %s, %s", user.getId(), user.getUsername(), user.getPassword()));
		
		// Adding a user that is already stored will throw an exception
		user = manager.addUser(user);	
	}
}
