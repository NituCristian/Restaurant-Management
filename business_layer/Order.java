package business_layer;

import java.sql.Date;

public class Order{
	private int orderId;
	private Date date;
	private int tableNumber;
	
	
	public Order() {
		
	}
	
	public Order(int orderId, Date date, int tableNumber) {
		this.orderId = orderId;
		this.date = date;
		this.tableNumber = tableNumber;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}


	@Override
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (!(obj instanceof Order))
	        return false;
	    if (obj == this)
	        return true;
	    return this.getOrderId() == ((Order) obj).getOrderId();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
	    int result = 1;
	    result = prime * result + (int) (orderId ^ (orderId >>> 32));
	    result = prime * result + ((date == null) ? 0 : date.hashCode());
	    result = prime * result + (int) (tableNumber ^ (tableNumber >>> 32));
	   
	    return result;
	}
	
}
