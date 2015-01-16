package se.coredev.pattern.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLCommand
{
	private static final String CONNECTION_STRING = "jdbc:mysql://127.0.0.1:3306/ecommerce";

	protected Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(CONNECTION_STRING, "root", "secret");
	}
}
