package inheritance;

import java.util.ArrayList;
import java.util.Iterator;

public class CardContainerImpl implements CardContainer {
	
	protected ArrayList<Card> cardContainer = new ArrayList<>();
	private int maxCardCount;
	
	public CardContainerImpl(int maxCardCount) {
		this.maxCardCount = maxCardCount;
	}
	
	public int getMaxCardCount() {
		return this.maxCardCount;
	}

	@Override
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}

	@Override
	public int getCardCount() {
		return this.getCardContainer().size();
	}

	@Override
	public Card getCard(int n) {
		if (n < 0 || n > 52) {
			throw new IllegalArgumentException();
		}
		return this.getCardContainer().get(n);
	}

	@Override
	public ArrayList<Card> getCardContainer() {
		return this.cardContainer;
	}

}
