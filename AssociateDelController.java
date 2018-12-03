package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import vehicle.Car;
import vehicle.Inventory;

public class AssociateDelController {
	//ComboBoxes
	@FXML
    private JFXComboBox<String> carCBOX;
	
	//TextAreas
	@FXML
    private JFXTextArea outputTA;
	
	//Buttons
	@FXML
    private JFXButton delBTN;
	
	//Button Methods
	@FXML
    void doDel(ActionEvent event) {
		String str = carCBOX.getSelectionModel().getSelectedItem();
		if(str != "Select a Car") {
			String carArray[] = str.split(" ");
			int year = Integer.parseInt(carArray[0]);
			String make = carArray[1];
			String model = carArray[2];
			Car found = AssociateController.user.getInv().findCarByMakeModelYear(year, make, model);
			if(found != null) {
				AssociateController.user.getInv().getCarList().remove(found);
				outputTA.setText("Deleted: " + carCBOX.getSelectionModel().getSelectedItem());
				carCBOX.getItems().remove(carCBOX.getSelectionModel().getSelectedIndex());
				carCBOX.getSelectionModel().select(0);
				AssociateController.user.saveInventory(AssociateController.user.getUserName() + "Inventory.txt");
			}
		} else {
			outputTA.setText("Please select a car.");
		}
    }
	
	//initialize method
	public void initialize() {
		Inventory inv = AssociateController.user.getInv();
		carList.add("Select a Car");
		for(int i =0; i < inv.getCarList().size(); i++) {
			Car car = inv.getCarList().get(i);
			String str = car.getYear() + " " + car.getMake() + " " + car.getModel();
			carList.add(str);
		}
		carCBOX.setItems(carList);
		carCBOX.getSelectionModel().select(0);
	}
	
	//Variables
	ObservableList<String> carList = FXCollections.observableArrayList();
	
}
