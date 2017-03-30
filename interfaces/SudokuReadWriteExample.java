package interfaces;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class SudokuReadWriteExample implements SudokuReadWrite {
	
	@Override
	public void save(String fileName, String board) {
		
		int counter = 1;
		try {
			PrintWriter saveFile = new PrintWriter(fileName);
			for (int i = 0; i < board.length(); i++) {
				if (Character.isDigit(board.charAt(i)) || board.charAt(i) == '.'
						|| board.charAt(i) == ' ' || board.charAt(i) == '('
						|| board.charAt(i) == ')' || board.charAt(i) == '*') {
					saveFile.print(board.charAt(i));
					if (counter % 3 == 0) {
						saveFile.print(',');
					}
					counter++;
				}
			}
			saveFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load(String fileName, SudokuBrett br) {
		Scanner in;
//		String newBoard = "";
		int counter = 0;
		
		try {
			in = new Scanner(new FileReader(fileName));
			while (in.hasNext()) {
				String line = in.nextLine();
				String[] boardList = line.split(",");
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						String cellContent = boardList[counter];
						br.getCell(i, j).setValue(String.valueOf(cellContent.charAt(1)), String.valueOf(cellContent.charAt(2)));
						counter++;
					}
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
