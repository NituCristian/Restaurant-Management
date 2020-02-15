package business_layer;

public class MenuItem implements Comparable<MenuItem>{

	private int id;
	private String productName;
	private double price;
	
	public MenuItem() {
		
	}
	
	public MenuItem(int id, String productName, double price) {
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double computePrice() {
		return this.price;
	}

	@Override
	public int compareTo(MenuItem o) {
		// TODO Auto-generated method stub
		return this.id - o.id;
	}
}
