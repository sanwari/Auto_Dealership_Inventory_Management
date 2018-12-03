package vehicle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
	//Variables
	private ObservableList<Car> carList;
	private String inventoryName;

	//Constructor
	public Inventory(String inventoryName) {
		carList = FXCollections.observableArrayList();
		this.setInventoryName(inventoryName);
	}
	
	//Getter and Setter methods
	public ObservableList<Car> getCarList() {
		return carList;
	}

	public void setCarList(ObservableList<Car> carList) {
		this.carList = carList;
	}
	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	
	//contains car method
	public boolean containsCar(Car car) {
		for(Car c : carList) {
			if(c.getVin().equals(car.getVin())) {
				return true;
			}
		}
		return false;
	}
	
	//find car method
	public Car findCar(String vin) {
		for(Car car : carList) {
			if(car.getVin().equals(vin)) {
				return car;
			}
		}
		return null;
	}
	
	//find car by make and model method
	public Car findCarByMakeModelYear(int year, String make, String model) {
		for(Car car : carList) {
			if(car.getMake().equals(make) && car.getModel().equals(model) && car.getYear() == year) {
				return car;
			}
		}
		return null;
	}
	
}
