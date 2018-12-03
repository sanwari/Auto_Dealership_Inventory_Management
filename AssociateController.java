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
import user.Associate;

public class AssociateController {
	//Panes
	@FXML
    private Pane containerPANE;
	
	//Buttons
	@FXML
    private JFXButton aboutBTN;
	@FXML
    private JFXButton inventoryButton;
    @FXML
    private JFXButton addCarBTN;
    @FXML
    private JFXButton deleteCarBTN;
    @FXML
    private JFXButton searchBTN;
    @FXML
    private JFXButton editAccountBTN;
    @FXML
    private JFXButton logoutBTN;
    
    //Button Methods
    @FXML
    void switchAbout(ActionEvent event) throws IOException {
    		Parent aboutParent = FXMLLoader.load(getClass().getResource("AdminAbout.fxml"));
		containerPANE.getChildren().addAll(aboutParent);
    }
    @FXML
    void switchInventory(ActionEvent event) throws IOException {
    		Parent inventoryParent = FXMLLoader.load(getClass().getResource("AssociateInventory.fxml"));
    		containerPANE.getChildren().addAll(inventoryParent);
    }
    @FXML
    void switchAddCar(ActionEvent event) throws IOException {
    		Parent addParent = FXMLLoader.load(getClass().getResource("AssociateAdd.fxml"));
    		containerPANE.getChildren().addAll(addParent);
    }
    @FXML
    void switchDeleteCar(ActionEvent event) throws IOException {
    		Parent delParent = FXMLLoader.load(getClass().getResource("AssociateDel.fxml"));
    		containerPANE.getChildren().addAll(delParent);
    }
    @FXML
    void switchSearch(ActionEvent event) throws IOException {
    		Parent genParent =FXMLLoader.load(getClass().getResource("AssociateGenAd.fxml"));
    		containerPANE.getChildren().addAll(genParent);
    }
    @FXML
    void SwitchEditAccount(ActionEvent event) throws IOException {
		Parent editParent = FXMLLoader.load(getClass().getResource("AssociateEdit.fxml"));
		containerPANE.getChildren().addAll(editParent);
		
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
    
    //pass user method
    public void passUser(Associate user) {
    		setUser(user);
    }
    
    //Variables
    public static Associate user;
    
    //setUser method
    public void setUser(Associate user) {
    		AssociateController.user = user;
    }
    
    //initialize method
    public void initialize() throws IOException {
    		Parent aboutParent = FXMLLoader.load(getClass().getResource("AdminAbout.fxml"));
		containerPANE.getChildren().addAll(aboutParent);
    }
    
}
