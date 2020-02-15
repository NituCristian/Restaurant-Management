package business_layer;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class BaseProduct extends MenuItem{
	
	public ArrayList<MenuItem> baseProducts = new ArrayList<>();
	public BaseProduct() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseProduct(int id, String productName, double price) {
		super(id, productName, price);
	}
	
	public ArrayList<MenuItem> createBaseProducts() {
		baseProducts.add(new BaseProduct(1, "piept de pui", 20.0));
		baseProducts.add(new BaseProduct(2, "salata", 6.3));
		baseProducts.add(new BaseProduct(3, "cartofi", 8.25));
		baseProducts.add(new BaseProduct(4, "apa", 4.5));
		baseProducts.add(new BaseProduct(5, "prajitura", 11.9));
		baseProducts.add(new BaseProduct(6, "placinta", 9.8));
		baseProducts.add(new BaseProduct(7, "suc", 5.0));
		baseProducts.add(new BaseProduct(8, "snitel de porc", 18.4));
		
		return baseProducts;
	}
	
	public void TableExample() {    
	    JFrame f;    
	    f=new JFrame();    
	    JTable table = new JTable(new DefaultTableModel(null, new Object[]{"ID", "Name", "Price"}));
	    table.setBounds(600,800,4000,6000); 
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    
	    for(MenuItem baseProduct: this.baseProducts) {	
	    	String giveId = new String(Integer.toString(baseProduct.getId()));
	    	String giveName = baseProduct.getProductName();
	    	String givePrice = new String(Double.toString(baseProduct.getPrice()));
	  
	    	model.addRow(new Object[]{giveId, giveName, givePrice});
	    }
	    
	    JScrollPane sp=new JScrollPane(table);    
	    f.add(sp);          
	    f.setSize(600,800);    
	    f.setVisible(true);   
	}     
	
	@Override
	public double computePrice() {
		return this.getPrice();
	}
	
}
