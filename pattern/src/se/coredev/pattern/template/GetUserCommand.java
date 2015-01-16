package se.coredev.pattern.template;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import se.coredev.pattern.model.User;

public final class GetUserCommand extends SQLQueryCommand<User>
{
	private final String username;
	
	public GetUserCommand(String username)
	{
		this.username = username;
	}
	
	@Override
	protected User mapRow(ResultSet rs) throws Exception
	{
		// Creates a User from a row in a result set
		return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
	}

	@Override
	protected Map<Integer, Object> getParameters()
	{
		// Sets parameters that will be used in super class
		Map<Integer, Object> parameter = new HashMap<>();
		parameter.put(1, username);
		
		return parameter;
	}

	@Override
	protected String getQueryString()
	{
		// returns the query to be executed
		return "select * from users where username = ?";
	}

}
