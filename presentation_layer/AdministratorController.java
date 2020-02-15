package presentation_layer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business_layer.BaseProduct;
import business_layer.CompositeProduct;
import business_layer.Restaurant;
import data_layer.RestaurantSerializator;



public class AdministratorController {
	
	private AdministratorGraphicalUserInterface administratorGraphicalUserInterface;
	private Restaurant restaurant;
	private BaseProduct baseProduct;
	private CompositeProduct compositeProduct;
	RestaurantSerializator restaurantSerializator = new RestaurantSerializator();
	
	private WaiterGraphicalUserInterface waiterGraphicalUserInterface = new WaiterGraphicalUserInterface();
	private ChefGraphicalUserInterface chefGraphicalUserInterface = new ChefGraphicalUserInterface();
	private MainView mainView = new MainView();
	
	public AdministratorController() {
		
	}
	
	public AdministratorController(AdministratorGraphicalUserInterface administratorGraphicalUserInterface, Restaurant restaurant, BaseProduct baseProduct, CompositeProduct compositeProduct, WaiterGraphicalUserInterface waiterGraphicalUserInterface, MainView mainView, ChefGraphicalUserInterface chefGraphicalUserInterface) {
		this.administratorGraphicalUserInterface = administratorGraphicalUserInterface;
		this.restaurant = restaurant;
		this.baseProduct = baseProduct;
		this.compositeProduct = compositeProduct;
		this.waiterGraphicalUserInterface = waiterGraphicalUserInterface;
		this.mainView = mainView;
		this.chefGraphicalUserInterface = chefGraphicalUserInterface;
		
		administratorGraphicalUserInterface.showBaseProductsListener(new ShowBaseClientsListener());
		administratorGraphicalUserInterface.createBaseProductsListener(new CreateBaseClientsListener());
		administratorGraphicalUserInterface.createMenuItemListener(new CreateMenuItemListener());
		administratorGraphicalUserInterface.editMenuItemListener(new EditMenuItemListener());
		administratorGraphicalUserInterface.deleteMenuItemListener(new DeleteMenuItemListener());
		administratorGraphicalUserInterface.showMenuItemsListener(new ShowMenuItemListener());
		administratorGraphicalUserInterface.addMainPanelListener(new AdminBackToMainPanelListener());
		
		waiterGraphicalUserInterface.createOrderListener(new CreateOrderListener());
		waiterGraphicalUserInterface.showOrdersListener(new ShowOrderListener());
		waiterGraphicalUserInterface.computeBillListener(new ComputeBillListener());
		waiterGraphicalUserInterface.addMainPanelListener(new WaiterBackToMainPanelListener());
		
		mainView.addAdminListener(new MainAdminListener());
		mainView.addWaiterListener(new MainWaiterListener());
		mainView.addChiefListener(new MainChiefListener());
		
		chefGraphicalUserInterface.showChiefOrderListener(new ShowChiefOrderListener());
		chefGraphicalUserInterface.addMainPanelListener(new ChiefBackToMainPanelListener());
	}
	
	class ShowBaseClientsListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			baseProduct.TableExample();
		}
	}
	
	class CreateBaseClientsListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			baseProduct.createBaseProducts();
		}
	}
		
	class CreateMenuItemListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String baseIds = administratorGraphicalUserInterface.getGiveBaseProductIds().getText();
			compositeProduct = compositeProduct.createCompositeProduct(baseIds);
			restaurant.createMenuItem(compositeProduct);
			administratorGraphicalUserInterface.getGiveBaseProductIds().setText("");
			
		}
	}
	
	class EditMenuItemListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String baseIds = administratorGraphicalUserInterface.getGiveBaseProductIds().getText();
			int productId = Integer.parseInt(administratorGraphicalUserInterface.getGiveMenuItemId().getText());
			compositeProduct = compositeProduct.editCompositeProduct(baseIds, productId);
			restaurant.setRestaurantMenu(restaurant.editMenuItem(compositeProduct, productId));
			administratorGraphicalUserInterface.getGiveBaseProductIds().setText("");
			administratorGraphicalUserInterface.getGiveMenuItemId().setText("");
			
		}
	}
	
	class DeleteMenuItemListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			int productId = Integer.parseInt(administratorGraphicalUserInterface.getGiveMenuItemId().getText());
			restaurant.setRestaurantMenu(restaurant.deleteMenuItem(productId));
			administratorGraphicalUserInterface.getGiveMenuItemId().setText("");
		
		}
	}
	
	class ShowMenuItemListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			restaurantSerializator.serialize(restaurant.getRestaurantMenu());
			restaurant.TableExample(restaurant);
			
		}
	}
	
	class AdminBackToMainPanelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			mainView.setVisible(true);
			administratorGraphicalUserInterface.setVisible(false);
			
		}
	}
	
class CreateOrderListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			int orderId = Integer.parseInt(waiterGraphicalUserInterface.getGiveOrderId().getText());
			String date = waiterGraphicalUserInterface.getGiveOrderDate().getText();
			int table = Integer.parseInt(waiterGraphicalUserInterface.getGiveOrderTable().getText());
			String menuIds = waiterGraphicalUserInterface.getGiveMenuIds().getText();
			
			ChefGraphicalUserInterface chefGraphicalUserInterface = new ChefGraphicalUserInterface();
			restaurant.addObserver(chefGraphicalUserInterface);
			
			restaurant.createNewOrder(orderId, date, table, menuIds);
			
			waiterGraphicalUserInterface.getGiveOrderId().setText("");
			waiterGraphicalUserInterface.getGiveOrderDate().setText("");
			waiterGraphicalUserInterface.getGiveOrderTable().setText("");
			waiterGraphicalUserInterface.getGiveMenuIds().setText("");
			
		}
	}
		
	class ShowOrderListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			restaurant.orderTable();
		}
	}
	
	class ComputeBillListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {
			int orderId = Integer.parseInt(waiterGraphicalUserInterface.getGiveOrderId().getText());
			restaurant.createOrderBill(orderId);
			waiterGraphicalUserInterface.getGiveOrderId().setText("");
		}
		
	}
	
	class WaiterBackToMainPanelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			//MainView mainView = new MainView();
			//MainController mainController = new MainController(mainView);
			mainView.setVisible(true);
			waiterGraphicalUserInterface.setVisible(false);
			
		}
	}
	
	class MainAdminListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			administratorGraphicalUserInterface.setVisible(true);
			mainView.setVisible(false);
		}
	}
	
	
	class MainWaiterListener implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e) {
			waiterGraphicalUserInterface.setVisible(true);	
			mainView.setVisible(false);
		}
	}


	class MainChiefListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {
			
			chefGraphicalUserInterface.setVisible(true);
			mainView.setVisible(false);
		}
	}
	
	class ShowChiefOrderListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			restaurant.orderTable();
		}
	}
	
	class ChiefBackToMainPanelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			//MainView mainView = new MainView();
			//MainController mainController = new MainController(mainView);
			mainView.setVisible(true);
			chefGraphicalUserInterface.setVisible(false);
			
		}
	}
	
}
