package gui;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AssociateEditController {
	//TextFields
	@FXML
    private JFXTextField oldPasswordTF;
    @FXML
    private JFXTextField pass1TF;
    @FXML
    private JFXTextField pass2TF;
    
    //TextAreas
    @FXML
    private JFXTextArea outputTA;
    
    //Button Methods
    @FXML
    void doReset(ActionEvent event) {
    		String oldPassword = oldPasswordTF.getText();
    		String pass1 = pass1TF.getText();
    		String pass2 = pass2TF.getText();
    		if(oldPassword.equals(AssociateController.user.getPassword())) {
    			if(pass1.equals(pass2)) {
    				AssociateController.user.setPassword(pass1);
    				Main.userList.saveUserList(Main.USER_FILE);
    				outputTA.setText("Successfully changed password!");
    				oldPasswordTF.clear();
    				pass1TF.clear();
    				pass2TF.clear();
    			} else {
    				outputTA.setText("New passwords do not match.");
    			}
    		} else if(oldPassword.equals("")){
    			outputTA.setText("Please enter your old password.");
    		} else {
    			outputTA.setText("Old password does not match current password.");
    			oldPasswordTF.clear();
			pass1TF.clear();
			pass2TF.clear();
    		}
    }
    
}
