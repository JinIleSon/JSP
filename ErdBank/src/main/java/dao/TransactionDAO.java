package dao;

import java.util.ArrayList;
import java.util.List;

import dto.TransactionDTO;
import util.DBHelper;

public class TransactionDAO extends DBHelper{

	private static final TransactionDAO INSTANCE = new TransactionDAO();
	public static TransactionDAO getInstance() {
		return INSTANCE;
	}
	
	private TransactionDAO() {}
	
	public void insertTransaction(TransactionDTO dto) {}
	public TransactionDTO selectTransaction(String t_no) {
		return null;
	}
	public List<TransactionDTO> selectAllTransaction() {
		List<TransactionDTO> dtoList = new ArrayList<TransactionDTO>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from bank_transaction");
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				TransactionDTO dto = new TransactionDTO();
				dto.setT_no(rs.getInt(1));
				dto.setT_a_no(rs.getString(2));
				dto.setT_dist(rs.getInt(3));
				dto.setT_amount(rs.getInt(4));
				dto.setT_datetime(rs.getString(5));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	public void updateTransaction(TransactionDTO dto) {}
	public void deleteTransaction(String t_no) {}
}
