package dao.bank;

import java.util.ArrayList;
import java.util.List;

import dto.bank.AccountDTO;
import util.DBHelper;

public class AccountDAO extends DBHelper{
	
	private static final AccountDAO INSTANCE = new AccountDAO();
	public static AccountDAO getInstance() {
		return INSTANCE;
	}
	
	private AccountDAO() {}
	
	private String DBCP = "jdbc/bank";
	
	public void insertAccount(AccountDTO dto) {
		
		try {
			
			conn = getConnection(DBCP);
			
			psmt = conn.prepareStatement("insert into account values (?,?,?,?,?,?)");
			psmt.setString(1, dto.getAcc_no());
			psmt.setString(2, dto.getAcc_type());
			psmt.setString(3, dto.getAcc_name());
			psmt.setString(4, dto.getAcc_cid());
			psmt.setString(5, dto.getAcc_balance());
			psmt.setString(6, dto.getAcc_date());
			
			psmt.executeUpdate();
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public AccountDTO selectAccount(String acc_no) {
		AccountDTO dto = null;
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("select * from account where acc_no=?");
			psmt.setString(1, acc_no);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setAcc_no(rs.getString(1));
				dto.setAcc_type(rs.getString(2));
				dto.setAcc_name(rs.getString(3));
				dto.setAcc_cid(rs.getString(4));
				dto.setAcc_balance(rs.getString(5));
				dto.setAcc_date(rs.getString(6));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public List<AccountDTO> selectAllAccount() {
		
		List<AccountDTO> dtoList = new ArrayList<AccountDTO>();
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("select * from account");
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				AccountDTO dto = new AccountDTO();
				dto.setAcc_no(rs.getString(1));
				dto.setAcc_type(rs.getString(2));
				dto.setAcc_name(rs.getString(3));
				dto.setAcc_cid(rs.getString(4));
				dto.setAcc_balance(rs.getString(5));
				dto.setAcc_date(rs.getString(6));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	public void updateAccount(AccountDTO dto) {
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("update account set acc_no=?, acc_type=?, acc_name=?, acc_cid=?, acc_balance=?, acc_date=? where acc_no=?");
			psmt.setString(1, dto.getAcc_no());
			psmt.setString(2, dto.getAcc_type());
			psmt.setString(3, dto.getAcc_name());
			psmt.setString(4, dto.getAcc_cid());
			psmt.setString(5, dto.getAcc_balance());
			psmt.setString(6, dto.getAcc_date());
			psmt.setString(7, dto.getAcc_no());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteAccount(String acc_no) {
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("delete from account where acc_no=?");
			psmt.setString(1, acc_no);
			psmt.executeUpdate();
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
