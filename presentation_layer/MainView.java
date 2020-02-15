package presentation_layer;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MainView extends JFrame{

	private JButton admin = new JButton("Admin table");
	private JButton waiter = new JButton("Waiter table");
	private JButton chief = new JButton("Chief table");

	public MainView() {
	
		admin.setPreferredSize(new Dimension(500, 50));
		waiter.setPreferredSize(new Dimension(500, 50));
		chief.setPreferredSize(new Dimension(500, 50));
		
		JPanel panel1 = new JPanel();   
		JPanel panel2 = new JPanel();   
		JPanel panel3 = new JPanel();  
	
		panel1.add(admin);
		panel2.add(waiter);
		panel3.add(chief);
		
		JPanel p = new JPanel();  
		p.add(panel1);   
		p.add(panel2); 
		p.add(panel3);
	
	
		p.setLayout(new BoxLayout(p, BoxLayout. Y_AXIS ));  
		this.setContentPane(p);
		
		this.pack();               
		this.setTitle("Main");  
		  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addAdminListener(ActionListener listener) {
		admin.addActionListener(listener);
	}
	
	public void addWaiterListener(ActionListener listener) {
		waiter.addActionListener(listener);
	}
	
	public void addChiefListener(ActionListener listener) {
		chief.addActionListener(listener);
	}

}
