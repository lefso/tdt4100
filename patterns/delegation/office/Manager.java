package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
	
	private Collection<Employee> employees = new ArrayList<>();
	
	public Manager(Collection<Employee> employees) {
		if (!employees.isEmpty()) {
			this.employees = employees;
		} else {
			throw new IllegalArgumentException();
		}	
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		Employee worker = employees.iterator().next();
		return worker.doCalculations(operation, value1, value2);
	}

	@Override
	public void printDocument(String document) {
		Employee worker = employees.iterator().next();
		worker.printDocument(document);
	}

	@Override
	public int getTaskCount() {
		Iterator<Employee> iterator = employees.iterator();
		int taskCount = 0;
		
		while (iterator.hasNext()) {
			Employee worker = iterator.next();
			taskCount += worker.getTaskCount();
		}
		return taskCount;
	}

	@Override
	public int getResourceCount() {
		Iterator<Employee> iterator = employees.iterator();
		int resourceCount = 0;
		
		while (iterator.hasNext()) {
			Employee worker = iterator.next();
			resourceCount += worker.getResourceCount();
		}
		
		return resourceCount + 1; //Legger til én slik at manageren som kaller metoden blir telt med.
 	}
	
	public static void main(String[] args) {
		Clerk c1 = new Clerk(new Printer());
		Clerk c2 = new Clerk(new Printer());
		Collection<Employee> col = new ArrayList<>();
		col.add(c1);
		col.add(c2);
		Manager leader = new Manager(col);
		
		Collection<Employee> col2 = new ArrayList<>();
		col2.add(leader);
		
		leader.printDocument("hey");
		
		System.out.println( (double) leader.getTaskCount() / leader.getResourceCount());
		
		Manager leader2 = new Manager(col2);
				
		System.out.println( (double) leader2.getTaskCount() / leader2.getResourceCount());
	}

}
