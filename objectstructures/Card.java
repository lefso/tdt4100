package objectstructures;

public class Card {

	private char cardColour;
	private int numberValue;
	private final String SUITS = "SHDC";

	public Card(char cardColour, int numberValue) {
		
		this.cardColour = cardColour;
		this.numberValue = numberValue;
		
		if (!validate()) {
			throw new IllegalArgumentException("Card suit or face has an illegal value.");
		}
		
	}
	
	public boolean validate() {
		
		if (SUITS.indexOf(cardColour) == -1) {
			return false;
		} else if (numberValue < 1 || numberValue > 13) {
			return false;
		}
		return true;
	}
	
	public char getSuit() {
		return this.cardColour;
	}
	
	public int getFace() {
		return this.numberValue;
	}
	
	public String toString() {
		return cardColour + "" + numberValue;
	}
	
	public static void main(String[] args) {
		Card kort = new Card('S', 1);
		
		System.out.println(kort.validate());
		System.out.println(kort);
		System.out.println(kort.SUITS.charAt(0));
	}
}
