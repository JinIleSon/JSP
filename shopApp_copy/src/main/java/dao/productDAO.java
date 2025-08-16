package dao;

import java.util.ArrayList;
import java.util.List;

import dto.productDTO;
import util.DBHelper;

public class productDAO extends DBHelper{

	private static final productDAO INSTANCE = new productDAO();
	public static productDAO getInstance() {
		return INSTANCE;
	}
	
	private productDAO() {}
	
	public void insertProduct(productDTO dto) {}
	public productDTO selectProduct(String prodNo) {
		productDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from product where prodno=?");
			psmt.setString(1, prodNo);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new productDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setProdName(rs.getString(2));
				dto.setStock(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setCompany(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public List<productDTO> selectAllProduct() {
		List<productDTO> dtoList = new ArrayList<productDTO>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from product");
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				productDTO dto = new productDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setProdName(rs.getString(2));
				dto.setStock(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setCompany(rs.getString(5));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	public void updateProduct(productDTO dto) {}
	public void deleteProduct(String prodNo) {}
}
