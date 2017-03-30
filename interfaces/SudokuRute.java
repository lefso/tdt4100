package interfaces;

public class SudokuRute {

	private String value;
	
	public SudokuRute(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value, String sign) {
		if (sign.equals(")")) {
			this.value = "(" + value + sign;
		} else {
			this.value = " " + value + sign;
		}
	}
	
	public static void main(String[] args) {
		SudokuRute rute = new SudokuRute(".");
		System.out.println(rute.value);
		System.out.println(rute.getValue());
	}
	
	public String toString() {
		return "" + value;
	}
}
