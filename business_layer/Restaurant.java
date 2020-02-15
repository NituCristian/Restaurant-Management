package business_layer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data_layer.FileWriter;
import data_layer.RestaurantSerializator;

/**
 * @invariant isWellFormed()
 * @author Cristi
 *
 */
public class Restaurant extends Observable implements RestaurantProcessing{

	private ArrayList<MenuItem> restaurantMenu = new ArrayList<>();
	public Map<Order, ArrayList<MenuItem>> orderDetails = new HashMap<Order, ArrayList<MenuItem>>();
	
	public Restaurant() {
		
	}
	
	public void createMenuItem(CompositeProduct product) {
		assert product != null;
		int menuSize = this.getRestaurantMenu().size();
		this.getRestaurantMenu().add(product);
		int newSize = this.getRestaurantMenu().size();
		assert newSize == menuSize + 1;
	}
	
	public ArrayList<MenuItem> deleteMenuItem(int id) {
		
		ArrayList<MenuItem> items = new ArrayList<>();
		
		assert getRestaurantMenu().size() > 0;
		int size = getRestaurantMenu().size();
		assert id > 0;
		assert id <= size;
		for(MenuItem item: getRestaurantMenu()) {
			if(item.getId() != id) {
				items.add(item);
			}
		}
		
		for(MenuItem item: items) {
			if(item.getId() > id) {
				item.setId(item.getId() - 1);
			}
		}
		CompositeProduct.idMenu--;
		int newSize = items.size();
		assert newSize == size - 1;
		return items;
	}
	
	public ArrayList<MenuItem> editMenuItem(CompositeProduct product, int id) {
		assert product != null;
		assert id > 0;
		assert id <= getRestaurantMenu().size();
		ArrayList<MenuItem> items = new ArrayList<>();
		
		for(MenuItem item: getRestaurantMenu()) {
			if(item.getId() != id) {
				items.add(item);
			}
		}
		
		items.add(id, product);
		
		assert items.size() == getRestaurantMenu().size();
		Collections.sort(items);
		return items;
	
	}
	
	public void TableExample(Restaurant restaurant) {    
	    JFrame f;    
	    FileWriter writer = new FileWriter();
	    f=new JFrame();    
	    ArrayList<String> list = new ArrayList<>();
	    list = writer.deserialize(restaurant);
	    int count = 0;
	    JTable table = new JTable(new DefaultTableModel(null, new Object[]{"ID", "Name", "Price"}));
	    table.setBounds(600,800,4000,6000); 
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    
	    for(MenuItem item: this.getRestaurantMenu()) {
	    	
	    	String giveId = new String(Integer.toString(item.getId()));
	    	String giveName = list.get(count);
	    	count++;
	    	String givePrice = new String(Double.toString(item.getPrice()));
	    
	    	model.addRow(new Object[]{giveId, giveName, givePrice});
	    }
	    JScrollPane sp=new JScrollPane(table);    
	    f.add(sp);          
	    f.setSize(600,800);    
	    f.setVisible(true);   
	}     
	
	public Order giveOrderDetails(int orderId, String date, int table) {
		StringTokenizer st = new StringTokenizer(date, ", ");
		int count = 0;
		int year = 0;
		int month = 0;
		int day = 0;
		double price = 0.0;
		String name = "";
		while(st.hasMoreTokens()) {  
			if(count == 0) {
				year = Integer.parseInt(st.nextToken());
			}
			else if(count == 1) {
				month = Integer.parseInt(st.nextToken());
			}
			else if(count == 2) {
				day = Integer.parseInt(st.nextToken());
			}
			count++;
		}
		Date date2 = new Date(year, month, day);
		//System.out.println("HEre " + date2.getYear() + " " + date2.getMonth() + " " + date2.getDay());
		Order order = new Order(orderId, date2, table);
		return order;
	}
	
