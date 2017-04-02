package inheritance;

public class CreditAccount extends AbstractAccount {

	private double creditLine;
	
	public CreditAccount(double creditLine) {
		if (creditLine < 0) {
			throw new IllegalArgumentException();
		}
		this.creditLine = creditLine;
	}
	
	public double getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(double creditLine) {
		if (creditLine < 0) {
			throw new IllegalArgumentException();
		}
		if ((creditLine + balance) < 0) {
			throw new IllegalStateException();
		}
		this.creditLine = creditLine;
	}

	@Override
	public void internalWithdraw(double amount) {
		if ((creditLine + balance - amount) < 0) {
			throw new IllegalStateException();
		}
		balance -= amount;
	}

}
