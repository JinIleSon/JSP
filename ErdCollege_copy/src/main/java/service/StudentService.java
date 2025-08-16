package service;

import java.util.List;

import dao.StudentDAO;
import dto.StudentDTO;

public enum StudentService {
	INSTANCE;
	
	private StudentDAO dao = StudentDAO.getInstance();
	
	public void register(StudentDTO dto) {
		dao.insertStudent(dto);
	}
	public StudentDTO findById(String stdNo) {
		return dao.selectStudent(stdNo);
	}
	public StudentDTO findByIdAndName(String stdNo, String stdName) {
		return dao.selectStudent(stdNo, stdName);
	}
	public List<StudentDTO> findAll() {
		return dao.selectAllStudent();
	}
	public void modify(StudentDTO dto) {
		dao.updateStudent(dto);
	}
	public void delete(String stdNo) {
		dao.deleteStudent(stdNo);
	}
}
