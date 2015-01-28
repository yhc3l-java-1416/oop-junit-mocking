package se.coredev.atm;

public interface Bank
{
	String getIdentity();

	long checkAccountBalance(CardHolderInfo cardHolderInfo);
}
