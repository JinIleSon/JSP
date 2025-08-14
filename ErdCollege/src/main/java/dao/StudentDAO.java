package dao;

import java.util.ArrayList;
import java.util.List;

import dto.StudentDTO;
import util.DBHelper;

public class StudentDAO extends DBHelper{

	private static final StudentDAO INSTANCE = new StudentDAO();
	public static StudentDAO getInstance() {
		return INSTANCE;
	}
	private StudentDAO() {}
	
	public StudentDTO select(String stdNo) {
		
		StudentDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from student where stdNo = ?");
			psmt.setString(1, stdNo);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new StudentDTO();
				dto.setStdNo(rs.getString(1));
				dto.setStdName(rs.getString(2));
				dto.setStdHp(rs.getString(3));
				dto.setStdYear(rs.getInt(4));
				dto.setStdAddress(rs.getString(5));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return dto;
	}
	public StudentDTO select(String stdNo, String stdName) {
		
		StudentDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from student where stdNo=? and stdName=?");
			psmt.setString(1, stdNo);
			psmt.setString(2, stdName);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new StudentDTO();
				dto.setStdNo(rs.getString(1));
				dto.setStdName(rs.getString(2));
				dto.setStdHp(rs.getString(3));
				dto.setStdYear(rs.getInt(4));
				dto.setStdAddress(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public List<StudentDTO> selectAll() {
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from student");
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStdNo(rs.getString(1));
				dto.setStdName(rs.getString(2));
				dto.setStdHp(rs.getString(3));
				dto.setStdYear(rs.getInt(4));
				dto.setStdAddress(rs.getString(5));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	public void insert(StudentDTO dto) {
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement("insert into student values (?,?,?,?,?)");
			psmt.setString(1, dto.getStdNo());
			psmt.setString(2, dto.getStdName());
			psmt.setString(3, dto.getStdHp());
			psmt.setInt(4, dto.getStdYear());
			psmt.setString(5, dto.getStdAddress());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(StudentDTO dto) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("update student set stdno=?, stdname=?, stdhp=?, stdyear=?, stdaddress=? where stdno=?");
			psmt.setString(1, dto.getStdNo());
			psmt.setString(2, dto.getStdName());
			psmt.setString(3, dto.getStdHp());
			psmt.setInt(4, dto.getStdYear());
			psmt.setString(5, dto.getStdAddress());
			psmt.setString(6, dto.getStdNo());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void delete(String stdNo) {
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement("delete from register where regstdno=?");
			psmt.setString(1, stdNo);
			psmt.executeUpdate();
			
			psmt = conn.prepareStatement("delete from student where stdNo=?");
			psmt.setString(1, stdNo);
			psmt.executeUpdate();
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
