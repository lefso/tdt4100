package stateandbehavior;

public class Digit {

	int tallSystem;
	int sifferVerdi;
	
	public Digit(int startVerdi) {
		tallSystem = startVerdi;
		sifferVerdi = 0;
	}
	
	public int getValue() {
		return sifferVerdi;
	}
	
	public boolean increment() {
		sifferVerdi += 1;
		if (sifferVerdi == tallSystem) {
			sifferVerdi = 0;
			return true;
		} else {
			return false;
		}
	}
	
	public int getBase() {
		return tallSystem;
	}
	
	public String toString() {
		if (sifferVerdi >= 10) {
			String[] letters = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
			return letters[sifferVerdi - 10];
		}
		
		return Integer.toString(sifferVerdi);
	}
	
	public static void main(String[] args) {
		Digit tall = new Digit(3);
		
		System.out.println(tall.getBase());
		System.out.println(tall.getValue());
		tall.increment();
		tall.increment();
		System.out.println(tall.toString());
		tall.increment();
		System.out.println(tall.toString());
	}
	
}
