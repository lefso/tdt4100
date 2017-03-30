package encapsulation;

public class Vehicle {
	
	private final char kj�ret�y;
	private final char drivstoff;
	private String regnummer;
	
	public Vehicle(char kj�ret�y, char drivstoff, String regnummer) {
		
		this.kj�ret�y = kj�ret�y;
		this.drivstoff = drivstoff;
		this.regnummer = regnummer;
		
		if (!validateKj�ret�y()) {
			throw new IllegalArgumentException();
		} else if (!validateDrivstoff()) {
			throw new IllegalArgumentException();
		} else if (!validateRegnummer(regnummer)) {
			throw new IllegalArgumentException();
		}
	}
	
	public boolean validateKj�ret�y() {
		
		return (kj�ret�y == 'M' || kj�ret�y == 'C');
	}
	
	public boolean validateDrivstoff() {
		
		if ("HEDG".indexOf(drivstoff) == -1) {
			return false;
		} else if (drivstoff == 'H' && kj�ret�y != 'C') {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean validateRegnummer(String regnummer) {
		
		String[] skiltbokstaver = {"EL", "EK", "HY"};
		
		boolean verdi = true;
		int counterInt = 0;
		int counterLet = 0;
		for (int i = 0; i < regnummer.length(); i++) {
			
			char letter = regnummer.charAt(i);
			
			if (i == 2 && counterInt > 0) {
				verdi = false;
				break;
			}
			
			if (letter > 48 && letter < 58) {
				counterInt++;
			} else if (letter > 64 && letter < 91) {
				counterLet++;
			}
			
			if (letter == '�' || letter == '�' || letter == '�') {
				verdi = false;
				break;
			}
		}
		
		if (counterLet != 2) {
			verdi = false;
		}
		
		if ((kj�ret�y == 'C' && counterInt != 5) || (kj�ret�y == 'M' && counterInt != 4)) {
			verdi = false;
		}
		
		if ((drivstoff == 'E' && !(regnummer.startsWith("EL"))) && (drivstoff == 'E' && !(regnummer.startsWith("EK")))) {
			verdi = false;
		} else if (drivstoff == 'H' && !regnummer.startsWith("HY")) {
			verdi = false;
		}
		
		for (int i = 0; i < skiltbokstaver.length;i++) {
			if ((drivstoff == 'D' || drivstoff == 'G') && regnummer.contains(skiltbokstaver[i])) {
				return false; 
			}
		}
		return verdi;
	}
	
	public char getFuelType() {
		return this.drivstoff;
	}
	
	public String getRegistrationNumber() {
		return this.regnummer;
	}
	
	public void setRegistrationNumber(String regnummer) {
		
		if (validateRegnummer(regnummer)) {
			this.regnummer = regnummer;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public char getVehicleType() {
		return this.kj�ret�y;
	}
}
