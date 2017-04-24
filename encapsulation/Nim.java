package encapsulation;

public class Nim {

	private int[] piles = {0, 0, 0};
	
	public Nim() {
		for (int i = 0; i < piles.length; i++) {
			piles[i] = 10;
		}
	}
	
	public Nim(int pileSize) {
		for (int i = 0; i < piles.length; i++) {
			piles[i] = pileSize;
		}
	}
	
	public void removePieces(int number, int targetPile) {
		if (isGameOver()) {
			throw new IllegalStateException();
		}
		
		if (!isValidMove(number, targetPile)) {
			throw new IllegalArgumentException();
		}
		
		this.setPile(number, targetPile);
	}
	
	public boolean isValidMove(int number, int targetPile) {
		if (isGameOver()) {
			return false;
		}
		
		if (number < 1 || targetPile > 3) {
			return false;
		}
		
		if (this.getPile(targetPile) < number) {
			return false;
		}
		return true;
	}
	
	public boolean isGameOver() {
		for (int i = 0; i < piles.length; i++) {
			if (this.getPile(i) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public int getPile(int targetPile) {
		return piles[targetPile];
	}
	public void setPile(int number, int targetPile) {
		this.piles[targetPile] -= number;
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i < piles.length; i++) {
			str += "Pile " + i + " has " + this.getPile(i) + " pieces.\n";
		}
		return str;
	}
}
