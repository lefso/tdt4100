package interfaces;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class SudokuBrett extends SudokuReadWriteExample {

	private SudokuRute[][] celle;
	private Stack<Move> undo = new Stack<>();
	private Stack<Move> redo = new Stack<>();
	private Boolean fromStack = false;
	private String str = "";

	//Konstruktøren
	public SudokuBrett(String board) {
		int counter = 0;
		
		//Lager en 9x9 matrise av sudokuruter.
		celle = new SudokuRute[9][9];
		
		//Fyller inn matrisen med informasjonen fra strengen board.
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				String celleVerdi = String.valueOf(board.charAt(counter));
				if (celleVerdi.equals(".")) {
					celleVerdi = " " + celleVerdi + " ";
				} else {
					celleVerdi = "(" + celleVerdi + ")";
				}
				celle[i][j] = new SudokuRute(celleVerdi);
				counter++;
			}
		}
	}
	
	public String getStr() {
		return this.str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	//Henter ut en spesifik rute.
	public SudokuRute getCell(int row, int column) {
		return celle[row][column];
	}
	
	//Sjekker om bruker prøver å endre et opprinnelig tall.
	public boolean validateCell(int row, int column) {
		String thisCellValue = this.getCell(row, column).getValue();
		
		if(thisCellValue.charAt(0) == '(') {
			return false;
		}
		return true;
	}
	
	//Sjekker om inputen fra bruker er gyldig.
	public boolean checkInput(int row, int column, char input) {
		int partRow = (row / 3) * 3;
		int partColumn = (column / 3) * 3;
		
		//Om inputen er '.' så blir alltid inputen korrekt.
		if (input == '.') {
			return true;
		}
		
		//Sjekker kolonnen og raden for like verdier som inputen.
		for (int i = 0; i < 9; i++) {
			if (this.getCell(row, i).getValue().charAt(1) == input) {
				return false;
			} else if (this.getCell(i,  column).getValue().charAt(1) == input) {
				return false;
			}
		}
		
		//Sjekker den relevante 3x3 delen av brettet.
		for (int r = partRow; r < partRow + 3; r++) {
			for (int c = partColumn; c < partColumn + 3; c++) {
				if (this.getCell(r, c).getValue().charAt(1) == input) {
					return false;
				}
			}
		}
		return true;
	}
	
	//Tar input fra bruker, validerer og fyller inn brettet.
	public void getInput(String value) {
		char firstDigit, secondDigit, thirdDigit;

		if (value.equals("undo")) {
			undo();
			return;
		} else if (value.equals("redo")) {
			redo();
			return;
		} else if (value.startsWith("save")) {
			String fileName = value.split(" ")[1];
			System.out.println(fileName);
			save(fileName, str);
			return;
		} else if (value.startsWith("load")) {
			String fileName = value.split(" ")[1];
			load(fileName, this);
			return;
		}
		
		//Sjekker lengden på inputen for å vite om et tall eller et punktum skal brukes, og for å gi verdier til koordinatene.
		if(value.length() == 3) {
			firstDigit = value.charAt(0);
			secondDigit = value.charAt(1);
			thirdDigit = value.charAt(2);
		} else if (value.length() == 2) {
			firstDigit = value.charAt(0);
			secondDigit = value.charAt(1);
			thirdDigit = '.';
		} else {
			throw new IllegalArgumentException("Feil lengde på input.");
		}
		
		//Gjør om koordinatene fra char til heltall (gjør også at spilleren slipper å tenke på nullindexering. derav 49 og ikke 48).
		int firstDigitNumber = (int) firstDigit - 49;
		int secondDigitNumber = (int) secondDigit - 49;
		
		char originalVerdi = getCell(firstDigitNumber, secondDigitNumber).getValue().charAt(1);
		
		//Sjekker om cellen og inputen er gyldig før verdien til cellen oppdateres.
		if (!validateCell(firstDigitNumber, secondDigitNumber)) {
			System.out.println("Kan ikke endre opprinnelige tall.");
		} else if (checkInput(firstDigitNumber, secondDigitNumber, thirdDigit)) {
			this.getCell(firstDigitNumber, secondDigitNumber).setValue(String.valueOf(thirdDigit), " ");
			if (!fromStack) {
				fillStack(firstDigit, secondDigit, originalVerdi, value);
			}
		} else if (value.length() == 3) {
			this.getCell(firstDigitNumber, secondDigitNumber).setValue(String.valueOf(thirdDigit), "*");
			if (!fromStack) {
				fillStack(firstDigit, secondDigit, originalVerdi, value);
			}
		}
	}
	
	public void fillStack(char firstDigit, char secondDigit, char originalVerdi, String value) {
		Move last = new Move();
		
		last.originalMove = "" + firstDigit + secondDigit + originalVerdi;
		last.newMove = value;
		undo.push(last);
	}
	
	//Sjekker om spilleren har vunnet.
	public boolean isGameOver() {
		int summationRow = 0;
		int summationCol = 0;
//		int row = 0;
//		int column = 0;
//		int partRow = (row / 3) * 3;
//		int partColumn = (column / 3) * 3;
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
				//Tester om summen av hver rad og kolonne blir 45. (dvs inneholder tallene 1-9), og at alle tall er gyldige.
				if(this.getCell(i, j).getValue().charAt(1) == '.') {
					return false;
				} else if (this.getCell(i, j).getValue().charAt(2) == '*') {
					return false;
				}
				else {
					summationRow += (int) this.getCell(i, j).getValue().charAt(1) - 48;
					summationCol += (int) this.getCell(j, i).getValue().charAt(1) - 48;
				}
				
				//Om summen er 45 og enden av brettet er nådd begynner telleren på nytt.
				if (j == 8 && summationRow == 45) {
					summationRow = 0;
				} else if (j == 8 && summationRow != 45) {
					return false;
				}
				
				if (j == 8 && summationCol == 45) {
					summationCol = 0;
				} else if (j == 8 && summationCol != 45) {
					return false;
				}
			}
		}
		return true;
	}
	
	//Printer ut spillebrettet.
	public String toString() {
		String linje = "+---------+---------+---------+";
		String newLine = "\n";
		str = linje + newLine;
		int counterI = 0;
		int counterJ = 0;
		
		//Bruker modulo til å legge til "rammen" rundt spillebrettet.
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (counterJ % 3 == 0) {
					str += "|";
				}
				
				str += this.getCell(i, j);
				
				counterJ++;
			}
			str += "|\n";
			counterI++;
			if (counterI % 3 == 0) {
				str += linje + newLine;
			}
			
		}
		
		//Sjekker om spillet er over og legger til en gratulasjonsmelding om spilleren har vunnet.
		if (isGameOver()) {
			str += "Gratulerer, du løste sudokuen!";
		} 
		return str;
	}
	
	//Lar brukeren angre på et trekk.
	public void undo() {
		if(undo.empty() == true) {
			System.out.println("Kan ikke angre.");
			return;
		}
		Move last = undo.pop();
		redo.push(last);
		fromStack = true;
		this.getInput(last.originalMove);
		fromStack = false;
	}
	
	//lar brukeren angre på et angre-trekk.
	public void redo() {
		if(redo.empty() == true) {
			System.out.println("Kan ikke gjenta.");
			return;
		}
		Move last = redo.pop();
		undo.push(last);
		fromStack = true;
		this.getInput(last.newMove);
		fromStack = false;
		
	}
	
//	public void save(String fileName) {
//		
//		try {
//			PrintWriter saveFile = new PrintWriter("saveFile.txt");
//			saveFile.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public void load(String fileName) {
//		
//	}
	
	public static void main(String[] args) {
		String ferdig = "4689257132391768545714839626143592789852173467238641953476925811527486398965314..";
		SudokuBrett brett = new SudokuBrett(".68.257.3..........71..39..61.35.2...8.....4...3.64.95..76..58..........8.653.42.");
//		SudokuBrett brett = new SudokuBrett(ferdig);
		
//		brett.getInput("293");
		System.out.println(brett);

		Scanner scan = new Scanner(System.in);
		while (!brett.isGameOver()) {
			System.out.print("Enter coordinates: ");
			String input = scan.nextLine();
			brett.getInput(input);
			System.out.println(brett);
			System.out.println("UndoStack: " + brett.undo);
			System.out.println("RedoStack: " + brett.redo);
		}
		scan.close();
		
		
//		Move last = new Move();
//		Stack<Move> test = new Stack<>();
//		last.lastMove = "hei";
//		test.push(last);
//		last.lastMove = "ho";
//		test.push(last);
//		
//		System.out.println(test);
	}
}
