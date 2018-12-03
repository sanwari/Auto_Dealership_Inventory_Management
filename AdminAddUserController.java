package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import user.Associate;
import user.Person;
import vehicle.Inventory;

public class AdminAddUserController {
	//TextFields
	@FXML
    private JFXTextField userNameTF;
    @FXML
    private JFXTextField paswordTF;
    @FXML
    private JFXTextField answer1TF;
    @FXML
    private JFXTextField answer2TF;
    @FXML
    private JFXTextField firstNameTF;
    @FXML
    private JFXTextField lastNameTF;
    
    //TextAreas
    @FXML
    private JFXTextArea outputTA;
    
    //ComboBoxes
    @FXML
    private JFXComboBox<String> question1CBOX;
    @FXML
    private JFXComboBox<String> question2CBOX;
    
    //Buttons
    @FXML
    private JFXButton addBTN;
    
    //Button Methods
    @FXML
    void doAdd(ActionEvent event) {
    		String userName = userNameTF.getText();
    		String password = paswordTF.getText();
    		String question1 = question1CBOX.getSelectionModel().getSelectedItem();
    		String question2 = question2CBOX.getSelectionModel().getSelectedItem();
    		String answer1 = answer1TF.getText();
    		String answer2 = answer2TF.getText();
    		String firstName = firstNameTF.getText();
    		String lastName = lastNameTF.getText();
    		if(userName != "") {
    			if(password != "") {
    				if(question1 != "Select question 1.") {
    					if(question2 != "Select question 2.") {
    						if(answer1 != "" && answer2 != "") {
    							if(firstName != "" && lastName != "") {
    								addBTN.setDisable(false);
    								Person person = new Person(firstName, lastName);
    								Associate user = new Associate(userName, password, person, question1, question2, 
    										answer1, answer2);
    								boolean userExists = Main.userList.userExists(user);
    								if(userExists == false) {
    									Main.userList.getUserList().add(user);
        								outputTA.setText("Successfully added: " + user.getUserName() + "!\n");
        								Main.userList.saveUserList(Main.USER_FILE);
        								Inventory inv = new Inventory(userName + "Inventory");
        								user.saveInventory(userName + "Inventory.txt");
        								Main.inventoryList.getInvList().add(inv);
        								Main.inventoryList.saveInvList(Main.INVENTORYLIST_FILE);
        								userNameTF.clear();
        								paswordTF.clear();
        								question1CBOX.getSelectionModel().select(0);
        								question2CBOX.getSelectionModel().select(0);
        								answer1TF.clear();
        								answer2TF.clear();
        								firstNameTF.clear();
        								lastNameTF.clear();
    								} else {
    									outputTA.setText("User already exists.\n");
    									userNameTF.clear();
        								paswordTF.clear();
        								question1CBOX.getSelectionModel().select(0);
        								question2CBOX.getSelectionModel().select(0);
        								answer1TF.clear();
        								answer2TF.clear();
        								firstNameTF.clear();
        								lastNameTF.clear();
    								}
    								
    							}
    						} else {
    							outputTA.setText("Please enter an answer to a question.\n");
    						}
    					} else {
    						outputTA.setText("Please select a question.\n");
    					}
    				} else {
    					outputTA.setText("Please select a question.\n");
    				}
    			} else {
    				outputTA.setText("Please enter a password.\n");
    			}
    		} else {
    			outputTA.setText("Please enter a user name.\n");
    		}
    }
    
    //init Method
    public void initialize() {
    		ObservableList<String> qList1 = FXCollections.observableArrayList();
    		qList1.add("Select question 1.");
    		qList1.add("What city was your mother born in?");
    		qList1.add("What is the name of your youngest child?");
    		qList1.add("What is the name of your elementary school?");
    		qList1.add("What is the name of your oldest sibling?");
    		qList1.add("Where did you meet your spouse?");
    		qList1.add("What is your favorite sports team?");
    		ObservableList<String> qList2 = FXCollections.observableArrayList();
    		qList2.add("Select question 2.");
    		qList2.add("What city was your mother born in?");
    		qList2.add("What is the name of your youngest child?");
    		qList2.add("What is the name of your elementary school?");
    		qList2.add("What is the name of your oldest sibling?");
    		qList2.add("Where did you meet your spouse?");
    		qList2.add("What is your favorite sports team?");
    		question1CBOX.setItems(qList1);
    		question2CBOX.setItems(qList2);
    		question1CBOX.getSelectionModel().select(0);
    		question2CBOX.getSelectionModel().select(0);
    }
    
}
