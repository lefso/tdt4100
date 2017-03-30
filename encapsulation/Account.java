package encapsulation;

//Teori
//1.	Metodene kan sies å være en komplett innkapsling av tilstanden
//		fordi en er nødt til å bruke metodene for å få tilgang til dataene
//		inne i metodene.

//2. 	Denne klassen er data-orientert siden vi hovedsakelig har getter
// 		setter metoder som ikke beregner stort på og med dataene de har.

public class Account {
	
	private double interestRate;
	private double balance;
	

	public Account(double startBeløp, double interestRate) {
		
		if (startBeløp >= 0 && interestRate >= 0) {
			this.balance = startBeløp;
			this.interestRate = interestRate;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		if (interestRate >= 0) {
			this.interestRate = interestRate;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public void deposit(double amount) {
		if (amount >= 0) {
			this.balance += amount;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public void withdraw(double amount) {
		if (amount >= 0 && this.balance > amount) {
			this.balance -= amount;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public void addInterest() {
		double rente = (interestRate / 100) * balance;
		balance += rente;
	}
}
