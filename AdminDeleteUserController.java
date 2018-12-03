package gui;

import java.io.File;

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

public class AdminDeleteUserController {
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
				Main.userList.getUserList().remove(foundUser);
				Main.userList.saveUserList(Main.USER_FILE);
				Main.inventoryList.getInvList().remove(foundUser.getInv());
				Main.inventoryList.saveInvList(Main.INVENTORYLIST_FILE);
				File file = new File(foundUser.getUserName() + "Inventory.txt");
				file.delete();
				outputTA.setText("Successfully deleted: " + foundUser.getUserName() + "!");
				userCBOX.getSelectionModel().select(0);
			} else {
				outputTA.setText("User does not exist.");
			}
		} else {
			outputTA.setText("Please select a user.");
		}
    }
	
	//initialize method
	public void initialize() {
		ObservableList<String> userNames = FXCollections.observableArrayList();
		userNames.add("Select a user.");
		for(int i = 0; i < Main.userList.getUserList().size(); i ++) {
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
