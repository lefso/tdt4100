package inheritance;

public class BSU extends SavingsAccount {

	private double allowedDeposit;
	private double currentYearDeposit;
	
	public BSU(double interestRate, double allowedDeposit) {
		super(interestRate);
		this.allowedDeposit = allowedDeposit;
		this.currentYearDeposit = 0;
	}
	
	public void deposit(double amount) {
		if (this.currentYearDeposit + amount > this.allowedDeposit) {
			throw new IllegalStateException();
		}
		super.deposit(amount);
		this.currentYearDeposit += amount;
	}
	
	public void withdraw(double amount) {
		if (this.currentYearDeposit - amount < 0) {
			throw new IllegalStateException();
		}
		super.withdraw(amount);
	}
	
	public double getTaxDeduction() {
		return this.currentYearDeposit * 0.2;
	}
	
	public void endYearUpdate() {
		super.endYearUpdate();
		this.currentYearDeposit = 0;
	}
}
