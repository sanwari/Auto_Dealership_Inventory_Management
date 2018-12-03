package gui;

import java.io.IOException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import user.User;

public class ResetPasswordController {
	//TextAreas
	@FXML
    private JFXTextArea outputTA1;
	@FXML
    private JFXTextArea outputTA2;
	
	//TextFields
	@FXML
    private JFXTextField userNameTF;
	@FXML
    private JFXTextField answerTF;
	@FXML
    private JFXTextField password1TF;
	@FXML
    private JFXTextField password2TF;
	
	//ComboBoxes
	@FXML
    private JFXComboBox<String> questionCBOX;
	
	//Buttons
	@FXML
    private JFXButton selectUserBTN;
	@FXML
    private JFXButton chooseQuestionBTN;
	@FXML
    private JFXButton answerBTN;
	@FXML
    private JFXButton resetBTN;
	@FXML
    private JFXButton backBTN;
	
	//Button Methods
	@FXML
    void doAnswer(ActionEvent event) {
		String answer = answerTF.getText();
		String question = questionCBOX.getSelectionModel().getSelectedItem();
		if(answer.equals("") || answer == null) {
			outputTA1.setText("Please enter an answer. ");
		} else {
			if(question.equals(user.getQuestion1())) {
				if(answer.equals(user.getAnswer1())) {
					outputTA1.clear();
					password1TF.setDisable(false);
					password2TF.setDisable(false);
					resetBTN.setDisable(false);
				} else {
					outputTA1.setText("Answer is incorrect. ");
					answerTF.clear();
				}
			} else if(question.equals(user.getQuestion2())) {
				if(answer.equals(user.getAnswer2())) {
					outputTA1.clear();
					password1TF.setDisable(false);
					password2TF.setDisable(false);
					resetBTN.setDisable(false);
				} else {
					outputTA1.setText("Answer is incorrect. ");
					answerTF.clear();
				}
			}
		}
		
    }
    @FXML
    void doChooseQuestion(ActionEvent event) {
    		String question = questionCBOX.getSelectionModel().getSelectedItem();
    		if(question.equals("") || question == null || question.equals("Select a Question")) {
    			outputTA1.setText("Please Select a Question. ");
    		} else {
    			answerTF.setDisable(false);
        		answerBTN.setDisable(false);
    		}
    }
    @FXML
    void doReset(ActionEvent event) {
    		String password1 = password1TF.getText();
    		String password2 = password2TF.getText();
    		if(password1.equals("") || password2.equals("")) {
    			outputTA2.setText("Please enter a password. ");
    			password1TF.clear();
    			password2TF.clear();
    		} else {
    			if(password1.equals(password2)) {
    				user.setPassword(password1);
    				outputTA2.setText("Password changed! ");
    				password1TF.clear();
    				password1TF.setDisable(true);
    				password2TF.clear();
    				password2TF.setDisable(true);
    				userNameTF.clear();
    				answerTF.clear();
    				answerTF.setDisable(true);
    				questionCBOX.getSelectionModel().select(0);
    				questionCBOX.setDisable(true);
    				outputTA1.clear();
    				Main.userList.saveUserList("allUsers.txt");
    			} else {
    				password1TF.clear();
    				password2TF.clear();
    				outputTA2.setText("Passwords do not match. ");
    			}
    		}
    }
    @FXML
    void doSelectUser(ActionEvent event) {
    		String userName = userNameTF.getText();
    		User foundUser = Main.userList.findUser(userName);
    		if(foundUser != null) {
    			user = foundUser;
    			outputTA1.clear();
    			ObservableList<String> questions = FXCollections.observableArrayList();
    			questions.add(foundUser.getQuestion1());
    			questions.add(foundUser.getQuestion2());
    			questionCBOX.getItems().setAll(questions);
    			questionCBOX.setDisable(false);
    			chooseQuestionBTN.setDisable(false);
    		} else {
    			outputTA1.setText("User does not exist. ");
    			userNameTF.clear();
    		}
    }
    @FXML
    void doBack(ActionEvent event) throws IOException {
    		Parent loginParent = FXMLLoader.load(getClass().getResource("login.fxml"));
    		Scene loginScene = new Scene(loginParent);
    		Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		loginStage.hide();
    		loginStage.setScene(loginScene);
    		loginStage.show();
    }
    
    //init method
    public void initialize() {
    		questionCBOX.getItems().add("Select a Question");
    }
    
    //Variables
    private User user;
	
}
