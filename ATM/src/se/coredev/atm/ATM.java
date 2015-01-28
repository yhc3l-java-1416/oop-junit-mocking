package se.coredev.atm;

import java.util.HashMap;
import java.util.Map;

public class ATM
{
	private Map<String, Bank> banks;

	public ATM(Bank... banks)
	{
		this.banks = new HashMap<>();
		
		for (Bank bank : banks)
		{
			this.banks.put(bank.getIdentity(), bank);
		}
	}

	public long getBalance(int securityCode, ATMCard card)
	{
		if (card.verifySecurityCode(securityCode))
		{
			Bank bank = banks.get(card.getBankIdentity());

			long accountBalance = bank.checkAccountBalance(card.getCardHolderInfo());

			return accountBalance;
		}

		return -1;
	}

}
