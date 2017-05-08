package inheritance;

public class ForeldreSpar extends SavingsAccount {

	private int totalAllowedWithdrawals;
	private int allowedWithdrawals;
	
	public ForeldreSpar(double interestRate, int allowedWithdrawals) {
		super(interestRate);
		this.allowedWithdrawals = allowedWithdrawals;
		this.totalAllowedWithdrawals = allowedWithdrawals;
	}
	
	public int getRemainingWithdrawals() {
		return this.allowedWithdrawals;
	}
	
	public void withdraw(double amount) {
		if (allowedWithdrawals == 0) {
			throw new IllegalStateException();
		}
		super.withdraw(amount);
		this.allowedWithdrawals--;
	}
	
	public void endYearUpdate() {
		super.endYearUpdate();
		this.allowedWithdrawals = this.totalAllowedWithdrawals;
	}
}
