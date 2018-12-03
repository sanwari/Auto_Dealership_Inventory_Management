package gui;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import vehicle.Car;

public class Wrapper extends RecursiveTreeObject<Wrapper>{
	//Variables
	private String make;
	private String model;
	private String year;
	private String color;
	private String mileage;
	private String vin;
	private String purchasePrice;
	private String expenses;
	
	//Constructor
	public Wrapper(Car car) {
		setMake(car.getMake());
		setModel(car.getModel());
		setYear(String.valueOf(car.getYear()));
		setColor(car.getColor());
		setMileage(String.valueOf(car.getMileage()));
		setVin(car.getVin());
		setPurchasePrice(car.getCurrency(car.getPurchasePrice()));
		setExpenses(car.getCurrency(car.getExpenses()));
	}
	
	//Getter and Setter Methods
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getExpenses() {
		return expenses;
	}
	public void setExpenses(String expenses) {
		this.expenses = expenses;
	}
}
