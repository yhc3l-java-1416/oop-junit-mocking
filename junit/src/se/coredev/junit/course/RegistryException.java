package se.coredev.junit.course;

public final class RegistryException extends RuntimeException
{
	private static final long serialVersionUID = 1766729565749861935L;

	public RegistryException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RegistryException(String message)
	{
		super(message);
	}
}
