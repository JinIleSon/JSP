package dao.college;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.college.StudentDTO;

public class StudentDAO {
	
	private static final StudentDAO INSTANCE = new StudentDAO();
	public static StudentDAO getINSTANCE() {
		return INSTANCE;
	}
	
	private StudentDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertStudent(StudentDTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/college");
			
			Connection conn = ds.getConnection();
			
			String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getStdno());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getBirth());
			psmt.setString(4, dto.getMajor());
			psmt.setString(5, dto.getEnr_date());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			ctx.close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public StudentDTO selectStudent(String stdno) {
		StudentDTO dto = null;
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/college");
			
			Connection conn = ds.getConnection();
			
			String sql = "SELECT * FROM STUDENT WHERE STDNO=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, stdno);
			
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new StudentDTO();
				dto.setStdno(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setMajor(rs.getString(4));
				dto.setEnr_date(rs.getString(5));
				
			}
			
			rs.close();
			psmt.close();
			conn.close();
			ctx.close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return dto;
	}
	
	public List<StudentDTO> selectAllStudent() {
		
		List<StudentDTO> dtoList = new ArrayList<>();
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/college");
			
			Connection conn = ds.getConnection();
			
			String sql = "SELECT * FROM STUDENT";
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStdno(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setMajor(rs.getString(4));
				dto.setEnr_date(rs.getString(5));
				
				dtoList.add(dto);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			ctx.close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return dtoList;
	}
	
	public void updateStudent(StudentDTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/college");
			
			Connection conn = ds.getConnection();
			
			String sql = "UPDATE STUDENT SET STDNO=?, NAME=?, BIRTH=?, MAJOR=?, ENR_DATE=? WHERE STDNO=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getStdno());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getBirth());
			psmt.setString(4, dto.getMajor());
			psmt.setString(5, dto.getEnr_date());
			psmt.setString(6, dto.getStdno());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			ctx.close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	public void deleteStudent(String stdno) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/college");
			
			Connection conn = ds.getConnection();
			
			String sql = "DELETE FROM STUDENT WHERE STDNO=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdno);
			
			psmt.executeUpdate();
			psmt.close();
			conn.close();
			ctx.close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
