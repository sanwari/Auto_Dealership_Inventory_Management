package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import vehicle.Car;


public class AssociateAddController {
	//TextFields
	@FXML
    private JFXTextField makeTF;
    @FXML
    private JFXTextField modelTF;
    @FXML
    private JFXTextField yearTF;
    @FXML
    private JFXTextField colorTF;
    @FXML
    private JFXTextField mileTF;
    @FXML
    private JFXTextField vinTF;
    @FXML
    private JFXTextField purchasePriceTF;
    
    //TextAreas
    @FXML
    private JFXTextArea outputTA;
    
    //Buttons
    @FXML
    private JFXButton addBTN;
    
    //Button Methods
    @FXML
    void doAdd(ActionEvent event) {
    		String make = makeTF.getText();
    		String model = modelTF.getText();
    		String year = yearTF.getText();
    		String color = colorTF.getText();
    		String mile = mileTF.getText();
    		String vin = vinTF.getText();
    		String pPrice = purchasePriceTF.getText();
    		if(make.equals("") || make == null) {
    			outputTA.setText("Please enter a vehicle make.\n");
    		} else {
    			if(model.equals("") || model == null) {
    				outputTA.setText("Please enter a vehicle model.\n");
    			} else {
    				if(year.equals("") || year == null) {
    					outputTA.setText("Please enter a valid year.\n");
    				} else {
    					int year1 = Integer.parseInt(year);
    					if(color.equals("") || color == null) {
    						outputTA.setText("Please enter a color.\n");
    					} else {
    						if(mile.equals("") || mile == null) {
    							outputTA.setText("Please enter a valid mileage.\n");
    						} else {
    							long mile1 = Long.parseLong(mile);
    							if(vin.equals("") || vin == null) {
    								outputTA.setText("Please enter a vin #.\n");
    							} else {
    								if(pPrice.equals("") || pPrice == null) {
    									outputTA.setText("Please enter a valid purchase price.\n");
    								} else {
    									double pPrice1 = Double.parseDouble(pPrice);
    									Car newCar = new Car(make, model, year1, color, mile1, vin, pPrice1, 0);
    									AssociateController.user.addCar(newCar);
    									outputTA.setText("Added Car: \n" + "Make: " + newCar.getMake() + "\n" + "Model: " +
    									newCar.getModel() + "\n" + "Year: " + newCar.getYear() + "\n" + "Color: " + newCar.getColor() +
    									"\n" + "Mileage: " + newCar.getMileage() + "\n" + "Vin #: " + newCar.getVin() + "\n" + "Purchase Price: " +
    									 newCar.getCurrency(newCar.getPurchasePrice()) + "\n" + "Expenses: " + newCar.getCurrency(newCar.getExpenses()));
    									makeTF.clear();
    									modelTF.clear();
    									yearTF.clear();
    									colorTF.clear();
    									mileTF.clear();
    									vinTF.clear();
    									purchasePriceTF.clear();
    									AssociateController.user.saveInventory(AssociateController.user.getUserName() + "Inventory.txt");
    								}
    							}
    						}
    					}
    				}
    			}
    		}
    }
    
}
