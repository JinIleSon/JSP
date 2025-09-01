package jboard.dao;

import java.util.List;

import jboard.dto.TermsDTO;
import jboard.util.DBHelper;

public class TermsDAO extends DBHelper{

	private final static TermsDAO INSTANCE = new TermsDAO();
	public static TermsDAO getInstance() {
		return INSTANCE;
	}
	private TermsDAO() {}
	
	public void insert(TermsDTO dto) {}
	public TermsDTO select(int no) {
		return null;
	}
	public List<TermsDTO> selectAll() {
		return null;
	}
	public void update(TermsDTO dto) {}
	public void delete(int no) {}
}
