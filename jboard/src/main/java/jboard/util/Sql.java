package jboard.util;

public class Sql {
	
	
	
	// terms
	public static final String SELECT_TERMS = "SELECT * FROM TB_TERMS where NO=?";
	
	// user
	public static final String SELECT_COUNT = "SELECT COUNT(*) FROM TB_USER ";
	public static final String WHERE_USID = "WHERE USID=?";
	public static final String WHERE_NICK = "WHERE NICK=?";
	public static final String WHERE_EMAIL = "WHERE EMAIL=?";
	public static final String WHERE_HP   = "WHERE HP=?";
	
	public static final String SELECT_USER_BY_PASS  = "SELECT * FROM tb_user WHERE usid=? AND pass=standard_hash(?, 'SHA256')";
	
	public static final String INSERT_USER = "INSERT INTO TB_USER (USID, PASS, US_NAME, NICK, EMAIL, HP, ZIP, ADDR1, ADDR2, REG_IP, REG_DATE) "
											+ "VALUES (?,STANDARD_HASH(?, 'SHA256'),?,?,?,?,?,?,?,?,SYSDATE)";
	
	// article
	public static final String SELECT_MAX_ANO = "SELECT MAX(ano) FROM TB_ARTICLE";
	public static final String INSERT_ARTICLE = "INSERT INTO TB_ARTICLE (title, content, file_cnt, writer, reg_ip, wdate) VALUES (?,?,?,?,?,sysdate)";
	
	// file
	public static final String INSERT_FILE = "INSERT INTO TB_FILE (ANO, ONAME, SNAME, RDATE) VALUES (?, ?, ?, SYSDATE)";
}