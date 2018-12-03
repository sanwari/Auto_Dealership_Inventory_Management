package vehicle;

import java.text.DecimalFormat;

public class Car {
	//variables
	private String make = "";
	private String model = "";
	private int year = 0;
	private String color = "";
	private long mileage = 0;
	private String vin = "";
	private double purchasePrice = 0;
	private double expenses = 0;
	//CAUTION, this formatter will return a String.
	protected DecimalFormat dFormat = new DecimalFormat("$###,###,###.00");
	
	//Constructor
	public Car(String make, String model, int year, String color, long mileage, String vin, 
			double purchasePrice, double expenses) {
		setMake(make);
		setModel(model);
		setYear(year);
		setColor(color);
		setMileage(mileage);
		setVin(vin);
		setPurchasePrice(purchasePrice);
		setExpenses(expenses);
	}
	
	//Getter and Setter methods
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public long getMileage() {
		return mileage;
	}
	public void setMileage(long mileage) {
		this.mileage = mileage;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getExpenses() {
		return expenses;
	}
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	
	//Convert to currency value
	public String getCurrency(double num) {
		return dFormat.format(num);
	}
	
	//toString method
	public String toString() {
		String str = "";
		str += make + "," + model + "," + year + "," + color + ",";
		str += mileage + "," + vin + "," + purchasePrice + "," + expenses;
		return str;
	}
	
}
