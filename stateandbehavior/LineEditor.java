package stateandbehavior;

public class LineEditor {

	private String text = "";
	private int insertionIndex = 0;
	
	public void left() {
		if (insertionIndex > 0) {
			insertionIndex -= 1;
		}
	}
	
	public void right() {
		if (insertionIndex < text.length()) {
			insertionIndex += 1;
		}
	}
	
	public void insertString(String str) {
		text = text.substring(0, insertionIndex) + str + text.substring(insertionIndex);
		insertionIndex += str.length();
	}
	
	public void deleteLeft() {
		if (insertionIndex != 0) {
			text = text.substring(0, insertionIndex - 1) + text.substring(insertionIndex);
			insertionIndex--;
		}
	}
	
	public void deleteRight() {
		if (insertionIndex != text.length())
		text = text.substring(0, insertionIndex) + text.substring(insertionIndex + 1);
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public int getInsertionIndex() {
		return insertionIndex;
	}
	
	public void setInsertionIndex(int insertionIndex) {
		this.insertionIndex = insertionIndex;
	}
	
	@Override
	public String toString() {
		return text.substring(0, insertionIndex) + "|" + text.substring(insertionIndex);
	}
	
	public static void main(String[] args) {
		LineEditor ld = new LineEditor();
		
		ld.setText("Hei, dette er en test.");
		System.out.println(ld);
		ld.insertString("yo ");
		System.out.println(ld);
	}
}
