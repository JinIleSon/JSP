package service;

import java.util.List;

import dao.orderDAO;
import dto.orderDTO;

public enum orderService {

	INSTANCE;
	
	private orderDAO dao = orderDAO.getInstance();
	
	public void register(orderDTO dto) {
		dao.insertOrder(dto);
	}
	public orderDTO findById(String orderNo) {
		return dao.selectOrder(orderNo);
	}
	public List<orderDTO> findAll() {
		return dao.selectAllOrder();
	}
	public void update(orderDTO dto) {
		dao.updateOrder(dto);
	}
	public void delete(String orderNo) {
		dao.deleteOrder(orderNo);
	}
}