	public void createNewOrder(int orderId, String date, int table, String menuIds) {
		Order order = giveOrderDetails(orderId, date, table);
		assert orderId > 0;
		assert menuIds != null;
		int size = orderDetails.size();
		//System.out.println("DADA: " + order.getDate().getYear());
		ArrayList<MenuItem> orderItems = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(menuIds, ", ");
		int id = 0;
		double price = 0.0;
		String name = "";
		
		while(st.hasMoreTokens()) {  
			id = Integer.parseInt(st.nextToken());
			for(MenuItem items: getRestaurantMenu()) {
				if(items.getId() == id) {
					orderItems.add(items);
					name += items.getProductName() + " ";
					break;
				}
			}
		}
		
		this.orderDetails.put(order, orderItems);
		int newSize = orderDetails.size();
		assert newSize == size + 1;
		setChanged();
		notifyObservers(name);
	}
	
	public void createOrderBill(int orderId) {
		PrintWriter writer = null;
		assert orderId > 0;
		assert orderId <= orderDetails.size();
		try {
			writer = new PrintWriter("Order" + orderId + ".txt", "UTF-8"); //create a file for each student
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("Couldn't create file");
		}
		  Set<Map.Entry<Order, ArrayList<MenuItem>>> set = this.orderDetails.entrySet(); 
		    
		    for(Map.Entry<Order, ArrayList<MenuItem>> me : set) {   
		    	if(orderId == me.getKey().getOrderId()) {
		    		String command = "";
			    	for(MenuItem item: me.getValue()) {
			    		command += item.getProductName() + "; ";
			    	}
		    		writer.println("The client ordered: " + command);
		    		writer.println("The total price was: " + computePriceOrder(orderId));
		    		
		    	}
		    }
		    
		    writer.close();
	}
	
	public void orderTable() {    
	    JFrame f;    
	        
	    f=new JFrame();    
	  
	    JTable table = new JTable(new DefaultTableModel(null, new Object[]{"orderId", "orderDate", "orderTable", "menuItems"}));
	    table.setBounds(600,800,4000,6000); 
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    
	    
	    int orderId = 0;
	    int tableNumber = 0;
	    
	    Set<Map.Entry<Order, ArrayList<MenuItem>>> set = this.orderDetails.entrySet(); 
	    
	    for(Map.Entry<Order, ArrayList<MenuItem>> me : set) {   
	    	System.out.print(me.getKey() + ": "); 
	    	
	    	orderId = me.getKey().getOrderId();
	    	
	    	Calendar calendar = Calendar.getInstance();
	    	String dateAsString = "";
	    	calendar.setTime(me.getKey().getDate());
			dateAsString += Integer.toString(me.getKey().getDate().getYear()) + " ";
			dateAsString += Integer.toString(calendar.get(Calendar.MONTH)) + " ";
			dateAsString += Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)) + " ";
	    
	    	tableNumber = me.getKey().getTableNumber();
	    	String command = "";
	    	for(MenuItem item: me.getValue()) {
	    		command += item.getProductName() + "; ";
	    	}
	    	//System.out.println(me.getValue());   
	    	 model.addRow(new Object[]{orderId, dateAsString, tableNumber, command});
	    } 
	    
	   
	    
	    JScrollPane sp=new JScrollPane(table);    
	    f.add(sp);          
	    f.setSize(600,800);    
	    f.setVisible(true);   
	}     
	
	public double computePriceOrder(int orderId) {
		double price = 0.0;
		assert orderId > 0;
		assert orderId <= orderDetails.size();
		 Set<Map.Entry<Order, ArrayList<MenuItem>>> set = this.orderDetails.entrySet(); 
		    
		    for(Map.Entry<Order, ArrayList<MenuItem>> me : set) {   
		    	if(me.getKey().getOrderId() == orderId) {
		    		
		    		for(MenuItem item: me.getValue()) {
		    			price += item.getPrice();
		    		}
		    		
		    	}
		    }
		
		return price;
	}
	
	public boolean isWellFormed() {
		
		if(this.getRestaurantMenu().size() <= 0)
			return false;
		else if(this.orderDetails.isEmpty())
			return false;
		else if(this.getRestaurantMenu().get(0).getId() < 0 || this.getRestaurantMenu().get(0).getProductName() == null || this.getRestaurantMenu().get(0).getPrice() < 0.0)
			return false;
		
		return true;
	}
	

	public ArrayList<MenuItem> getRestaurantMenu() {
		return restaurantMenu;
	}

	public void setRestaurantMenu(ArrayList<MenuItem> restaurantMenu) {
		this.restaurantMenu = restaurantMenu;
	}
	
}
