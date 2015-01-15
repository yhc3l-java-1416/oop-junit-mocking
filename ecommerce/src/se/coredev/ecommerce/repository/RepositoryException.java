package se.coredev.ecommerce.repository;

public final class RepositoryException extends Exception
{
	private static final long serialVersionUID = 1914695986368216227L;
	
	public RepositoryException(String message, Throwable throwable)
	{
		super(message, throwable);
	}

}
