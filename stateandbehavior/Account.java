package stateandbehavior;

//Teori
//1.
//Metodene kan sies å være en fullstendig innkapsling av tilstanden til objektet siden de lar oss endre
//eller hente alle data i objektet uten å direkte gå inn i objektet selv. Vi må bruke metodene.
//2.
//

public class Account {

	//public Account {
	double balance;
	double interestRate;
	
	public void deposit(double amount) {
		if (amount >= 0) {
			balance += amount;
		} else {
			System.out.println("The amount must be positive.");
		}
	}
	
	public void addInterest() {
		double rente = (interestRate / 100) * balance;
		balance += rente;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double value){
		interestRate = value;
	}
	
	public String toString() {
		String rate = "Renten til den nye kontoen er: " + this.getInterestRate();
		String balanse = "Balansen til den nye kontoen er: " + this.getBalance();
		return rate + "\n" + balanse;
	}
	
	public static void main(String[] args) {
		Account account1 = new Account();
		
		account1.deposit(1000);
		account1.setInterestRate(5);
		account1.addInterest();
		account1.getBalance();
		account1.getInterestRate();
		System.out.println(account1);
	}
}
