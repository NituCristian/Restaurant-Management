package presentation_layer;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import business_layer.MenuItem;
import business_layer.Restaurant;

@SuppressWarnings("deprecation")
public class ChefGraphicalUserInterface extends JFrame implements Observer{

	JButton showChiefOrders = new JButton("Show chief orders");
	JButton backToMainPanel = new JButton("Back to main panel");
	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("Updated ");
		
		System.out.print("The chief has to cook: ");

		
		System.out.println(((String)arg));
		System.out.println();
		
	}
	
	public ChefGraphicalUserInterface() {
		showChiefOrders.setPreferredSize(new Dimension(200, 50));
		backToMainPanel.setPreferredSize(new Dimension(200, 50));
		
		JPanel panel1 = new JPanel(); 
		//panel1.add(new JLabel("Show chief orders "));
		panel1.add(showChiefOrders);
		
		JPanel panel2 = new JPanel();
		panel2.add(backToMainPanel);
		
		JPanel p = new JPanel();  
		p.add(panel1);   
		p.add(panel2);
		
		p.setLayout(new BoxLayout(p, BoxLayout. Y_AXIS ));  
		this.setContentPane(p);
		
		this.pack();               
		this.setTitle("Administrator");  
		  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void showChiefOrderListener(ActionListener listener) {
		showChiefOrders.addActionListener(listener);
	}
	
	public void addMainPanelListener(ActionListener listener) {
		backToMainPanel.addActionListener(listener);
	}
	

}
