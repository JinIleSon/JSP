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
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM TB_ARTICLE";
	public static final String SELECT_ARTICLE_ALL = "SELECT A.*, U.nick FROM TB_ARTICLE A "
													+ "JOIN TB_USER U ON A.WRITER = U.USID "
													+ "ORDER BY ANO DESC "
													+ "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
	
	public final static String SELECT_ARTICLE_WITH_FILE = "SELECT A.*, U.NICK, F.*\r\n"
														+ "FROM TB_ARTICLE A\r\n"
														+ "JOIN TB_USER U ON A.WRITER = U.USID \r\n"
														+ "LEFT JOIN TB_FILE F ON A.ANO = F.ANO\r\n"
														+ "WHERE A.ANO = ?";
	
	public static final String SELECT_MAX_ANO = "SELECT MAX(ano) FROM TB_ARTICLE";
	public static final String INSERT_ARTICLE = "INSERT INTO TB_ARTICLE (title, content, file_cnt, writer, reg_ip, wdate) VALUES (?,?,?,?,?,sysdate)";
	
	// comment
	public static final String INSERT_COMMENT = "INSERT INTO TB_COMMENT (ANO, CONTENT, WRITER, REG_IP, WDATE)\r\n"
												+ "	VALUES (?,?,?,?, SYSDATE)";
	
	public static final String SELECT_COMMENT_ALL = "SELECT C.*, U.NICK FROM tb_comment C \r\n"
													+ "JOIN TB_USER U ON C.WRITER = U.USID\r\n"
													+ "WHERE ano = ? ORDER BY cno asc";
	
	public static final String SELECT_COMMENT_LATEST = "SELECT C.*, U.NICK FROM tb_comment C\r\n"
														+ "JOIN TB_USER U ON C.WRITER = U.USID\r\n"
														+ "WHERE cno = (SELECT MAX(cno) FROM TB_COMMENT)";
	
	// file
	public static final String INSERT_FILE = "INSERT INTO TB_FILE (ANO, ONAME, SNAME, RDATE) VALUES (?, ?, ?, SYSDATE)";
	public static final String SELECT_FILE = "SELECT * FROM tb_file WHERE fno = ?";
	public static final String UPDATE_FILE_DOWNLOAD = "UPDATE TB_FILE SET download = download + 1 WHERE fno = ?";
}