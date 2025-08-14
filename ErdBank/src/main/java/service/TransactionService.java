package service;

import java.util.List;

import dao.TransactionDAO;
import dto.TransactionDTO;

public enum TransactionService {
	INSTANCE;
	
	private TransactionDAO dao = TransactionDAO.getInstance();
	
	public void register(TransactionDTO dto) {
		dao.insertTransaction(dto);
	}
	public TransactionDTO findById(String t_no) {
		return dao.selectTransaction(t_no);
	}
	public List<TransactionDTO> findAll() {
		return dao.selectAllTransaction();
	}
	public void modify(TransactionDTO dto) {
		dao.updateTransaction(dto);
	}
	public void delete(String t_no) {
		dao.deleteTransaction(t_no);
	}
}
