package interfaces;

import java.util.Comparator;

public class NamedComparator implements Comparator<Named> {

	@Override
	public int compare(Named named1, Named named2) {
		String lastName1 = named1.getFamilyName();
		String lastName2 = named2.getFamilyName();
		String firstName1 = named1.getGivenName();
		String firstName2 = named2.getGivenName();
		
		if (lastName1.compareTo(lastName2) > 0) {
			return 1;
		} else if (lastName1.compareTo(lastName2) < 0) {
			return -1;
		} else if (lastName1.compareTo(lastName2 ) == 0) {
			
			if (firstName1.compareTo(firstName2) > 0) {
				return 1;
			} else if (firstName1.compareTo(firstName2) < 0) {
				return -1;
			}
		}
		return 0;
	}
}
