package objectstructures;

import java.util.ArrayList;

public class Person {

	private String name;
	private char gender;
	private Person mother, father;
	private ArrayList<Person> children = new ArrayList<>();
	
	public Person(String name, char gender) {
		this.name = name;
		if (gender == 'M' || gender == 'F') {
			this.gender = gender;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public Person getMother() {
		return mother;
	}
	
	public void setMother(Person mother) {
		if (mother.getGender() == 'M' || mother == this) {
			throw new IllegalArgumentException();
		}
		if (this.getMother() != null) {
			this.getMother().removeChild(this);
		}
		
		this.mother = mother;
		mother.addChild(this);
	}
	
	public Person getFather() {
		return father;
	}
	
	public void setFather(Person father ) {
		if (father.getGender() == 'F' || father == this) {
			throw new IllegalArgumentException();
		}
		
		if (this.getFather() != null) {
			this.getFather().removeChild(this);
		}
		this.father = father;
		father.addChild(this);
	}
	
	public String getName() {
		return name;
	}
	
	public char getGender() {
		return gender;
	}
	
	public ArrayList<Person> getChildren() {
		return children;
	}
	
	public int getChildCount() {
		return this.getChildren().size();
	}
	
	public Person getChild(int n) {
		return this.getChildren().get(n);
	}
	
	public void addChild(Person child) {
		if (!this.getChildren().contains(child)) {
			this.getChildren().add(child);
			
			if (this.getGender() == 'M' && child.getFather() != this) {
				child.setFather(this);
			} else if (this.getGender() == 'F' && child.getMother() != this) {
				child.setMother(this);
			}
		}
	}
	
	public void removeChild(Person child) {
		if (this.getChildren().contains(child)) {
			this.getChildren().remove(child);
			
			if (this.getGender() == 'M' && child.getFather() != this) {
				child.setFather(null);
			} else if (this.getGender() == 'F' && child.getMother() != this) {
				child.setMother(null);
			}
		}
	}
	
	public String toString() {
		return this.name;
	}
}
