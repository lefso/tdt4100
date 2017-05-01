package interfaces;

import java.util.Comparator;

public class CardComparator implements Comparator<Card>{
	
	private boolean bool;
	private char trumph;
	
	public CardComparator(boolean bool, char trumph) {
		this.bool = bool;
		this.trumph = trumph;
	}

	@Override
	public int compare(Card card1, Card card2) {
		card1.setBool(bool);
		card2.setBool(bool);
		card1.setTrumph(trumph);
		card2.setTrumph(trumph);

		return card1.compareTo(card2);
	}
}
