package user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import vehicle.Car;
import vehicle.Inventory;

public class Associate extends User {
	//Variables
	private Inventory inv;
	
	//Constructor
	public Associate(String userName, String password, Person person, String securityQuestion1,
			String securityQuestion2, String answer1, String answer2) {
		super(userName, password, person, securityQuestion1, securityQuestion2, answer1, answer2);
		setInv(new Inventory(userName + "Inventory"));
	}

	//Getter and Setter Methods
	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	//add car method
	public void addCar(Car car) {
		Boolean found = inv.containsCar(car);
		if(found == false) {
			inv.getCarList().add(car);
		} else {
			//Add car found exception
			System.out.println("Car already exists!");
		}
	}
	
	//Delete car method
	public void deleteCar(Car car) {
		Boolean found = inv.containsCar(car);
		if(found == true) {
			Car foundCar = inv.findCar(car.getVin());
			inv.getCarList().remove(foundCar);
		}
	}
	
	//readInventory method
	public void readInventory(String fileName) {
		File file = new File(fileName);
		try {
			Scanner read = new Scanner(file);
			while(read.hasNextLine()) {
				String line = read.nextLine();
				String carArray[] = line.split(",");
				String make = carArray[0];
				String model = carArray[1];
				int year = Integer.parseInt(carArray[2]);
				String color = carArray[3];
				long mileage = Long.parseLong(carArray[4]);
				String vin = carArray[5];
				double purchasePrice = Double.parseDouble(carArray[6]);
				double expenses = Double.parseDouble(carArray[7]);
				Car car = new Car(make, model, year, color, mileage, vin, purchasePrice, expenses);
				inv.getCarList().add(car);
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("User inventory file not found. ");
		}
	}
	//saveInventory method
	public void saveInventory(String fileName) {
		File file = new File(fileName);
		try {
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			for(int i = 0; i < inv.getCarList().size(); i++) {
				Car car = inv.getCarList().get(i);
				writer.println(car);
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("File not found. ");
		}
	}
}
