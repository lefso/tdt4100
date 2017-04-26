package objectstructures;

import java.util.ArrayList;

public class CardHand {

	private ArrayList<Card> hand = new ArrayList<>();
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public int getCardCount() {
		return this.getHand().size();
	}
	
	public Card getCard(int index) {
		return this.getHand().get(index);
	}
	
	public void addCard(Card card) {
		this.getHand().add(card);
	}
	
	public Card play(int n) {
		Card card = this.getCard(n);
		this.getHand().remove(n);
		return card;
	}
	
	public static void main(String[] args) {
		CardDeck deck = new CardDeck(10);
		CardHand hand = new CardHand();
		deck.deal(hand, 3);
		System.out.println(hand.getCardCount());
	}
}
