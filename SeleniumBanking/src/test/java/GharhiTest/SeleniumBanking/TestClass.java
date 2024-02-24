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
	
	@Before //Creation of new Bank Object
	public void setUp() {
		bank = new Bank("Testone","25337");

	}
	@Test   //Verify that user is able to deposit amount successfully
	public void testDeposit() {
		bank.deposit(2000);
		bank.deposit(250);
		assertEquals(2250, bank.getBalance(),0.0);
	}
	//Verify the ability of user to deposit an invalid amount
	@Test(expected=IllegalArgumentException.class)
	public void invalidDepositTest() {
		bank.deposit(0);
	}
	@Test    //Verify that user is able to deposit amount successfully
	public void testWithdrawal() {
		bank.deposit(15000);
		bank.withdrawal(3500);
		assertEquals(11500, bank.getBalance(),0.0);
	}
	//Verify the ability of user to withdraw an invalid amount
	@Test(expected=IllegalArgumentException.class)
	public void invalidWithdrawalTest() {
		bank.deposit(1500);
		bank.withdrawal(3500);
	}
	@Test //Verify the display account balance function for a valid account number
	public void testAccountBalance() {
		bank.deposit(25000);
		assertTrue(bank.displayAccountBalance("25337").contains("Hi"));
	}
	//Verify the display account balance function for an invalid account number
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidBalanceEnquiry() {
		bank.deposit(25000);
		bank.displayAccountBalance("253");
	}

}
