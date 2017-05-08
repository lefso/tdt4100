package inheritance;

public class CardDeck extends CardContainerImpl {

	int counter = 0;
	private final String SUITS = "SHDC";
	
	public CardDeck(int numberOfCards) {
		super(52);
		for (int i = 0; i < SUITS.length(); i++) {
			for (int j = 1; j < numberOfCards + 1; j++) {
				
				Card card = new Card(SUITS.charAt(i), j);
				this.getCardContainer().add(card);
				this.counter++;
			}
		}
	}
	
	public void shufflePerfectly() {
		int i, j, k, l = 0, m = 0;
		Card[] firstHalfDeck = new Card[this.counter / 2];
		Card[] secondHalfDeck = new Card[this.counter / 2];
		
		for (i = 0; i < firstHalfDeck.length; i++) {
			
			if (i < firstHalfDeck.length) {
			firstHalfDeck[i] = this.getCardContainer().get(i);
			}
		}
		
		for (j = 0; j < secondHalfDeck.length; j++) {
			secondHalfDeck[j] = this.getCardContainer().get(i);
			i++;
		}
		
		for (k = 0; k < this.getCardContainer().size(); k++) {
			if (k % 2 == 0) {
				this.getCardContainer().set(k, firstHalfDeck[l]);
				l++;
			} else {
				this.getCardContainer().set(k, secondHalfDeck[m]);
				m++;
			}
		}
	}
	
	public void deal(CardHand hand, int n) {
		int count = this.getCardCount();
		
		for (int i = count - 1; i > count - n - 1; i--) {
			hand.addCard(this.getCard(i));
			this.getCardContainer().remove(this.getCard(i));
		}
	}
}
