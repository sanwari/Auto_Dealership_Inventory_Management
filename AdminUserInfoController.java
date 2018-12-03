package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import user.Admin;
import user.Associate;
import user.User;

public class AdminUserInfoController {
	//TextAreas
	@FXML
    private JFXTextArea outputTA1;
	
	//ListViews
	@FXML
    private JFXListView<String> allUsersLST;
	
	//Buttons
	@FXML
    private JFXButton selectUserBTN;
	
	//Button Methods
	@FXML
    void doSelectUser(ActionEvent event) {
		String userName = allUsersLST.getSelectionModel().getSelectedItem();
		if(userName == null) {
			outputTA1.setText("Please select a user. ");
		} else if(userName.equals("")) {
			outputTA1.setText("Please select a user. ");
		} else {
			User user = Main.userList.findUser(userName);
			outputTA1.setText("User Name: " + user.getUserName() + "\n");
			outputTA1.appendText("Password: " + user.getPassword() + "\n");
			outputTA1.appendText("Full Name: " + user.getPerson().getFirstName() + " " + 
			user.getPerson().getLastName() + "\n");
			if(user instanceof Admin) {
				outputTA1.appendText("Account Type: Admin ");
			} else if(user instanceof Associate) {
				outputTA1.appendText("Account Type: Associate ");
			}
			allUsersLST.getSelectionModel().clearSelection();
		}
    }
	
	//init method
	public void initialize() {
		ObservableList<String> userNames = FXCollections.observableArrayList();
		for(int i = 0; i < Main.userList.getUserList().size(); i++) {
			User user = Main.userList.getUserList().get(i);
			userNames.add(user.getUserName());
		}
		allUsersLST.setItems(userNames);
	}
	
}
