package inheritance;

public class CardHand extends CardContainerImpl {
	
	public CardHand(int maxCardCount) {
		super(maxCardCount);
	}
	
	public void addCard(Card card) {
		if (this.getCardCount() == this.getMaxCardCount()) {
			throw new IllegalStateException();
		}
		this.getCardContainer().add(card);
	}
	
	public Card play(int n) {
		Card card = this.getCard(n);
		this.getCardContainer().remove(n);
		return card;
	}
}
