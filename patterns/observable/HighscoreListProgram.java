package patterns.observable;

import java.util.Scanner;

public class HighscoreListProgram implements HighscoreListListener {
	
	HighscoreList liste;
	
	public void init() {
		HighscoreList liste = new HighscoreList(5);
		liste.addHighscoreListListener(this);
	}
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		scan.close();
		Integer inputAsInteger = Integer.valueOf(input).intValue();
		System.out.println(inputAsInteger);
		liste.addResult(4);
//		liste.addResult(inputAsInteger);
	}
	
	@Override
	public void listChanged(HighscoreList list, int index) {
		System.out.println(list + "\n" + "index: " + index);

	}
	
	public static void main(String[] args) {
		HighscoreListProgram prog = new HighscoreListProgram();
		prog.init();
		prog.run();
	}

}
