package se.coredev.ecommerce.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import se.coredev.ecommerce.model.User;

public final class SqlUserRepository implements UserRepository
{

	private static final String CONNECTION_STRING = "jdbc:mysql://127.0.0.1:3306/ecommerce";

	@Override
	public User addUser(final User user) throws RepositoryException
	{
		try (final Connection connection = getConnection())
		{
			connection.setAutoCommit(false);
			try (PreparedStatement stmt = connection.prepareStatement("insert into users values (null, ?, ?, null, null)",
																	  Statement.RETURN_GENERATED_KEYS))
			{
				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getPassword());
				int affectedRows = stmt.executeUpdate();

				if (affectedRows == 1)
				{
					ResultSet rs = stmt.getGeneratedKeys();

					if (rs.next())
					{
						int id = rs.getInt(0);
						connection.commit();
						
						return new User(id, user.getUsername(), user.getPassword());
					}
				}
			}
			catch (SQLException e)
			{
				connection.rollback();
			}
			
			throw new RepositoryException("Could not add user");
		}
		catch (SQLException e)
		{
			throw new RepositoryException("Could not add user", e);
		}
	}
	

	@Override
	public User getUserById(final int userId) throws RepositoryException
	{
		try (final Connection connection = getConnection())
		{
			PreparedStatement stmt = connection.prepareStatement("select * from users where id = ?");
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next())
			{
				String username = rs.getString("username");
				String password = rs.getString("password");

				return new User(userId, username, password);
			}
			throw new RepositoryException("Could not find user with id:" + userId);

		}
		catch (SQLException e)
		{
			throw new RepositoryException("Could not get user with id:" + userId, e);
		}
	}

	@Override
	public User updateUser(final User user) throws RepositoryException
	{
		return null;
	}

	@Override
	public User deleteUser(final int userId) throws RepositoryException
	{
		return null;
	}

	private Connection getConnection() throws RepositoryException
	{
		try
		{
			return DriverManager.getConnection(CONNECTION_STRING, "root", "secret");
		}
		catch (SQLException e)
		{
			throw new RepositoryException("Could not connect to data source", e);
		}
	}

}
