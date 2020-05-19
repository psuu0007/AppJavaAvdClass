package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import spms.dto.MemberDto;

public class MemberDao {

	private Connection connection;
	
	// 주입 -> 의존 
	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	public List<MemberDto> selectList() throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE";
		sql += " FROM MEMBER";
		sql += " ORDER BY MNO ASC";
		
		try {
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			ArrayList<MemberDto> memberList = 
				new ArrayList<MemberDto>();
			
			int no = 0;
			String name = "";
			String email = "";
			Date creDate = null;
			
			while (rs.next()) {
				no = rs.getInt("mno");
				name = rs.getString("mname");
				email = rs.getString("email");
				creDate = rs.getDate("cre_date");
				
				MemberDto memberDto = 
					new MemberDto(no, name, email, creDate);
				
				memberList.add(memberDto);
			}
		
			return memberList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public int memberInsert(MemberDto memberDto) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String email = memberDto.getEmail();
			String pwd = memberDto.getPassword();
			String name = memberDto.getName();
			
			String sql = "insert into member";
			sql += " value(mno, email, pwd, mname, cre_date, mod_date)";
			sql += " values(member_mno_seq.nextval";
			sql += " , ?, ?, ?, sysdate, sysdate)";
			
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // finally 종료
		
		return result;
		
	} // memberInsert 종료
	
}



