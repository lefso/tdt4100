package objectstructures;

import java.util.ArrayList;

public class CardDeck {

	int counter = 0;
	private final String SUITS = "SHDC";
	private ArrayList<Card> kortstokk = new ArrayList<>();
	
	public CardDeck(int numberOfCards) {
		for (int i = 0; i < SUITS.length(); i++) {
			for (int j = 1; j < numberOfCards + 1; j++) {
				
				Card card = new Card(SUITS.charAt(i), j);
				this.getCardDeck().add(card);
				this.counter++;
			}
		}
	}
	
	public int getCardCount() {
		return this.getCardDeck().size();
	}
	
	public Card getCard(int n) {
		if (n < 0 || n > 52) {
			throw new IllegalArgumentException();
		}
		return this.getCardDeck().get(n);
	}
	
	public void shufflePerfectly() {
		int i, j, k, l = 0, m = 0;
		Card[] firstHalfDeck = new Card[this.counter / 2];
		Card[] secondHalfDeck = new Card[this.counter / 2];
		
		for (i = 0; i < firstHalfDeck.length; i++) {
			
			if (i < firstHalfDeck.length) {
			firstHalfDeck[i] = this.getCardDeck().get(i);
			}
		}
		
		for (j = 0; j < secondHalfDeck.length; j++) {
			secondHalfDeck[j] = this.getCardDeck().get(i);
			i++;
		}
		
		for (k = 0; k < this.kortstokk.size(); k++) {
			if (k % 2 == 0) {
				this.getCardDeck().set(k, firstHalfDeck[l]);
				l++;
			} else {
				this.getCardDeck().set(k, secondHalfDeck[m]);
				m++;
			}
		}
	}
	
	public ArrayList<Card> getCardDeck() {
		return this.kortstokk;
	}
	
	public void deal(CardHand hand, int n) {
		int count = this.getCardCount();
		for (int i = count - 1; i > count - n - 1; i--) {
			hand.addCard(this.getCard(i));
			this.getCardDeck().remove(this.getCard(i));
			
		}
	}
}
