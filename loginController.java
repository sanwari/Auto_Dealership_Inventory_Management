package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import user.Admin;
import user.Associate;
import user.User;

public class loginController {
	//Labels
	@FXML
    private Label wrongPasswordLBL;
	@FXML
    private Label wrongUserLBL;
	
	//TextFields
	@FXML
    private JFXTextField userNameTF;
	@FXML
    private JFXPasswordField passwordTF;
	@FXML
    private JFXTextField passwordVisibleTF;
	
	//CheckBoxes
	@FXML
    private JFXCheckBox showPasswordCHK;
	
	//CheckBox Methods
	@FXML
    void doVisible(ActionEvent event) {
		if(showPasswordCHK.isSelected()) {
			passwordVisibleTF.setText(passwordTF.getText());
			passwordTF.setVisible(false);
			passwordVisibleTF.setVisible(true);
		} else {
			passwordTF.setText(passwordVisibleTF.getText());
			passwordTF.setVisible(true);
			passwordVisibleTF.setVisible(false);
		}
    }
	
	//Buttons
	@FXML
    private JFXButton loginBTN;
	@FXML
    private JFXButton resetBTN;
	
	//Button Methods
	@FXML
    void doLogin(ActionEvent event) throws IOException {
		String userName = userNameTF.getText();
		String password = "";
		if(showPasswordCHK.isSelected()) {
			password = passwordVisibleTF.getText();
		} else {
			password = passwordTF.getText();
		}
		User foundUser = Main.userList.findUser(userName);
		//Scene for Admin
		Parent adminParent = FXMLLoader.load(getClass().getResource("Admin.fxml"));
		Scene adminScene = new Scene(adminParent);
		//Scene for Associate
		Parent associateParent = FXMLLoader.load(getClass().getResource("Associate.fxml"));
		Scene associateScene = new Scene(associateParent);
		if(foundUser != null) {
			if(foundUser instanceof Admin) {
				if(password.equals(foundUser.getPassword())) {
					Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					adminStage.hide();
					adminStage.setScene(adminScene);
					adminStage.show();
				} else {
					wrongPasswordLBL.setVisible(true);
					wrongUserLBL.setVisible(false);
					passwordTF.clear();
					passwordVisibleTF.clear();
				}
			} else {
				if(password.equals(foundUser.getPassword())) {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("Associate.fxml"));
					loader.load();
					AssociateController controller = loader.getController();
					controller.passUser((Associate) foundUser);
					Stage associateStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					associateStage.hide();
					associateStage.setScene(associateScene);
					associateStage.show();
				} else {
					wrongPasswordLBL.setVisible(true);
					wrongUserLBL.setVisible(false);
					passwordTF.clear();
					passwordVisibleTF.clear();
				}
			}
		} else {
			wrongUserLBL.setVisible(true);
			wrongPasswordLBL.setVisible(false);
			userNameTF.clear();
			passwordTF.clear();
			passwordVisibleTF.clear();
		}
		
    }
    @FXML
    void doReset(ActionEvent event) throws IOException {
    		//Scene for reset password
    		Parent resetParent = FXMLLoader.load(getClass().getResource("ResetPassword.fxml"));
    		Scene resetScene = new Scene(resetParent);
    		Stage resetStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		resetStage.hide();
    		resetStage.setScene(resetScene);
    		resetStage.show();
    }
    
}
