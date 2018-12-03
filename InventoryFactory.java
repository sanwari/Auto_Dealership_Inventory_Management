package vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryFactory {
	//Variables
	private ObservableList<Inventory> invList;
	
	//Constructor
	public InventoryFactory() {
		invList = FXCollections.observableArrayList();
	}
	
	//Getter and Setter methods
	public ObservableList<Inventory> getInvList() {
		return invList;
	}

	public void setInvList(ObservableList<Inventory> invList) {
		this.invList = invList;
	}
	
	//init inventory list method
	public void initInvList(String fileName) {
		File file = new File(fileName);
		try {
			Scanner read = new Scanner(file);
			while(read.hasNextLine()) {
				String inventoryName = read.nextLine();
				Inventory inv = new Inventory(inventoryName);
				invList.add(inv);
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found. ");
		}
	}
	
	//save inventory list method
	public void saveInvList(String fileName) {
		File file = new File(fileName);
		try {
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			for(Inventory inv : invList) {
				writer.println(inv.getInventoryName());
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("File not found. ");
		}
	}
}
