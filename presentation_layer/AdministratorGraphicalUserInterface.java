
package presentation_layer;


import java.awt.event.ActionListener;
import javax.swing.*;

public class AdministratorGraphicalUserInterface extends JFrame{
	
	private JTextField giveBaseProductIds = new JTextField(20);
	private JTextField giveMenuItemId = new JTextField(20);
	
	public JTextField getGiveBaseProductIds() {
		return giveBaseProductIds;
	}
	public void setGiveBaseProductIds(JTextField giveBaseProductIds) {
		this.giveBaseProductIds = giveBaseProductIds;
	}
	public JTextField getGiveMenuItemId() {
		return giveMenuItemId;
	}
	public void setGiveMenuItemId(JTextField giveMenuItemId) {
		this.giveMenuItemId = giveMenuItemId;
	}
	
	private JButton createBaseProducts = new JButton("Create base products");
	private JButton showBaseProducts = new JButton("Show base products");
	private JButton createMenuItem = new JButton("Create menu item");
	private JButton editMenuItem = new JButton("Edit menu item");
	private JButton deleteMenuItem = new JButton("Delete menu item");
	private JButton showMenuItems = new JButton("Show menu items");
	private JButton main = new JButton("Back to main panel");
	
	public AdministratorGraphicalUserInterface() {
		JPanel panel1 = new JPanel();   
		JPanel panel2 = new JPanel();   
		JPanel panel3 = new JPanel();  
		JPanel panel4 = new JPanel();  
		
		panel1.add(new JLabel("Base products ids"));
		panel1.add(giveBaseProductIds);
		panel1.add(new JLabel("Menu item id"));
		panel1.add(giveMenuItemId);
		
		panel2.add(showBaseProducts);
		panel2.add(createBaseProducts);
		
		panel3.add(createMenuItem);
		panel3.add(editMenuItem);
		panel3.add(deleteMenuItem);
		panel3.add(showMenuItems);
		
		panel4.add(main);
		
		JPanel p = new JPanel();  
		p.add(panel1);   
		p.add(panel2); 
		p.add(panel3);
		p.add(panel4);
		
		p.setLayout(new BoxLayout(p, BoxLayout. Y_AXIS ));  
		this.setContentPane(p);
		
		this.pack();               
		this.setTitle("Administrator");  
		  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void showBaseProductsListener(ActionListener listener) {
		showBaseProducts.addActionListener(listener);
	}
	
	public void createBaseProductsListener(ActionListener listener) {
		createBaseProducts.addActionListener(listener);
	}
	
	public void createMenuItemListener(ActionListener listener) {
		createMenuItem.addActionListener(listener);
	}
	
	public void editMenuItemListener(ActionListener listener) {
		editMenuItem.addActionListener(listener);
	}
	
	public void deleteMenuItemListener(ActionListener listener) {
		deleteMenuItem.addActionListener(listener);
	}
	
	public void showMenuItemsListener(ActionListener listener) {
		showMenuItems.addActionListener(listener);
	}
	
	public void addMainPanelListener(ActionListener listener) {
		main.addActionListener(listener);
	}
		
	
}
