package stateandbehavior;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DigitController {

	Digit digit;

	@FXML
	//Her brukes klassen Digit ved at det blir laget et nytt objekt.
	void initialize() {
		digit = new Digit(10);
		updateView();
	}
	
	@FXML
	Text toStringOutput;
		
	void updateView() {
		//Her brukes toString metoden.
		toStringOutput.setText(digit.toString());
	}
	
	@FXML
	//Her brukes increment metoden.
	void handleIncrement() {
		digit.increment();
		updateView();
	}
	
	@FXML
	TextField baseInput;
	
	@FXML
	//Her settes en ny verdi for Tallsystem.
	void handleNewDigitBase() {
		digit = new Digit(Integer.valueOf(baseInput.getText()));
		updateView();
	}
}
