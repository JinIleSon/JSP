package dto;

public class orderDTO {

	private String orderId;
	private int orderProduct;
	private int orderCount;
	private String orderDate;
	private int orderNo_new;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getOrderProduct() {
		return orderProduct;
	}
	public void setOrderProduct(int orderProduct) {
		this.orderProduct = orderProduct;
	}
	public void setOrderProduct(String orderProduct) {
		if (orderProduct != null)
			this.orderProduct = Integer.parseInt(orderProduct);
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public void setOrderCount(String orderCount) {
		if (orderCount != null)
			this.orderCount = Integer.parseInt(orderCount);
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderNo_new() {
		return orderNo_new;
	}
	public void setOrderNo_new(int orderNo_new) {
		this.orderNo_new = orderNo_new;
	}
	public void setOrderNo_new(String orderNo_new) {
		if (orderNo_new != null)
			this.orderNo_new = Integer.parseInt(orderNo_new);
	}
	@Override
	public String toString() {
		return "orderDTO [orderId=" + orderId + ", orderProduct=" + orderProduct + ", orderCount=" + orderCount
				+ ", orderDate=" + orderDate + ", orderNo_new=" + orderNo_new + "]";
	}
}
