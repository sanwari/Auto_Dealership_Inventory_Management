package gui;
	
import javafx.application.Application;
import javafx.stage.Stage;
import user.Associate;
import user.User;
import user.UserFactory;
import vehicle.InventoryFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		userList.initUserList(USER_FILE);
		for(int i = 0; i < userList.getUserList().size(); i++) {
			User user = userList.getUserList().get(i);
			if(user instanceof Associate) {
				((Associate) user).readInventory(user.getUserName() + "Inventory.txt");
			}
		}
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root,805,415);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//Variables
	public static UserFactory userList = new UserFactory();
	public static InventoryFactory inventoryList = new InventoryFactory();
	public static final String USER_FILE = "allUsers.txt";
	public static final String INVENTORYLIST_FILE = "allInventories.txt";
}
