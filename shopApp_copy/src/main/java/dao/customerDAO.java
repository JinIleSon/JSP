package dao;

import java.util.ArrayList;
import java.util.List;

import dto.customerDTO;
import util.DBHelper;

public class customerDAO extends DBHelper{
	
	private static final customerDAO INSTANCE = new customerDAO();
	public static customerDAO getInstance() {
		return INSTANCE;
	}
	
	private customerDAO() {}
	
	public void insertCustomer(customerDTO dto) {
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement("insert into customer values (?,?,?,?,?)");
			psmt.setString(1, dto.getCustid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setString(4, dto.getAddr());
			psmt.setString(5, dto.getRdate());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public customerDTO selectCustomer(String custid) {
		customerDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from customer where custid=?");
			psmt.setString(1, custid);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto = new customerDTO();
				
				dto.setCustid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAddr(rs.getString(4));
				dto.setRdate(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public List<customerDTO> selectAllCustomer() {
		List<customerDTO> dtoList = new ArrayList<customerDTO>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from customer");
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				customerDTO dto = new customerDTO();
				
				dto.setCustid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAddr(rs.getString(4));
				dto.setRdate(rs.getString(5));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	public void updateCustomer(customerDTO dto) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("update customer set custid=?, name=?, hp=?, addr=?, rdate=? where custid=?");
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteCustomer(String custid) {}
}
