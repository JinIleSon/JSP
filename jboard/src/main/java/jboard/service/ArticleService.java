package jboard.service;

import java.util.List;

import jboard.dao.ArticleDAO;
import jboard.dto.ArticleDTO;

public enum ArticleService {

	INSTANCE;
	
	private ArticleDAO dao = ArticleDAO.getInstance();
	
	public int register(ArticleDTO dto) {
		return dao.insert(dto);
	}
	public ArticleDTO findById(int ano) {
		return dao.select(ano);
	}
	public List<ArticleDTO> findAll() {
		return dao.selectAll();
	}
	public void modify(ArticleDTO dto) {
		dao.update(dto);
	}
	public void remove(int ano) {
		dao.delete(ano);
	}
	
}
