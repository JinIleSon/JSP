package jboard.dao;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jboard.dto.ArticleDTO;
import jboard.util.DBHelper;
import jboard.util.Sql;

public class ArticleDAO extends DBHelper{

	private final static ArticleDAO INSTANCE = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return INSTANCE;
	}
	private ArticleDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int insert(ArticleDTO dto) {
		int ano = 0;
		try {
			conn = getConnection();
			
			conn.setAutoCommit(false);
			
			psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getFile_cnt());
			psmt.setString(4, dto.getWriter());
			psmt.setString(5, dto.getReg_ip());
			psmt.executeUpdate();
			
			// 방금 INSERT한 글 번호 조회
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MAX_ANO);
			
			if(rs.next()) {
				ano = rs.getInt(1);
			}
			conn.commit(); // 작업완료
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error(e1.getMessage());
			}
		}
		return ano;
	}
	public ArticleDTO select(int ano) {
		return null;
	}
	public List<ArticleDTO> selectAll() {
		return null;
	}
	public void update(ArticleDTO dto) {}
	public void delete(int ano) {}
}
