package dao.college;

import util.DBHelper;

public class StudentDAO extends DBHelper {

	private static final StudentDAO INSTANCE = new StudentDAO();
	public static StudentDAO getInstance() {
		return INSTANCE;
	}
	private StudentDAO() {}
	
	public void insertStudent() {}
	
	public void selectStudent() {}
	
	public void selectAllStudent() {}
	
	public void updateStudent() {}
	
	public void deleteStudent() {}
	
	
}
