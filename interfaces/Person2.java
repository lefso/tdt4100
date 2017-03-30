package interfaces;

public class Person2 implements Named {
	
	String fullName;
	
	public Person2(String fullname) {
		this.fullName = fullname;
	}

	@Override
	public void setGivenName(String givenName) {
		String[] names = fullName.split(" ");
		fullName = givenName + " " + names[1];
	}

	@Override
	public String getGivenName() {
		String[] names = fullName.split(" ");
		return names[0];
	}

	@Override
	public void setFamilyName(String familyName) {
		String[] names = fullName.split(" ");
		fullName = names[0] + " " + familyName;
	}

	@Override
	public String getFamilyName() {
		String[] names = fullName.split(" ");
		return names[1];
	}

	@Override
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String getFullName() {
		return fullName;
	}
	
	public static void main(String[] args) {

		
		NamedComparator com = new NamedComparator();
		
		Named p1 = new Person2("Hallvard Trætteberg");
		Named p2 = new Person2("Jens Trætteberg");
		
		System.out.println(com.compare(p1, p2));
	}

}
