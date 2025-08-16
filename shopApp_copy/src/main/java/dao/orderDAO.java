package dao;

import java.util.List;

import dto.orderDTO;
import util.DBHelper;

public class orderDAO extends DBHelper{
	
	private static final orderDAO INSTANCE = new orderDAO();
	public static orderDAO getInstance() {
		return INSTANCE;
	}
	
	private orderDAO() {}
	
	public void insertOrder(orderDTO dto) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("insert into \"Order\" (orderid, orderproduct, ordercount, orderdate)  values (?,?,?,sysdate)");
			psmt.setString(1, dto.getOrderId());
			psmt.setInt(2, dto.getOrderProduct());
			psmt.setInt(3, dto.getOrderCount());
			
			psmt.executeUpdate();
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public orderDTO selectOrder(String orderNo) {
		return null;
	}
	public List<orderDTO> selectAllOrder() {
		return null;
	}
	public void updateOrder(orderDTO dto) {}
	public void deleteOrder(String orderNo) {}
}
