package user;

public class User {
	//Variables
	private String userName = "";
	private String password = "";
	private Person person = null;
	private String securityQuestion1 = "";
	private String securityQuestion2 = "";
	private String answer1 = "";
	private String answer2 = "";
	//Constructor
	public User(String userName, String password, Person person, String securityQuestion1, 
			String securityQuestion2, String answer1, String answer2) {
		setUserName(userName);
		setPassword(password);
		setPerson(person);
		setQuestion1(securityQuestion1);
		setQuestion2(securityQuestion2);
		setAnswer1(answer1);
		setAnswer2(answer2);
	}
	
	//Getter and Setter methods
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Person getPerson() {
		return person;
	}
	public void setQuestion1(String securityQuestion) {
		this.securityQuestion1 = securityQuestion;
	}
	public String getQuestion1() {
		return securityQuestion1;
	}
	public void setQuestion2(String securityQuestion) {
		this.securityQuestion2 = securityQuestion;
	}
	public String getQuestion2() {
		return securityQuestion2;
	}
	public void setAnswer1(String answer) {
		this.answer1 = answer;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer2(String answer) {
		this.answer2 = answer;
	}
	public String getAnswer2() {
		return answer2;
	}
	
	//toString method
	public String toString() {
		String str = "";
		str += userName + "," + password + "," + person + "," + securityQuestion1 + ",";
		str += securityQuestion2 + "," + answer1 + "," + answer2;
		return str;
	}
	
}
