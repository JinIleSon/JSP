package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User5DTO;
import util.DBHelper;

public class User5DAO extends DBHelper{
	
	private static final User5DAO INSTANCE = new User5DAO();
	public static User5DAO getInstance() {
		return INSTANCE;
	}
	
	private String DBCP = "jdbc/studydb";
	
	public void insertUser5(User5DTO dto) {
		
		try {
			
			conn = getConnection(DBCP);
			
			psmt = conn.prepareStatement("insert into user5 values (?,?,?,?,?)");
			psmt.setInt(1, dto.getSeq());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getGender());
			psmt.setInt(4, dto.getAge());
			psmt.setString(5, dto.getAddr());
			
			psmt.executeUpdate();
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public User5DTO selectUser5(String seq) {
		User5DTO dto = null;
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("select * from user5 where seq=?");
			psmt.setString(1, seq);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new User5DTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getString(4));
				dto.setAddr(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return dto;
	}
	public List<User5DTO> selectAllUser5() {
		List<User5DTO> dtoList = new ArrayList<User5DTO>();
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("select * from user5");
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				User5DTO dto = new User5DTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getString(4));
				dto.setAddr(rs.getString(5));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	public void updateUser5(User5DTO dto) {
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("update user5 set seq=?, name=?, gender=?, age=?, addr=? where seq=?");
			psmt.setInt(1, dto.getSeq());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getGender());
			psmt.setInt(4, dto.getAge());
			psmt.setString(5, dto.getAddr());
			psmt.setInt(6, dto.getSeq());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteUser5(String seq) {
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("delete from user5 where seq=?");
			psmt.setString(1, seq);
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} 
