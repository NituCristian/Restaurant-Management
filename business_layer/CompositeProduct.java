package business_layer;


import java.util.ArrayList;
import java.util.StringTokenizer;

public class CompositeProduct extends MenuItem{
	public ArrayList<MenuItem> items = new ArrayList();
	public static int idMenu = 1;
	public CompositeProduct() {
		
	}
	
	public CompositeProduct(int id, String productName, double price, ArrayList<MenuItem> items) {
		super(id, productName, price);
		this.items = items;
	}
	
	@Override
	public double computePrice() {
		double price = 0.0;
		
		for(MenuItem item: this.items) {
			price += item.getPrice();
		}
		
		return price;
	}
	
	public CompositeProduct createCompositeProduct(String baseProductIds) {
		CompositeProduct compositeProduct = new CompositeProduct();
		BaseProduct baseProduct2 = new BaseProduct();
		StringTokenizer st = new StringTokenizer(baseProductIds, ", ");
		int id = 0;
		double price = 0.0;
		String name = "";
		while(st.hasMoreTokens()) {  
			id = Integer.parseInt(st.nextToken());
			for(MenuItem baseProduct: baseProduct2.createBaseProducts()) {
				if(baseProduct.getId() == id) {
					compositeProduct.items.add(baseProduct);
					name += baseProduct.getProductName() + " ";
					price += baseProduct.getPrice();
					break;
				}
			}
		}
		compositeProduct.setId(idMenu);
		compositeProduct.setProductName(name);
		compositeProduct.setPrice(price);
		idMenu++;
		
		return compositeProduct;
	}
	
	public CompositeProduct editCompositeProduct(String baseProductIds, int idNew) {
		CompositeProduct compositeProduct = new CompositeProduct();
		BaseProduct baseProduct2 = new BaseProduct();
		StringTokenizer st = new StringTokenizer(baseProductIds, ", ");
		int id = 0;
		double price = 0.0;
		String name = "";
		while(st.hasMoreTokens()) {  
			id = Integer.parseInt(st.nextToken());
			for(MenuItem baseProduct: baseProduct2.createBaseProducts()) {
				if(baseProduct.getId() == id) {
					compositeProduct.items.add(baseProduct);
					name += baseProduct.getProductName() + " ";
					price += baseProduct.getPrice();
					break;
				}
			}
		}
		compositeProduct.setId(idNew);
		compositeProduct.setProductName(name);
		compositeProduct.setPrice(price);
		idMenu++;
		
		return compositeProduct;
	}
	
}

