package gui;

import java.io.IOException;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminController {
	//Panes
	@FXML
    private Pane containerPANE;
	
	//Buttons
	@FXML
    private JFXButton aboutSceneBTN;
	@FXML
    private JFXButton userInfoSceneBTN;
	@FXML
    private JFXButton addUserSceneBTN;
	@FXML
    private JFXButton deleteUserSceneBTN;
	@FXML
    private JFXButton resetPasswordSceneBTN;
	@FXML
    private JFXButton logoutBTN;
	
	//Button Methods
	@FXML
    void switchAbout(ActionEvent event) throws IOException {
		Parent aboutParent = FXMLLoader.load(getClass().getResource("AdminAbout.fxml"));
		containerPANE.getChildren().addAll(aboutParent);
    }
    @FXML
    void switchAddUser(ActionEvent event) throws IOException {
    		Parent addUserParent = FXMLLoader.load(getClass().getResource("AdminAddUser.fxml"));
    		containerPANE.getChildren().addAll(addUserParent);
    }
    @FXML
    void switchDeleteUser(ActionEvent event) throws IOException {
    		Parent deleteUserParent = FXMLLoader.load(getClass().getResource("AdminDeleteUser.fxml"));
    		containerPANE.getChildren().addAll(deleteUserParent);
    }
    @FXML
    void switchResetPassword(ActionEvent event) throws IOException {
    		Parent resetParent = FXMLLoader.load(getClass().getResource("AdminResetPassword.fxml"));
    		containerPANE.getChildren().addAll(resetParent);
    }
    @FXML
    void switchUserInfo(ActionEvent event) throws IOException {
    		Parent userInfoParent = FXMLLoader.load(getClass().getResource("AdminUserInfo.fxml"));
    		containerPANE.getChildren().addAll(userInfoParent);
    }
    @FXML
    void doLogout(ActionEvent event) throws IOException {
    		Parent loginParent = FXMLLoader.load(getClass().getResource("login.fxml"));
    		Scene loginScene = new Scene(loginParent);
    		Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		loginStage.hide();
    		loginStage.setScene(loginScene);
    		loginStage.show();
    }
    
    //initialize method
    public void initialize() throws IOException {
    		Parent aboutParent = FXMLLoader.load(getClass().getResource("AdminAbout.fxml"));
		containerPANE.getChildren().addAll(aboutParent);
    }
    
}
