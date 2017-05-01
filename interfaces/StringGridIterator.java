package interfaces;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {
	
	private boolean rowMajor;
	private boolean hasNext = true;
	private int currentRowIndex;
	private int currentColumnIndex;
	private StringGrid grid;
	
	public StringGridIterator(StringGrid grid, boolean bool) {
		this.grid = grid;
		this.rowMajor = bool;
	}

	@Override
	public boolean hasNext() {
		if (!hasNext) {
			return false;
		}
		return true;
	}

	@Override
	public String next() {
		if (!rowMajor) {
			if (currentRowIndex == grid.getRowCount() - 1) {
				int tempRowIndex = currentRowIndex;
				
				if (currentColumnIndex == grid.getColumnCount() - 1) {
					hasNext = false;
					return grid.getElement(tempRowIndex, currentColumnIndex);
				} else {
					currentRowIndex = 0;
					return grid.getElement(tempRowIndex, currentColumnIndex++);
				}
			}
			return grid.getElement(currentRowIndex++, currentColumnIndex);
		}
		
		if (currentColumnIndex == grid.getColumnCount() - 1) {
			int tempColumnIndex = currentColumnIndex;
			
			if (currentRowIndex == grid.getRowCount() - 1) {
				hasNext = false;
				return grid.getElement(currentRowIndex, tempColumnIndex);
			} else {
				currentColumnIndex = 0;
				return grid.getElement(currentRowIndex++, tempColumnIndex);
			}
		}
		return grid.getElement(currentRowIndex, currentColumnIndex++);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
