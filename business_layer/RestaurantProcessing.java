package business_layer;

import java.util.ArrayList;

public interface RestaurantProcessing {
	/**
	 * @pre product != null 
	 * @post getSize() = getSize()@pre + 1
	 * @param product
	 */
	public void createMenuItem(CompositeProduct product);
	
	/**
	 *  @pre getSize() > 0 
	 *  @pre id > 0 && id <= getSize() 
	 *  @post @result = getElement(i)@pre 
	 *  @post getSize() == getSize()@pre - 1 
	 * @param id
	 * @return
	 */
	public ArrayList<MenuItem> deleteMenuItem(int id);
	
	/**
	 * @pre product != null
	 * @pre id > 0 && id <= getSize()
	 * @post getSize() == getSize()@pre
	 * @param product
	 * @param id
	 * @return
	 */
	public ArrayList<MenuItem> editMenuItem(CompositeProduct product, int id);
	
	/**
	 * @pre orderId > 0
	 * @pre menuIds != null
	 * @post getSize() = getSize()@pre + 1
	 * @param orderId
	 * @param date
	 * @param table
	 * @param menuIds
	 */
	public void createNewOrder(int orderId, String date, int table, String menuIds);
	
	/**
	 * @pre orderId > 0
	 * @pre orderId <= getSize()
	 * @param orderId
	 * @return
	 */
	public double computePriceOrder(int orderId);
	
	/**
	 * @pre orderId > 0
	 * @pre orderId <= getSize()
	 * @param orderId
	 */
	public void createOrderBill(int orderId);
}
