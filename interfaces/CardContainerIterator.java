package interfaces;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card> {
	private int currentIndex = 0;
	private CardContainer cardContainer;

	public CardContainerIterator(CardContainer cardContainer) {
		this.cardContainer = cardContainer;
	}
	
	public CardContainer getCardContainer() {
		return this.cardContainer;
	}
	
	@Override
	public boolean hasNext() {
		return currentIndex < this.getCardContainer().getCardCount() && getCardContainer().getCard(currentIndex) != null;
	}

	@Override
	public Card next() {
		return this.getCardContainer().getCard(currentIndex++);
	}
	
	
}
