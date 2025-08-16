package service;
import java.util.List;

import dao.productDAO;
import dto.productDTO;

public enum productService {
	INSTANCE;
	
	private productDAO dao = productDAO.getInstance();
	
	public void register(productDTO dto) {
		dao.insertProduct(dto);
	}
	public productDTO findById(String prodNo) {
		return dao.selectProduct(prodNo);
	}
	public List<productDTO> findAll() {
		return dao.selectAllProduct();
	}
	public void update(productDTO dto) {
		dao.updateProduct(dto);
	}
	public void delete(String prodNo) {
		dao.deleteProduct(prodNo);
	}
}
