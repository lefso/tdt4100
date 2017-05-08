package inheritance;

public class SavingsAccount implements Account {
	
	protected double balance;
	protected double interest;
	
	public SavingsAccount(double interestRate) {
		this.balance = 0;
		this.interest = interestRate * 100;
	}

	@Override
	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException();
		}
		this.balance += amount;
	}

	@Override
	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException();
		} else if (this.getBalance() - amount < 0) {
			throw new IllegalStateException();
		}
		this.balance -= amount;
	}

	@Override
	public double getBalance() {
		return this.balance;
	}
	
	public void endYearUpdate() {
		this.deposit(this.balance * (interest / 100));
	}

}
