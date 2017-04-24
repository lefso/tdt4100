package encapsulation;

import java.util.Stack;
import java.util.function.BinaryOperator;

public class RPNCalc {

	private Stack<Double> numberStack = new Stack<Double>();
	
	public Stack<Double> getNumberStack() {
		return numberStack;
	}

	public void push(double number) {
		this.getNumberStack().push(number);
	}
	
	public double pop() {
		if (this.getNumberStack().isEmpty()) {
			return Double.NaN;
		}
		return this.getNumberStack().pop();
	}
	
	public double peek(int num) {
		if (num < 0) {
			return Double.NaN;
		}
		int index = this.getSize() - num;
		int counter = 1;
		
		for (double number : numberStack) {
			if (counter == index) {
				return number;
			}
			counter++;
		}
		return Double.NaN;
	}
	
	public int getSize() {
		return numberStack.size();
	}
	
	public void performOperation(char operand) {
		BinaryOperator<Double> adder = (n1, n2) -> n1 + n2;
		BinaryOperator<Double> subtracter = (n1, n2) -> n1 - n2;
		BinaryOperator<Double> multiplyer = (n1, n2) -> n1 * n2;
		BinaryOperator<Double> divider = (n1, n2) -> n1 / n2;
		double secondNumber = this.pop();
		double firstNumber = this.pop();
		double result = 0;
		
		if (operand == '+') {
			result = adder.apply(firstNumber, secondNumber);
		} else if (operand == '-') {
			result = subtracter.apply(firstNumber, secondNumber);
		} else if (operand == '*') {
			result = multiplyer.apply(firstNumber, secondNumber);
		} else if (operand == '/') {
			result = divider.apply(firstNumber, secondNumber);
		} else if (operand == '~') {
			this.push(secondNumber);
			this.push(firstNumber);
			return;
		}
		this.push(result);
	}
}
