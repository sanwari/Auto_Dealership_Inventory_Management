package user;

public class Admin extends User {
	//Constructor
	public Admin(String userName, String password, Person person, String securityQuestion1, String securityQuestion2,
			String answer1, String answer2) {
		super(userName, password, person, securityQuestion1, securityQuestion2, answer1, answer2);
	}
	
	//Add user Method
	public void addUser(User user, UserFactory uList) {
		Boolean found = uList.userExists(user);
		if(found == false) {
			uList.getUserList().add(user);
		} else {
			//Add notification on GUI
			System.out.println("User already exists! ");
		}
	}
	
	//Delete User Method
	public void deleteUser(User user, UserFactory uList) {
		Boolean found = uList.userExists(user);
		if(found == true) {
			User foundUser = uList.findUser(user.getUserName());
			uList.getUserList().remove(foundUser);
		}
	}
	
	//Reset Password method
	public void resetPassword(User user, String password) {
		user.setPassword(password);
	}
	
}
