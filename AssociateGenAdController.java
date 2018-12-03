package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import vehicle.Car;
import vehicle.Inventory;

public class AssociateGenAdController {
	//CheckBoxes
	@FXML
    private JFXCheckBox titleCHK;
    @FXML
    private JFXCheckBox carfaxCHK;
	
	//ComboBoxes
	@FXML
    private JFXComboBox<String> carCBOX;
	
	//TextAreas
	@FXML
    private JFXTextArea outputTA;
	
	//Buttons
	@FXML
    private JFXButton genBTN;
	
	//Button Methods
	@FXML
    void doGen(ActionEvent event) {
		String str = carCBOX.getSelectionModel().getSelectedItem();
		if(str != "Select a Car") {
			String carArray[] = str.split(" ");
			int year = Integer.parseInt(carArray[0]);
			String make = carArray[1];
			String model = carArray[2];
			Car found = AssociateController.user.getInv().findCarByMakeModelYear(year, make, model);
			if(found != null || carCBOX.getSelectionModel().getSelectedItem() != "Select a Car") {
				String str2 = "";
				if(!(titleCHK.isSelected() && carfaxCHK.isSelected())) {
					if(titleCHK.isSelected()) {
						str2 = "I am selling my " + found.getYear() + " " + found.getMake() + " " + found.getModel() + ". It is in perfect running condition, ";
						str2 += "It has " + found.getMileage() + " miles on it, and still running good. It is very clean inside and outside, ";
						str2 += "and it does not have any mechanical issues whatsoever. It has a clean title. ";
						str2 += "For more info please call or text me @571-269-6664.\n";
						str2 += "\nCar Info: ";
						str2 += "\nMake: " + found.getMake();
						str2 += "\nModel: " + found.getModel();
						str2 += "\nYear: " + found.getYear();
						str2 += "\nMileage: " + found.getMileage();
						str2 += "\nColor: " + found.getColor();
						str2 += "\nVIN Number: " + found.getVin();
						outputTA.setText(str2);
					} else if(carfaxCHK.isSelected()) {
						str2 = "I am selling my " + found.getYear() + " " + found.getMake() + " " + found.getModel() + ". It is in perfect running condition, ";
						str2 += "It has " + found.getMileage() + " miles on it, and still running good. It is very clean inside and outside, ";
						str2 += "and it does not have any mechanical issues whatsoever. It has a clean carfax. ";
						str2 += "For more info please call or text me @571-269-6664.\n";
						str2 += "\nCar Info: ";
						str2 += "\nMake: " + found.getMake();
						str2 += "\nModel: " + found.getModel();
						str2 += "\nYear: " + found.getYear();
						str2 += "\nMileage: " + found.getMileage();
						str2 += "\nColor: " + found.getColor();
						str2 += "\nVIN Number: " + found.getVin();
						outputTA.setText(str2);
					} else {
						str2 = "I am selling my " + found.getYear() + " " + found.getMake() + " " + found.getModel() + ". It is in perfect running condition, ";
						str2 += "and it has " + found.getMileage() + " miles on it. It is very clean inside and outside, ";
						str2 += "and it does not have any mechanical issues whatsoever. For more info please call or ";
						str2 += "text me @571-269-6664.\n";
						str2 += "\nCar Info: ";
						str2 += "\nMake: " + found.getMake();
						str2 += "\nModel: " + found.getModel();
						str2 += "\nYear: " + found.getYear();
						str2 += "\nMileage: " + found.getMileage();
						str2 += "\nColor: " + found.getColor();
						str2 += "\nVIN Number: " + found.getVin();
						outputTA.setText(str2);
					}
				} else if(titleCHK.isSelected() && carfaxCHK.isSelected()){
						str2 = "I am selling my " + found.getYear() + " " + found.getMake() + " " + found.getModel() + ". It is in perfect running condition, ";
						str2 += "It has " + found.getMileage() + " miles on it, and still running good. It is very clean inside and outside, ";
						str2 += "and it does not have any mechanical issues whatsoever. It has a clean title";
						str2 += " and a clean carfax. For more info please call or text me @571-269-6664.\n";
						str2 += "\nCar Info: ";
						str2 += "\nMake: " + found.getMake();
						str2 += "\nModel: " + found.getModel();
						str2 += "\nYear: " + found.getYear();
						str2 += "\nMileage: " + found.getMileage();
						str2 += "\nColor: " + found.getColor();
						str2 += "\nVIN Number: " + found.getVin();
						outputTA.setText(str2);
					
				}
			} else {
				outputTA.setText("Please select a car.");
			}
		}
	}
	
	//Variables
	ObservableList<String> carList = FXCollections.observableArrayList();
	
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
	
}
