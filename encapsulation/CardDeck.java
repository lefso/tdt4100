package encapsulation;

public class CardDeck {

	int counter = 0;
	private final String SUITS = "SHDC";
	private Card[] kortstokk;
	
	public CardDeck(int numberOfCards) {
		
		this.kortstokk = new Card[numberOfCards * SUITS.length()];
		
		for (int i = 0; i < SUITS.length(); i++) {
			
			for (int j = 1; j < numberOfCards + 1; j++) {
				
				Card card = new Card(SUITS.charAt(i), j);
				this.kortstokk[this.counter] = card;
				this.counter++;
			}
		}
	}
	
	public int getCardCount() {
		return this.counter;
	}
	
	public Card getCard(int n) {
		if (n < 0 || n > 52) {
			throw new IllegalArgumentException();
		}
		return this.kortstokk[n];
	}
	
	public void shufflePerfectly() {
		int i, j, k, l = 0, m = 0;
		Card[] firstHalfDeck = new Card[this.counter / 2];
		Card[] secondHalfDeck = new Card[this.counter / 2];
		
		for (i = 0; i < firstHalfDeck.length; i++) {
			
			if (i < firstHalfDeck.length) {
			firstHalfDeck[i] = this.kortstokk[i];
			}
		}
		
		for (j = 0; j < secondHalfDeck.length; j++) {
			secondHalfDeck[j] = this.kortstokk[i];
			i++;
		}
		
		for (k = 0; k < this.kortstokk.length; k++) {
			if (k % 2 == 0) {
				this.kortstokk[k] = firstHalfDeck[l];
				l++;
			} else {
				this.kortstokk[k] = secondHalfDeck[m];
				m++;
			}
		}
	}
	
	public static void main(String[] args) {
		CardDeck cardDeck = new CardDeck(13);
		
		System.out.println(cardDeck.getCardCount());
		System.out.println(cardDeck.kortstokk[12]);
		System.out.println(cardDeck.getCard(12));
		System.out.println("  ");
		cardDeck.shufflePerfectly();
		System.out.println(cardDeck.getCard(23));
	}
}
