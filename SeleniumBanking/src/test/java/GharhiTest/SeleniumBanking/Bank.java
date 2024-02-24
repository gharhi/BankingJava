package GharhiTest.SeleniumBanking;


public class Bank {
	
	private String acName;
	private double balance;
	private String acNum;
	
	public Bank(String acName, String acNum) {
		this.acName = acName;
		this.balance = 0.0;
		this.acNum = acNum;
	}
	

	public String getName() {
		return acName;

	}
	public double getBalance() {
		return balance;
	}
	public String getAccNum() {
		return acNum;
	}
	public String displayAccountBalance(String num) {
		if (acNum.equals(num)) {
			String detail="Hi "+acName+" Account Balance: "+balance;
			System.out.println(detail);
			return detail;
		}else {
			throw new IllegalArgumentException("Invalid Account number entered!");
		}
		
	}
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}else {
			throw new IllegalArgumentException("Deposit amount must be more than 0Rs");
		}
	}
	public void withdrawal(double amount) {
		if(amount>0 && balance>=amount) {
			balance-=amount;
		}else {
			throw new IllegalArgumentException("Invalid withdrawal amount");
		}
	}

}
