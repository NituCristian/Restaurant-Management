package presentation_layer;


import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

import business_layer.Order;

public class WaiterGraphicalUserInterface extends JFrame{
	
	private JTextField giveOrderId = new JTextField(30);
	private JTextField giveOrderDate = new JTextField(30);
	private JTextField giveOrderTable = new JTextField(30);
	private JTextField giveMenuIds = new JTextField(30);
	
	public JTextField getGiveOrderId() {
		return giveOrderId;
	}

	public void setGiveOrderId(JTextField giveOrderId) {
		this.giveOrderId = giveOrderId;
	}

	public JTextField getGiveOrderDate() {
		return giveOrderDate;
	}

	public void setGiveOrderDate(JTextField giveOrderDate) {
		this.giveOrderDate = giveOrderDate;
	}

	public JTextField getGiveOrderTable() {
		return giveOrderTable;
	}

	public void setGiveOrderTable(JTextField giveOrderTable) {
		this.giveOrderTable = giveOrderTable;
	}

	public JTextField getGiveMenuIds() {
		return giveMenuIds;
	}

	public void setGiveMenuIds(JTextField giveMenuIds) {
		this.giveMenuIds = giveMenuIds;
	}


	private JButton createOrder = new JButton("Create new order");
	private JButton showOrders = new JButton("Show orders");
	private JButton computeBill = new JButton("Compute order bill");
	private JButton main = new JButton("Back to main panel");
	
	public WaiterGraphicalUserInterface() {
		JPanel panel1 = new JPanel();   
		JPanel panel2 = new JPanel();   
		JPanel panel3 = new JPanel();  
		JPanel panel4 = new JPanel();   
		JPanel panel5 = new JPanel();  
		JPanel panel6 = new JPanel();
		
		panel1.add(new JLabel("Order id is"));
		panel1.add(giveOrderId);
		
		panel2.add(new JLabel("Order date is"));
		panel2.add(giveOrderDate);
		
		panel3.add(new JLabel("Order table is"));
		panel3.add(giveOrderTable);
		
		panel4.add(new JLabel("Give menu ids"));
		panel4.add(giveMenuIds);
		
		panel5.add(createOrder);
		panel5.add(showOrders);
		panel5.add(computeBill);
		
		panel6.add(main);
		
		JPanel p = new JPanel();  
		p.add(panel1);   
		p.add(panel2); 
		p.add(panel3);
		p.add(panel4);
		p.add(panel5);
		p.add(panel6);
		
		p.setLayout(new BoxLayout(p, BoxLayout. Y_AXIS ));  
		this.setContentPane(p);
		
		this.pack();               
		this.setTitle("Waiter");  
		  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createOrderListener(ActionListener listener) {
		createOrder.addActionListener(listener);
	}
	
	public void showOrdersListener(ActionListener listener) {
		showOrders.addActionListener(listener);
	}
	
	public void computeBillListener(ActionListener listener) {
		computeBill.addActionListener(listener);
	}
		
	public void addMainPanelListener(ActionListener listener) {
		main.addActionListener(listener);
	}
		
}
