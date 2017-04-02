package inheritance;

public class DebitAccount extends AbstractAccount {

	@Override
	public void internalWithdraw(double amount) {
		if ((balance - amount) < 0) {
			throw new IllegalStateException();
		}
		balance -= amount;
	}

}
