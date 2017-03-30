package interfaces;

public class Person1 implements Named {
	
	String givenName;
	String familyName;
	
	public Person1(String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName;
	}

	@Override
	public void setGivenName(String givenName) {
		this.givenName = givenName;

	}

	@Override
	public String getGivenName() {
		return givenName;
	}

	@Override
	public void setFamilyName(String familyName) {
		this.familyName = familyName;

	}

	@Override
	public String getFamilyName() {
		return familyName;
	}

	@Override
	public void setFullName(String fullName) {
		String[] names = fullName.split(" ");
		String firstName = names[0];
		String lastName = names[1];
		
		this.givenName = firstName;
		this.familyName = lastName;

	}

	@Override
	public String getFullName() {
		return givenName + " " + familyName;
	}
}
