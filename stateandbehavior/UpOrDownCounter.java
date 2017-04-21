package stateandbehavior;

public class UpOrDownCounter {
	
	private int end, counter;

	public UpOrDownCounter(int start, int end) {
		if (start == end) {
			throw new IllegalArgumentException();
		}
		this.counter = start;
		this.end = end;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public boolean count() {
		boolean changed = false;
		if (counter < end) {
			counter++;
			changed = true;
		} else if (counter > end) {
			counter--;
			changed = true;
		}
		
		if (counter == end) {
			changed = false;
		}
		return changed;
	}
}
