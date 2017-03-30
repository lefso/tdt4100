package patterns.delegation.office;

import java.util.List;

public class Printer {
	
	public void printDocument(String document, Employee employee) {
		System.out.println(document);
		
		if (employee instanceof Clerk) {
			((Clerk) employee).setDocuments(document);
		}
	}
	
	public List<String> getPrintHistory(Employee employee) {
		if (employee instanceof Clerk) {
			return ((Clerk) employee).getDocuments();
		}
		return null;
	}
}
