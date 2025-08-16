package service;

import java.util.List;

import dao.RegisterDAO;
import dto.RegisterDTO;

public enum RegisterService {

	INSTANCE;
	
	private RegisterDAO dao = RegisterDAO.getInstance();
	
	public void register(RegisterDTO dto) {
		dao.insertRegister(dto);
	}
	public RegisterDTO findById(String regStdNo) {
		return dao.selectRegister(regStdNo);
	}
	public List<RegisterDTO> findAll() {
		return dao.selectAllRegister();
	}
	public void modify(RegisterDTO dto) {
		dao.updateRegister(dto);
	}
	public void delete(String regStdNo) {
		dao.deleteRegister(regStdNo);
	}
}
