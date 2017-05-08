package inheritance;

import java.util.ArrayList;

public interface CardContainer extends Iterable<Card> {

	public int getCardCount();
	public Card getCard(int n);
	public ArrayList<Card> getCardContainer();
}
