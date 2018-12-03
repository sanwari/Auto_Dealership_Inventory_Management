package user;

public class Person {
	//Variables
	private String firstName = "";
	private String lastName = "";
	
	//Constructor
	public Person(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	//Getter and Setter methods
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	
	//toString method
	public String toString() {
		String str = "";
		str += firstName + "," + lastName;
		return str;
	}
}
