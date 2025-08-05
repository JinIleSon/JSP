package dao.college;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.college.CourseDTO;

public class CourseDAO {

	private static final CourseDAO INSTANCE = new CourseDAO();
	public static CourseDAO getINSTANCE() {
		return INSTANCE;
	}
	
	private CourseDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertCourse(CourseDTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/college");
			
			Connection conn = ds.getConnection();
			
			String sql = "INSERT INTO COURSE VALUES (?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getCs_id());
			psmt.setString(2, dto.getCs_name());
			psmt.setString(3, dto.getCs_credit());
			psmt.setString(4, dto.getCs_dept());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			ctx.close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	public CourseDTO selectCourse(String cs_id) {
		
		CourseDTO dto = null;
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/college");
			
			Connection conn = ds.getConnection();
			
			String sql = "SELECT * FROM COLLEGE WHERE CS_ID=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, cs_id);
			
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new CourseDTO();
				dto.setCs_id(rs.getString(1));
				dto.setCs_name(rs.getString(2));
				dto.setCs_credit(rs.getString(3));
				dto.setCs_dept(rs.getString(4));
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
	
	public List<CourseDTO> selectAllCourse() {

		List<CourseDTO> dtoList = new ArrayList<>();
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/college");
			
			Connection conn = ds.getConnection();
			
			String sql = "SELECT * FROM COLLEGE";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				CourseDTO dto = new CourseDTO();
				
				dto.setCs_id(rs.getString(1));
				dto.setCs_name(rs.getString(2));
				dto.setCs_credit(rs.getString(3));
				dto.setCs_dept(rs.getString(4));
				
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
	
	public void updateCourse(CourseDTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/college");
			
			Connection conn = ds.getConnection();
			
			
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public void deleteCourse(String cs_id) {
		
	}
}
