package service;

import java.util.List;

import dao.StudentDAO;
import dto.StudentDTO;

public enum StudentService {
	INSTANCE;
	
	private StudentDAO dao = StudentDAO.getInstance();
	
	public StudentDAO findById(String stdNo) {
		return dao.select(stdNo);
	}
	public List<StudentDTO> findAll() {
		return dao.selectAll();
	}
	public void regist(StudentDTO dto) {
		dao.insert(dto);
	}
	public void modify(StudentDTO dto) {
		dao.update(dto);
	}
	public void delete(String stdNo) {
		dao.delete(stdNo);
	}
}
