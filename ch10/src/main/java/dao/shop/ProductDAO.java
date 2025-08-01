package dao.shop;

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

import dto.shop.ProductDTO;
import util.DBHelper;

public class ProductDAO{

	public static final ProductDAO INSTANCE = new ProductDAO();
	public static ProductDAO getInstance() {
		return INSTANCE;
	}
	
	private ProductDAO() {}
	
	private final String DBCP = "jdbc/shop";
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertProduct(ProductDTO dto) {
		
		try {
			
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/shop");
			
			logger.info(dto.getPno());
			
			Connection conn = ds.getConnection();
			
			String sql = "INSERT INTO PRODUCT VALUES (?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPno());
			psmt.setString(2, dto.getPname());
			psmt.setString(3, dto.getStock());
			psmt.setString(4, dto.getPrice());
			psmt.setString(5, dto.getCompany());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			logger.warn(e.getMessage());
		}
		
	}
	
	public ProductDTO selectProduct(String pno) {
		
		ProductDTO dto = null;
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/shop");
			Connection conn = ds.getConnection();
			
			
			String sql = "SELECT * FROM PRODUCT WHERE PNO=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, pno);
			
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new ProductDTO();
				dto.setPno(rs.getString(1));
				dto.setPname(rs.getString(2));
				dto.setStock(rs.getString(3));
				dto.setPrice(rs.getString(4));
				dto.setCompany(rs.getString(5));
			}
			
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return dto;
	}
	
	public List<ProductDTO> selectAllProduct() {
		
		List<ProductDTO> dtoList = new ArrayList<>();
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/shop");
			Connection conn = ds.getConnection();
			
			String sql = "SELECT * FROM PRODUCT";
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setPno(rs.getString(1));
				dto.setPname(rs.getString(2));
				dto.setStock(rs.getString(3));
				dto.setPrice(rs.getString(4));
				dto.setCompany(rs.getString(5));
				
				dtoList.add(dto);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return dtoList;
	}
	
	public void updateProduct(ProductDTO dto) {
		
		
		
	}
	
	public void deleteProduct(String pno) {
		
	}
}
