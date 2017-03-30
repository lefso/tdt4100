package objectstructures;

public class Partner {

	private String name;
	private Partner partner;
	
	public Partner(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Partner getPartner() {
		return this.partner;
	}
	
	public void setPartner(Partner p2) {
		//Sjekker om partneren til den som kaller funksjonen er den man prøver å sette partneren til
		//for å kunne stoppe rekursjonen.
		if (this.partner == p2) {
			System.out.println("1");
			return;
		}
		
		//lager et nytt Partnerobjekt for å lagre den nåværende partneren.
		Partner oldPartner = this.partner;
		System.out.println("Old: " + oldPartner);
		this.partner = p2;
		
		//Sjekker om det allerede er en kobling for å kunne koble fra.
		if (oldPartner != null && oldPartner.getPartner() == this) {
			System.out.println("2");
			oldPartner.setPartner(null);
		}
		
		//Setter partneren til dette objektet til dette objektet.
		if (this.partner != null) {
			System.out.println("3");
			this.partner.setPartner(this);
		}
		
	}
	
	public String toString() {
		String str = "" + this.name;
		return str;
	}
	
	public static void main(String[] args) {
		Partner p1 = new Partner("p1");
		Partner p2 = new Partner("p2");
		Partner p3 = new Partner("p3");
		Partner p4 = new Partner("p4");
		
		
//		p1.setPartner(p2);
//		System.out.println(p1.getPartner());
//		System.out.println(p2.getPartner());
//		p1.setPartner(null);
//		System.out.println(p1.getPartner());
//		System.out.println(p2.getPartner());
		
		p1.setPartner(p2);
//		p3.setPartner(p4);
//		System.out.println(p1.getPartner());
//		System.out.println(p3.getPartner());
//		p1.setPartner(p3);
//		System.out.println(p1.getPartner());
//		System.out.println(p2.getPartner());
//		System.out.println(p3.getPartner());
//		System.out.println(p4.getPartner());
	}
}
