package service;

import java.util.List;

import dao.LectureDAO;
import dto.LectureDTO;

public enum LectureService {
	INSTANCE;
	
	private LectureDAO dao = LectureDAO.getInstance();
	
	public void register(LectureDTO dto) {
		dao.insertLecture(dto);
	}
	public LectureDTO findById(String lecNo) {
		return dao.selectLecture(lecNo);
	}
	public List<LectureDTO> findAll() {
		return dao.selectAllLecture();
	}
	public void modify(LectureDTO dto) {
		dao.updateLecture(dto);
	}
	public void delete(String lecNo) {
		dao.deleteLecture(lecNo);
	}
}
