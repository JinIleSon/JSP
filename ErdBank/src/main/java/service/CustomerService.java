package service;

import java.util.List;

import dao.CustomerDAO;
import dto.CustomerDTO;

public enum CustomerService {
	INSATANCE;
	
	private CustomerDAO dao = CustomerDAO.getInstance();
	
	public void register(CustomerDTO dto) {
		dao.insertCustomer(dto);
	}
	public CustomerDTO findById(String c_no) {
		return dao.selectCustomer(c_no);
	}
	public CustomerDTO findByIdAndName(String c_no, String c_name) {
		return dao.selectCustomer(c_no, c_name);
	}
	public List<CustomerDTO> findAll() {
		return dao.selectAllCustomer();
	}
	public void modify(CustomerDTO dto) {
		dao.updateCustomer(dto);
	}
	public void delete(String c_no) {
		dao.deleteCustomer(c_no);
	}
}
