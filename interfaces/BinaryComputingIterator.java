package interfaces;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double> {
	
	private Iterator<Double> iterator1;
	private Iterator<Double> iterator2;
	private Double default1;
	private Double default2;
	private BinaryOperator<Double> operator;
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.default1 = default1;
		this.default2 = default2;
		this.operator = operator;
	}
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.default1 = null;
		this.default2 = null;
		this.operator = operator;
	}

	@Override
	public boolean hasNext() {
		if (iterator1.hasNext() && iterator2.hasNext()) {
			return true;
		} else if (iterator1.hasNext() && default2 != null) {
			return true;
		} else if (iterator2.hasNext() && default1 != null) {
			return true;
		}
		return false;
	}

	@Override
	public Double next() {
		if (iterator1.hasNext() && iterator2.hasNext()) {
			return operator.apply(iterator1.next(), iterator2.next());
		} else if (iterator1.hasNext() && default2 != null) {
			return operator.apply(iterator1.next(), default2);
		} else if (iterator2.hasNext() && default1 != null) {
			return operator.apply(iterator2.next(), default1);
		}
		return operator.apply(default1, default2);
	}
	
	public static void main(String[] args) {
		Iterator<Double> iterator1 = Arrays.asList(2.0, 3.0).iterator();
		Iterator<Double> iterator2 = Arrays.asList(5.0).iterator();
		BinaryComputingIterator binaryIterator = new BinaryComputingIterator(iterator1, iterator2, null, 10.0, (x, y) -> x + y);
		
		System.out.println(binaryIterator.hasNext());
		System.out.println(binaryIterator.next());
		System.out.println(binaryIterator.hasNext());
		System.out.println(binaryIterator.next());
		System.out.println(binaryIterator.hasNext());
	}

}
