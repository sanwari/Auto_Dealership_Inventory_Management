package user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserFactory {
	//variables
	private ObservableList<User> userList;
	
	//Constructor
	public UserFactory() {
		userList = FXCollections.observableArrayList();
	}
	
	//Getter and Setter methods
	public void setUserList(ObservableList<User> userList) {
		this.userList = userList;
	}
	public ObservableList<User> getUserList() {
		return userList;
	}
	
	//check user password method
	public boolean checkUser(String userName, String password) {
		for(User user : userList) {
			if(user.getUserName().equals(userName)) {
				if(user.getPassword().equals(password)) {
					return true;
				}
				return false;
			}
		}
		return false;
	}
	
	//check if user exists method
	public boolean userExists(User user) {
		for(User u : userList) {
			if(u.getUserName().equals(user.getUserName())) {
				return true;
			}
		}
		return false;
	}
	
	//find User method
	public User findUser(String userName) {
		for(User user : userList) {
			if (user.getUserName().equals(userName)) {
				return user;
			}
		}
		return null;
	}
	
	//initialize userList
	public void initUserList(String fileName) {
		File file = new File(fileName);
		try {
			Scanner read = new Scanner(file);
			while(read.hasNextLine()) {
				String line = read.nextLine();
				String lineArray[] = line.split(",");
				String userName = lineArray[0];
				String password = lineArray[1];
				String firstName = lineArray[2];
				String lastName = lineArray[3];
				String securityQuestion1 = lineArray[4];
				String securityQuestion2 = lineArray[5];
				String answer1 = lineArray[6];
				String answer2 = lineArray[7];
				String accountType = lineArray[8];
				Person person = new Person(firstName, lastName);
				switch(accountType) {
					case "Admin":
						Admin user = new Admin(userName, password, person, securityQuestion1, 
								securityQuestion2, answer1, answer2);
						userList.add(user);
						break;
					case "Associate":
						Associate user2 = new Associate(userName, password, person, securityQuestion1, 
								securityQuestion2, answer1, answer2);
						userList.add(user2);
						break;
				}
			}
			read.close();
		} catch (FileNotFoundException e) {
			//Add Notification for file not found
			System.out.println("Error... File not found! ");
		}
	}
	
	//save userList method
	public void saveUserList(String fileName) {
		File file = new File(fileName);
		try {
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			for(User user : userList) {
				if(user instanceof Admin) {
					writer.println(user + "," + "Admin");
				} else if(user instanceof Associate) {
					writer.println(user + "," + "Associate");
				}
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			//Add file not found exception
			System.out.println("Error. File not found! ");
		}
	}
	
}
