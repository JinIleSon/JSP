package service;

import java.util.List;

import dao.AccountDAO;
import dto.AccountDTO;

public enum AccountService {
	INSTANCE;
	
	private AccountDAO dao = AccountDAO.getInstance();
	
	public void register(AccountDTO dto) {
		dao.insertAccount(dto);
	}
	public AccountDTO findById(String a_no) {
		return dao.selectAccount(a_no);
	}
	public List<AccountDTO> findAll() {
		return dao.selectAllAccount();
	}
	public void modify(AccountDTO dto) {
		dao.updateAccount(dto);
	}
	public void delete(String a_no) {
		dao.deleteAccount(a_no);
	}
}
