package gui;

import java.util.function.Predicate;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;
import vehicle.Car;

public class AssociateInventoryController {
	//Labels
	@FXML
    private Label totalLBL;
	
	//TreeTableView
	@FXML
    private JFXTreeTableView<Wrapper> inventoryTBL;
	
	//TextFields
	@FXML
    private JFXTextField makeTF;

	//initialize method
	@SuppressWarnings("unchecked")
	public void initialize() {
		//column initialization
		JFXTreeTableColumn<Wrapper, String> makeCOL = new JFXTreeTableColumn<>("Make");
		makeCOL.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Wrapper, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Wrapper, String> param) {
					String make = param.getValue().getValue().getMake();
					StringProperty var1 = new SimpleStringProperty((String) make);
					return var1;
				}
			});
		JFXTreeTableColumn<Wrapper, String> modelCOL = new JFXTreeTableColumn<>("Model");
		modelCOL.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Wrapper, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Wrapper, String> param) {
					String model = param.getValue().getValue().getModel();
					StringProperty var2 = new SimpleStringProperty((String) model);
					return var2;
				}
			});
		JFXTreeTableColumn<Wrapper, String> yearCOL = new JFXTreeTableColumn<>("Year");
		yearCOL.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Wrapper, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Wrapper, String> param) {
					String year = param.getValue().getValue().getYear();
					StringProperty var3 = new SimpleStringProperty((String) year);
					return var3;
				}
			});
		JFXTreeTableColumn<Wrapper, String> colorCOL = new JFXTreeTableColumn<>("Color");
		colorCOL.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Wrapper, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Wrapper, String> param) {
					String color = param.getValue().getValue().getColor();
					StringProperty var4 = new SimpleStringProperty((String) color);
					return var4;
				}
			});
		JFXTreeTableColumn<Wrapper, String> mileageCOL = new JFXTreeTableColumn<>("Mileage");
		mileageCOL.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Wrapper, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Wrapper, String> param) {
					String mileage = param.getValue().getValue().getMileage();
					StringProperty var5 = new SimpleStringProperty((String) mileage);
					return var5;
				}
			});
		JFXTreeTableColumn<Wrapper, String> vinCOL = new JFXTreeTableColumn<>("VIN #");
		vinCOL.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Wrapper, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Wrapper, String> param) {
					String vin = param.getValue().getValue().getVin();
					StringProperty var6 = new SimpleStringProperty((String) vin);
					return var6;
				}
			});
		JFXTreeTableColumn<Wrapper, String> purchasePriceCOL = new JFXTreeTableColumn<>("Purchase Price");
		purchasePriceCOL.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Wrapper, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Wrapper, String> param) {
					String purchasePrice = param.getValue().getValue().getPurchasePrice();
					StringProperty var7 = new SimpleStringProperty((String) purchasePrice);
					return var7;
				}
			});
		/*JFXTreeTableColumn<Wrapper, String> expensesCOL = new JFXTreeTableColumn<>("Expenses");
		expensesCOL.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Wrapper, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Wrapper, String> param) {
					String expenses = param.getValue().getValue().getExpenses();
					StringProperty var8 = new SimpleStringProperty((String) expenses);
					return var8;
				}
			});*/
		for(int i = 0; i < AssociateController.user.getInv().getCarList().size(); i++) {
			Car car = AssociateController.user.getInv().getCarList().get(i);
			Wrapper wrapped = new Wrapper(car);
			inventory.add(wrapped);
		}
		TreeItem<Wrapper> root = new RecursiveTreeItem<Wrapper>(inventory, RecursiveTreeObject::getChildren);
		inventoryTBL.getColumns().setAll(makeCOL, modelCOL, yearCOL, colorCOL, mileageCOL, vinCOL, purchasePriceCOL);
		inventoryTBL.setRoot(root);
		inventoryTBL.setColumnResizePolicy(JFXTreeTableView.CONSTRAINED_RESIZE_POLICY);
		inventoryTBL.setShowRoot(false);
		makeTF.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				inventoryTBL.setPredicate(new Predicate<TreeItem<Wrapper>>() {
					@Override
					public boolean test(TreeItem<Wrapper> t) {
						Boolean flag = t.getValue().getMake().contains(newValue) || t.getValue().getModel().contains(newValue) || 
								t.getValue().getYear().contains(newValue) || t.getValue().getColor().contains(newValue);
						return flag;
					}
				});
			}
		});
		
	}
	
	//Variables
	ObservableList<Wrapper> inventory = FXCollections.observableArrayList();
	
}
