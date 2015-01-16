package se.coredev.pattern.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class SQLQueryCommand<T> extends SQLCommand
{
	public Collection<T> executeQuery()
	{
		try (final Connection connection = getConnection())
		{
			// Get query string from subclass
			PreparedStatement statement = connection.prepareStatement(getQueryString());
			
			// Get parameters from subclass. Every key is a parameter index 
			// and every value is a parameter value 
			Map<Integer, Object> parameters = getParameters();
			
			for(Map.Entry<Integer, Object> parameter : parameters.entrySet())
			{
				statement.setObject(parameter.getKey(), parameter.getValue());
			}
			
			Collection<T> result = new ArrayList<>();
			
			ResultSet resultSet = statement.executeQuery();
			
			// Loop result and let subclass handle the mapping from a result set row to a type (User, Product, etc)
			while(resultSet.next())
			{
				result.add(mapRow(resultSet));
			}
			
			return result;
		}
		catch (Exception e)
		{
			throw new RuntimeException("Could not execute query", e);
		}
	}

	// This method will return an empty map by default. 
	// Subclasses will override this method to set parameters if they are needed
	protected Map<Integer, Object> getParameters()
	{
		return new HashMap<Integer, Object>(); 
	}
	
	// Abstract template method to let subclasses handle the mapping from a result set to a type
	protected abstract T mapRow(ResultSet resultSet) throws Exception;
	
	protected abstract String getQueryString();
}












