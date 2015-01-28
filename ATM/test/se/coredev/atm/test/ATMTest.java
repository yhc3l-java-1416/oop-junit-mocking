package se.coredev.atm.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import se.coredev.atm.ATM;
import se.coredev.atm.ATMCard;
import se.coredev.atm.Bank;
import se.coredev.atm.CardHolderInfo;

@RunWith(MockitoJUnitRunner.class)
public final class ATMTest
{
	// Constant values used in this test
	private final String bankIdentity = "1234-5678-90";
	private final int securityCode = 1234;
	private final long expectedAccountBalance = 1000000L;
	
	@Mock
	private Bank bank;
	@Mock
	private CardHolderInfo cardHolderInfo;
	@Mock
	private ATMCard atmCard;

	@Before
	public void setup()
	{
		// Setup mock behavior
		when(bank.getIdentity()).thenReturn(bankIdentity);
		when(atmCard.getBankIdentity()).thenReturn(bankIdentity);
		when(atmCard.getCardHolderInfo()).thenReturn(cardHolderInfo);
		when(atmCard.verifySecurityCode(securityCode)).thenReturn(true);
		when(bank.checkAccountBalance(cardHolderInfo)).thenReturn(expectedAccountBalance);
	}
	
	@After
	public void tearDown()
	{
		// Reset all mocks 
		reset(bank, cardHolderInfo, atmCard);
	}
	
	@Test
	public void canGetAccountBalance()
	{		
		final ATM atm = new ATM(bank);
		
		final long accountBalance = atm.getBalance(securityCode, atmCard);
		// Assert result from class that is tested
		assertEquals(expectedAccountBalance, accountBalance);
		
		// Verify that expected methods was called on mock objects with correct arguments
		verify(bank).getIdentity();
		verify(atmCard).getBankIdentity();
		verify(atmCard).getCardHolderInfo();
		verify(atmCard).verifySecurityCode(securityCode);
		verify(bank).checkAccountBalance(cardHolderInfo);		
	}
}