package se.coredev.pattern;

import java.util.Collection;

import se.coredev.pattern.model.User;
import se.coredev.pattern.template.GetUserCommand;

public final class Main
{
	public static void main(String[] args)
	{
		GetUserCommand query = new GetUserCommand("master");
		Collection<User> users = query.executeQuery();
		
		for(User user : users)
		{
			System.out.println(String.format("%s, %s, %s", user.getId(), user.getUsername(), user.getPassword()));
		}
	}
}
