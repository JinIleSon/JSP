package service;

import java.util.List;

import dao.customerDAO;
import dto.customerDTO;

public enum customerService{
	INSTANCE;
	
	private customerDAO dao = customerDAO.getInstance();
	
	public void register(customerDTO dto) {
		dao.insertCustomer(dto);
	}
	public customerDTO findById(String custid) {
		return dao.selectCustomer(custid);
	}
	public List<customerDTO> findAll() {
		return dao.selectAllCustomer();
	}
	public void update(customerDTO dto) {
		dao.updateCustomer(dto);
	}
	public void delete(String custid) {
		dao.deleteCustomer(custid);
	}


}
