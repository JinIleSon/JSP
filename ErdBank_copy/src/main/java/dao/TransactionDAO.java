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
	
	public void insertDepositTransaction(TransactionDTO dto) {
		
		try {
			
			conn = getConnection();
			psmt1 = conn.prepareStatement("insert into bank_transaction(t_a_no, t_dist, t_amount, t_datetime) values (?,3,?,sysdate)");
			psmt1.setString(1, dto.getT_a_no());
			psmt1.setInt(2, dto.getT_amount());

			psmt1.executeUpdate();
			
			psmt2 = conn.prepareStatement("update bank_account set a_balance = a_balance + ?");
			psmt2.setInt(1, dto.getT_amount());
			
			psmt2.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void insertWithdrawTransaction(TransactionDTO dto) {
		
		try {
			
			conn = getConnection();
			psmt1 = conn.prepareStatement("insert into bank_transaction(t_a_no, t_dist, t_amount, t_datetime) values (?,3,?,sysdate)");
			psmt1.setString(1, dto.getT_a_no());
			psmt1.setInt(2, -1 * dto.getT_amount());

			psmt1.executeUpdate();
			
			psmt2 = conn.prepareStatement("update bank_account set a_balance = a_balance + ?");
			psmt2.setInt(1, -1 * dto.getT_amount());
			
			psmt2.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertTransferTransaction(TransactionDTO dto, String t_a_no_to) {
		
		try {
			
			conn = getConnection();
			psmt1 = conn.prepareStatement("insert into bank_transaction(t_a_no, t_dist, t_amount, t_datetime) values (?,3,?,sysdate)");
			psmt1.setString(1, dto.getT_a_no());
			psmt1.setInt(2, dto.getT_amount());

			psmt1.executeUpdate();
			
			psmt2 = conn.prepareStatement("update bank_account set a_balance = a_balance + ? where a_no=?");
			psmt2.setInt(1, -1 * dto.getT_amount());
			psmt2.setString(2, dto.getT_a_no());
			
			psmt2.executeUpdate();
			
			psmt3 = conn.prepareStatement("update bank_account set a_balance = a_balance + ? where a_no=?");
			psmt3.setInt(1, dto.getT_amount());
			psmt3.setString(2, t_a_no_to);
			
			psmt3.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<TransactionDTO> selectTransaction(String t_a_no) {
		List<TransactionDTO> dtoList = new ArrayList<TransactionDTO>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("select * from bank_transaction where t_a_no=?");
			psmt.setString(1, t_a_no);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				TransactionDTO dto = new TransactionDTO();
				
				dto.setT_no(rs.getString(1));
				dto.setT_a_no(rs.getString(2));
				dto.setT_dist(rs.getString(3));
				dto.setT_amount(rs.getString(4));
				dto.setT_datetime(rs.getString(5));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	public List<TransactionDTO> selectAllTransaction() {
		List<TransactionDTO> dtoList = new ArrayList<TransactionDTO>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from bank_transaction");
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				TransactionDTO dto = new TransactionDTO();
				
				dto.setT_no(rs.getString(1));
				dto.setT_a_no(rs.getString(2));
				dto.setT_dist(rs.getString(3));
				dto.setT_amount(rs.getString(4));
				dto.setT_datetime(rs.getString(5));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	public void updateTransaction(TransactionDTO dto) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteTransaction(String t_no) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
