package dao.library;

import java.util.ArrayList;
import java.util.List;

import dto.library.BookDTO;
import util.DBHelper;

public class BookDAO extends DBHelper{

	private static final BookDAO INSTANCE = new BookDAO();
	public static BookDAO getInstance() {
		return INSTANCE;
	}
	
	private BookDAO() {}
	
	private String DBCP = "jdbc/library";
	
	public void insertBook(BookDTO dto) {
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("insert into book values (?,?,?,?,?,?)");
			psmt.setInt(1, dto.getBook_id());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getAuthor());
			psmt.setString(4, dto.getPublisher());
			psmt.setString(5, dto.getAvailable());
			psmt.setString(6, dto.getReg_date());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public BookDTO selectBook(String book_id) {
		BookDTO dto = null;
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("select * from book where book_id=?");
			psmt.setString(1, book_id);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new BookDTO();
				dto.setBook_id(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAuthor(rs.getString(3));
				dto.setPublisher(rs.getString(4));
				dto.setAvailable(rs.getString(5));
				dto.setReg_date(rs.getString(6));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public List<BookDTO> selectAllBook() {
		List<BookDTO> dtoList = new ArrayList<BookDTO>();
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("select * from book");
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setBook_id(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAuthor(rs.getString(3));
				dto.setPublisher(rs.getString(4));
				dto.setAvailable(rs.getString(5));
				dto.setReg_date(rs.getString(6));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	public void updateBook(BookDTO dto) {
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("update book set book_id=?, title=?, author=?, publisher=?, available=?, reg_date=? where book_id=?");
			psmt.setInt(1, dto.getBook_id());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getAuthor());
			psmt.setString(4, dto.getPublisher());
			psmt.setString(5, dto.getAvailable());
			psmt.setString(6, dto.getReg_date());
			psmt.setInt(7, dto.getBook_id());
			
			psmt.executeUpdate();
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteBook(String book_id) {
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("delete from book where book_id=?");
			psmt.setString(1, book_id);
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
