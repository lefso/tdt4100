package interfaces;

import java.util.ArrayList;
import java.util.Iterator;

public class StringGridImpl implements StringGrid {
	
	private int rows, columnCount;
	private ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
	
	public StringGridImpl(int rows, int columnCount) {
		this.rows = rows;
		this.columnCount = columnCount;
		
		for (int i = 0; i < rows; i++) {
			this.GetGrid().add(new ArrayList<String>());
			for (int j = 0; j < columnCount; j++) {
				this.GetGrid().get(i).add(null);
			}
		}
	}
	
	public ArrayList<ArrayList<String>> GetGrid() {
		return this.grid;
	}

	@Override
	public int getRowCount() {
		return this.rows;
	}

	@Override
	public int getColumnCount() {
		return this.columnCount;
	}

	@Override
	public String getElement(int row, int column) {
		if (row < this.getRowCount() && column < this.getColumnCount()) {
			return this.GetGrid().get(row).get(column);
		}
		throw new IllegalArgumentException();
	}

	@Override
	public void setElement(int row, int column, String element) {
		if (row < this.getRowCount() && column < this.getColumnCount()) {
			this.GetGrid().get(row).add(column, element);
			this.GetGrid().get(row).remove(column + 1); //
		} else {
			throw new IllegalArgumentException();}
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i < getRowCount(); i++) {
			str += this.GetGrid().get(i) + "\n";
		}
		return str;
	}

	@Override
	public Iterator<String> iterator() {
		ArrayList<String> gridArray = new ArrayList<>();
		for (int i = 0; i < this.getRowCount(); i++) {
			gridArray.addAll(grid.get(i));
		}
		return gridArray.iterator();
	}
}
