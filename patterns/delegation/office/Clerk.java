package patterns.delegation.office;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Clerk implements Employee {
	
	private Printer printer;
	private int calculations; //Teller hvor mange kalkulasjoner clerken har gjort.
	private List<String> documents = new ArrayList<>();
	
	public Clerk(Printer printer) {
		this.printer = printer;
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		double calculation = operation.apply(value1, value2);
		calculations++;
		return calculation;
	}

	@Override
	public void printDocument(String document) {

		printer.printDocument(document, this);
		calculations++;
	}

	@Override
	public int getTaskCount() {
		return calculations;
	}

	@Override
	public int getResourceCount() {
		return 1;
	}
	
	public List<String> getDocuments() {
		return documents;
	}
	
	public void setDocuments(String document) {
		documents.add(document);
	}

}
