package se.coredev.atm;

public class ATMCard
{
	private final String bankIdentity;
	private final int securityCode;
	private final CardHolderInfo cardHolderInfo;

	public ATMCard(String bankIdentity, CardHolderInfo cardHolderInfo, int securityCode)
	{
		this.bankIdentity = bankIdentity;
		this.cardHolderInfo = cardHolderInfo;
		this.securityCode = securityCode;
	}

	public String getBankIdentity()
	{
		return bankIdentity;
	}

	public boolean verifySecurityCode(int securityCode)
	{
		return this.securityCode == securityCode;
	}

	public CardHolderInfo getCardHolderInfo()
	{
		return cardHolderInfo;
	}
}
