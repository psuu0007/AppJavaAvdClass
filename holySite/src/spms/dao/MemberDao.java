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

	private Connection conn;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public List<MemberDto> selectList() throws Exception{
		return this.selectList(0, 1);
	}
	
	public List<MemberDto> selectList(int pageUnit, int pageNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startNo = 0;
		int endNo = 0;
		String sql = "";
		
		if(pageUnit != 0) {
			sql += "select * from (";
		}
		sql += "SELECT ROWNUM RN, NO, NICKNAME, EMAIL, GRADE";
		sql += " FROM MEMBER";
		sql += " ORDER BY NO ASC";
		
		if(pageUnit != 0) {
			sql += ") WHERE RN BETWEEN ? AND ?";
			startNo = pageUnit * (pageNo - 1) + 1;
			endNo = pageUnit * (pageNo);
		}
		
		
		try {
			pstmt = conn.prepareStatement(sql);

			if(startNo != 0 && endNo != 0) {
				pstmt.setInt(1, startNo);
				pstmt.setInt(2, endNo);
			}
			
			rs = pstmt.executeQuery();

			ArrayList<MemberDto> memberList = 
				new ArrayList<MemberDto>();
			int no = 0;
			String nickname = "";
			String email = "";
			String grade = "";
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			while (rs.next()) {
				no = rs.getInt("NO");
				nickname = rs.getString("NICKNAME");
				email = rs.getString("EMAIL");
				grade = rs.getString("GRADE");
				
				
				MemberDto memberDto = 
					new MemberDto(no, email, "", nickname, grade);

				memberList.add(memberDto);
			}

			return memberList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// 회원등록
	public int memberInsert(MemberDto memberDto) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			String email = memberDto.getEmail();
			String pwd = memberDto.getPwd();
			String nickname = memberDto.getNickname();

			String sql = "INSERT INTO MEMBER" ;
			sql	+= " (NO, EMAIL, PWD, NICKNAME, GRADE)";
			sql	+= " VALUES(MEMBER_NO_SEQ.NEXTVAL";
			sql	+= " , ?, ?, ?, '0')";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, pwd);
			pstmt.setString(3, nickname);
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} // finally 종료

		return result;
	}

	// 회원삭제
	public int memberDelete(int no) throws SQLException {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "";
		sql = "DELETE FROM MEMBER";
		sql += " WHERE NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // finally 종료

		return result;
	}

	// 회원 상세 정보 조회
	public MemberDto memberSelectOne(int no) throws Exception {

		MemberDto memberDto = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql = "SELECT NO, EMAIL, NICKNAME, PWD, GRADE";
		sql += " FROM MEMBER";
		sql += " WHERE NO =?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();


			String nickname = "";
			String email = "";
			String pwd ="";
			String grade ="";

			if (rs.next()) {
				nickname = rs.getString("NICKNAME");
				email = rs.getString("EMAIL");
				pwd = rs.getString("pwd");
				grade = rs.getString("grade");
				

				memberDto = new MemberDto();

				memberDto.setNo(no);
				memberDto.setNickname(nickname);
				memberDto.setEmail(email);
				memberDto.setPwd(pwd);
				memberDto.setGrade(grade);

			} else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // finally 종료
		return memberDto;
	}

	// 회원 정보 변경
	public int memberUpdate(MemberDto memberDto) throws SQLException {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "";
		sql = "UPDATE MEMBER";
		sql += " SET EMAIL=?, NICKNAME=?, PWD=?, GRADE =?";
		sql += " WHERE NO =?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDto.getEmail());
			pstmt.setString(2, memberDto.getNickname());
			pstmt.setString(3, memberDto.getPwd());
			pstmt.setString(4, memberDto.getGrade());
			pstmt.setInt(5, memberDto.getNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // finally 종료
		return result;
	}
	
	// 사용자 존재 유무 없으면 null 리턴
	public MemberDto memberExist(String email, String pwd) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		
		sql += "SELECT NO, NICKNAME, EMAIL, GRADE";
		sql += " FROM MEMBER";
		sql += " WHERE EMAIL = ?";
		sql += " AND PWD = ?";
		
		String nickname = "";
		String grade ="";
		int no =0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int colIndex = 1;
			
			pstmt.setString(colIndex++, email);
			pstmt.setString(colIndex, pwd);
			
			rs = pstmt.executeQuery();
			
			MemberDto memberDto = new MemberDto();
			
			if(rs.next()) {
				no = rs.getInt("no");
				email = rs.getString("email");
				nickname = rs.getString("nickname");
				grade = rs.getString("grade");
				
				memberDto.setNo(no);
				memberDto.setEmail(email);
				memberDto.setNickname(nickname);
				memberDto.setGrade(grade);
				
				// 회원 정보 조회 확인
				return memberDto;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public int memberCheckId(MemberDto memberDto) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";

		sql = "SELECT COUNT(email) cnt";
		sql += " FROM member";
		sql += " where email = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDto.getEmail());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // finally 종료

	}
	
	public int memberCheckNickname(MemberDto memberDto) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";

		sql = "SELECT COUNT(nickname) cnt";
		sql += " FROM member";
		sql += " where nickname = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDto.getNickname());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // finally 종료

	}
	
	public int getCount() throws SQLException  {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";
		sql = "SELECT COUNT(*)";
		sql += " FROM MEMBER";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt(1);
			}

			
		}catch (SQLException e) {
			// TODO: handle exception
			throw e;
		}finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return count;
	}
	
	
}
