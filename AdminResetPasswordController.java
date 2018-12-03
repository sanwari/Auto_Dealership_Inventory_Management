package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import user.Admin;
import user.Associate;
import user.User;

public class AdminResetPasswordController {
	//TextAreas
	@FXML
    private JFXTextArea outputTA;
	
	//ComboBoxes
	@FXML
    private JFXComboBox<String> userCBOX;
	
	//Buttons
	@FXML
    private JFXButton selectBTN;
	
	//Button Methods
	@FXML
    void doSelect(ActionEvent event) {
		String userName = userCBOX.getSelectionModel().getSelectedItem();
		if(userName != "Select a user.") {
			Associate foundUser = (Associate) Main.userList.findUser(userName);
			if(foundUser != null) {
				foundUser.setPassword("password");
				Main.userList.saveUserList(Main.USER_FILE);
				outputTA.setText("Password has been reset for: " + foundUser.getUserName());
				userCBOX.getSelectionModel().select(0);
			} else {
				outputTA.setText("User does not exist.");
			}
		} else {
			outputTA.setText("Please select a user.");
		}
    }
	
	//Initialize method
	public void initialize() {
		ObservableList<String> userNames = FXCollections.observableArrayList();
		userNames.add("Select a user.");
		for(int i = 0; i < Main.userList.getUserList().size(); i++) {
			User user = Main.userList.getUserList().get(i);
			if(!(user instanceof Admin)) {
				String userName = user.getUserName();
				userNames.add(userName);
			}
		}
		userCBOX.setItems(userNames);
		userCBOX.getSelectionModel().select(0);
	}
	
}
