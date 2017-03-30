package objectstructures;


import interfaces.SudokuBrett;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class GameController {
	
	
	@FXML
	TextArea console ; 
	
	@FXML
	TextField inputField ; 
	
	//Her maa du deklarerere spillet ditt dersom det heter noe annet enn TicTacToe
	SudokuBrett game ; 
	
	public void initialize(){
		//Her maa du opprette et objekt av spillet ditt med de argumentene som behoves for det - resten av koden vil gaa ut ifra at du har kalt den game
		game = new SudokuBrett(".68.257.3..........71..39..61.35.2...8.....4...3.64.95..76..58..........8.653.42.") ; 
//		game = new SudokuBrett("4689257132391768545714839626143592789852173467238641953476925811527486398965314..") ;
		console.setFont(Font.font("Monospace"));
		console.setText(game.toString());
	}
	
	
	@FXML
	public void sendInput(){
		String in = inputField.getText(); 
		System.out.println(in);
		//Denne metoden kan hete hva som helst, men husk aa endre det her
		game.getInput(in); 
		console.setText(game.toString());
		
	}
}
