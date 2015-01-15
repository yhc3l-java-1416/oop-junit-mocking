package se.coredev.ecommerce.service;

public final class ECommerceManagerException extends RuntimeException
{
	private static final long serialVersionUID = -5799461564279238082L;

	public ECommerceManagerException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ECommerceManagerException(String message)
	{
		super(message);
	}
}
