package dao;

import java.util.List;

import dto.LectureDTO;
import util.DBHelper;

public class LectureDAO extends DBHelper{

	private static final LectureDAO INSTANCE = new LectureDAO();
	public static LectureDAO getInstance() {
		return INSTANCE;
	}
	
	private LectureDAO() {}
	
	// 기본 CRUD
	public LectureDTO select(int lecNo) {
		return null;
	}
	public List<LectureDTO> selectAll() {
		return null;
	}
	public void insert(LectureDTO dto) {}
	public void update(LectureDTO dto) {}
	public void delete(int lecNo) {}
	
}
