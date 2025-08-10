package dao.library;

import java.util.ArrayList;
import java.util.List;

import dto.library.MemberDTO;
import util.DBHelper;

public class MemberDAO extends DBHelper{

	private static final MemberDAO INSTANCE = new MemberDAO();
	public static MemberDAO getInstance() {
		return INSTANCE;
	}
	
	private MemberDAO() {}
	
	private String DBCP = "jdbc/library";
	
	public void insertMember(MemberDTO dto) {
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("insert into member values (?,?,?,?,?)");
			psmt.setInt(1, dto.getMember_id());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getAddress());
			psmt.setString(4, dto.getHp());
			psmt.setString(5, dto.getJoin_date());
			
			psmt.executeUpdate();
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public MemberDTO selectMember(String member_id) {
		
		MemberDTO dto = null;
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("select * from member where member_id=?");
			psmt.setString(1, member_id);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new MemberDTO();
				dto.setMember_id(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAddress(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setJoin_date(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public List<MemberDTO> selectAllMember() {
		List<MemberDTO> dtoList = new ArrayList<MemberDTO>();
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("select * from member");
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMember_id(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAddress(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setJoin_date(rs.getString(5));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	public void updateMember(MemberDTO dto) {
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("update member set member_id=?, name=?, address=?, hp=?, join_date=? where member_id=?");
			psmt.setInt(1, dto.getMember_id());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getAddress());
			psmt.setString(4, dto.getHp());
			psmt.setString(5, dto.getJoin_date());
			psmt.setInt(6, dto.getMember_id());
			
			psmt.executeUpdate();
			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteMember(String member_id) {
		
		try {
			
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement("delete from member where member_id=?");
			psmt.setString(1, member_id);
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
