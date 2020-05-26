package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDao {

	private Connection conn;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public String findPwdByEmail(String email) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String pwd = "";
		String sql = "";
		
		sql ="Select pwd";
		sql += " from member";
		sql += " where email = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pwd = rs.getString("pwd");
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("dao findPwdByEmail sql 에러");
		}	finally {
			try {
				if(rs != null)
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	try {
				if(pstmt != null)
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return pwd;
		
	}
	
}
