package presentation_layer;

import business_layer.BaseProduct;
import business_layer.CompositeProduct;
import business_layer.Restaurant;
import data_layer.RestaurantSerializator;

public class Start {

	public static void main(String args[]) {
		AdministratorGraphicalUserInterface administratorGraphicalUserInterface = new AdministratorGraphicalUserInterface();
		Restaurant restaurant = new Restaurant();
		BaseProduct baseProduct = new BaseProduct();
		CompositeProduct compositeProduct = new CompositeProduct();
		RestaurantSerializator restaurantSerializator = new RestaurantSerializator();
		
		WaiterGraphicalUserInterface waiterGraphicalUserInterface = new WaiterGraphicalUserInterface();
		MainView mainView = new MainView();
		ChefGraphicalUserInterface chefGraphicalUserInterface = new ChefGraphicalUserInterface();
		
		AdministratorController administratorController = new AdministratorController(administratorGraphicalUserInterface, restaurant, baseProduct, compositeProduct, waiterGraphicalUserInterface, mainView, chefGraphicalUserInterface);
		mainView.setVisible(true);
	}
	
}
