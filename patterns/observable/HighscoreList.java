package patterns.observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighscoreList {
	
	int maxSize;
	List<Integer> results = new ArrayList<>();
	ArrayList<HighscoreListListener> listeners = new ArrayList<>();
	
	public HighscoreList(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public int size() {
		return this.getResults().size();
	}
	
	public Integer getElement(int index) {
		return this.getResults().get(index);
	}
	
	public void addResult(int newResult) {
		int newElementIndex = 0;
			if (this.getMaxSize() > this.size()) {
				this.getResults().add(newResult);
				Collections.sort(this.getResults());
			} 
			else if (this.getElement(this.size() - 1) > newResult) {
				this.getResults().remove(this.size() - 1);
				this.getResults().add(newResult);
				Collections.sort(this.getResults());
			}
		if (this.getResults().contains(newResult)) {
			for (Integer result : this.getResults()) {
				if (result != newResult) {
					newElementIndex++;
				} else {
					break;
				}
			}
			if (newElementIndex != this.size() - 1) {
				for (int i = newElementIndex + 1; i < this.size() - 1; i++) {
					if (this.getElement(i) == newResult) {
						newElementIndex++;
					} else {
						break;
					}
				}
			}
			for (HighscoreListListener listener : listeners) {
				listener.listChanged(this, newElementIndex);
			}
		}
	}

	public int getMaxSize() {
		return this.maxSize;
	}

	public List<Integer> getResults() {
		return this.results;
	}
	
	public ArrayList<HighscoreListListener> getListeners() {
		return listeners;
	}

	public void addHighscoreListListener(HighscoreListListener listener) {
		if (!this.getListeners().contains(listener)) {
			this.getListeners().add(listener);
		}
	}
	
	public void removeHighscoreListListener(HighscoreListListener listener) {
		if (this.getListeners().contains(listener)) {
			this.getListeners().remove(listener);
		}
	}
}
