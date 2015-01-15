package se.coredev.ecommerce.repository;

import se.coredev.ecommerce.model.User;

public final class UserLogRepository implements UserRepository
{
	private UserRepository userRepository;

	public UserLogRepository(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	@Override
	public void addUser(User user)
	{
		System.out.println(String.format("[Before addUser] Arguments:Id:%s, Username:%s, Password:[hidden]", user.getId(), user.getUsername()));
		userRepository.addUser(user);
		System.out.println(String.format("[After addUser] Arguments:Id:%s, Username:%s, Password:[hidden]", user.getId(), user.getUsername()));
	}
}
