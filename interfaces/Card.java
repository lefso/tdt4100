package interfaces;

public class Card implements Comparable<Card> {

	private char cardColour;
	private int numberValue;
	private final String SUITS = "SHDC";
	private boolean bool;
	private char trumph;

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
	
	public void setBool(boolean bool) {
		this.bool = bool;
	}
	public void setTrumph(char trumph) {
		this.trumph = trumph;
	}
	
	public char getTrumph() {
		return this.trumph;
	}
	
	@Override
	public int compareTo(Card card) {
		Integer thisFace = this.getFace();
		Integer cardFace = card.getFace();
		
		if (this.getSuit() == this.getTrumph() && card.getSuit() != this.getTrumph()) {
			return 1;
		} else {
			if (this.getSuit() == 'S' && card.getSuit() != 'S') {
				return 1;
			} else if (this.getSuit() == 'H' && (card.getSuit() != 'S' && card.getSuit() != 'H')) {
				return 1;
			} else if (this.getSuit() == 'D' && card.getSuit() == 'C') {
				return 1;
			}
		
			if (card.getSuit() == 'S' && this.getSuit() != 'S') {
				return -1;
			} else if (card.getSuit() == 'H' && (this.getSuit() != 'S' && this.getSuit() != 'H')) {
				return -1;
			} else if (card.getSuit() == 'D' && this.getSuit() == 'C') {
				return -1;
			}
		}
		
		if (bool) {
			return cardFace.compareTo(thisFace);
		}
		
		return thisFace.compareTo(cardFace);
	}
	
	public static void main(String[] args) {
		Card kort = new Card('S', 1);
		
		System.out.println(kort.validate());
		System.out.println(kort);
		System.out.println(kort.SUITS.charAt(0));
	}

}
