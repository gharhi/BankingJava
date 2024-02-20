package GharhiTest.SeleniumBanking;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.Assert;

//import static org.hamcrest.Matchers.*;
//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestClass {
	private Bank bank;
	
	@Before
	public void setUp() {
		bank = new Bank("Testone",25337);

	}
	@Test
	public void testDeposit() {
		bank.deposit(2000);
		assertEquals(2000, bank.getBalance(),0.0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void invalidDepositTest() {
		bank.deposit(0);
	}
	@Test
	public void testWithdrawal() {
		bank.deposit(15000);
		bank.withdrawal(3500);
		assertEquals(11500, bank.getBalance(),0.0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void invalidWithdrawalTest() {
		bank.deposit(1500);
		bank.withdrawal(3500);
	}
	//@Test
	//public void testBalanceEnquiry() {
		//bank.deposit(25000);
		//String expDetails="Hi"+bank.getName()+"Account Balance: "+bank.getBalance();
		//assertTrue(expDetails.equalsIgnoreCase(bank.balanceEnquiry(25337)));
	//}
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidBalanceEnquiry() {
		bank.deposit(25000);
		bank.balanceEnquiry(253);
	}

}
