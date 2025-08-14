package dao;

import java.util.List;

import dto.RegisterDTO;
import util.DBHelper;

public class RegisterDAO extends DBHelper{

	private static final RegisterDAO INSTANCE = new RegisterDAO();
	public static RegisterDAO getInstance() {
		return INSTANCE;
	}
	
	private RegisterDAO() {}
	
	public RegisterDTO select(String regStdNo, int regLecNo) {
		return null;
	}
	public List<RegisterDTO> selectAll() {
		return null;
	}
	public void insert(RegisterDTO dto) {}
	public void update(RegisterDTO dto) {}
	public void delete(String regStdNo, int regLecNo) {}
}
