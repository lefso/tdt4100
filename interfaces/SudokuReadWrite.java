package interfaces;

public interface SudokuReadWrite {

	void save(String fileName, String board);
	void load(String fileName, SudokuBrett board);
}
