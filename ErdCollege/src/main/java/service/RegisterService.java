package service;

import java.util.List;

import dao.RegisterDAO;
import dto.RegisterDTO;

public enum RegisterService {
	INSTANCE;
	
	private RegisterDAO dao = RegisterDAO.getInstance();
	
	public RegisterDTO findById(String regStdNo, int regLecNo) {
		return dao.select(regStdNo, regLecNo);
	}
	public List<RegisterDTO> findAll(String regStdNo) {
		return dao.selectAll(regStdNo);
	}
	public void regist(RegisterDTO dto) {
		dao.insert(dto);
	}
	public void modify(RegisterDTO dto) {
		dao.update(dto);
	}
	public void delete(String regStdNo, int regLecNo) {
		dao.delete(regStdNo, regLecNo);
	}
}
