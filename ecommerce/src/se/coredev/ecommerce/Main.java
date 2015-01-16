package se.coredev.ecommerce;

import se.coredev.ecommerce.model.User;
import se.coredev.ecommerce.repository.SqlUserRepository;
import se.coredev.ecommerce.repository.UserRepository;
import se.coredev.ecommerce.service.ECommerceManager;

public class Main
{
	public static void main(String[] args)
	{
		final UserRepository userRepository = new SqlUserRepository();
		final ECommerceManager manager = new ECommerceManager(userRepository);

		User user = new User("yoda", "top-secret");
		user = manager.addUser(user);
		
		System.out.println(String.format("%s, %s, %s", user.getId(), user.getUsername(), user.getPassword()));
		
		
//		User user = new User("master", "secret");
//		
//		user = manager.addUser(user);
//		System.out.println("Add");
//		System.out.println(String.format("%s, %s, %s", user.getId(), user.getUsername(), user.getPassword()));
//
//		User userFromStorage = manager.getUser(1);		
//		System.out.println("Get");
//		System.out.println(String.format("%s, %s, %s", userFromStorage.getId(), userFromStorage.getUsername(), userFromStorage.getPassword()));
//		
//		System.out.println("Update");
//		user = new User(user.getId(), "Yoda", user.getPassword());
//		manager.updateUser(user);
//		user = manager.getUser(user.getId());
//		System.out.println(String.format("%s, %s, %s", user.getId(), user.getUsername(), user.getPassword()));
//		
//		System.out.println("Delete");
//		user = manager.deleteUser(user.getId());
//		System.out.println(String.format("%s, %s, %s", user.getId(), user.getUsername(), user.getPassword()));
//		user = manager.getUser(user.getId());		
	}
}
