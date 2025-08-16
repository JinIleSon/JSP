package dao;

import dto.studentDTO;

public class studentDAO {
	private static final studentDAO INSTANCE = new studentDAO();
	public static studentDAO getInstance() {
		return INSTANCE;
	}
	
	private studentDAO() {}
	
	public void insertStudent(studentDTO dto) {}
	public void selectStudent() {}
	public void selectAllStudent() {}
	
}
