package mtp.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mtp.login.dto.MemberDto;

public class MemberDao {

	private Connection conn;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public List<MemberDto> selectList() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT *";
		sql += " FROM MEMBER_GUEST";
		sql += " ORDER BY NO ASC";

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();
			int no = 0;
			String name = "";
			String email = "";

			while (rs.next()) {
				no = rs.getInt("NO");
				name = rs.getString("NAME");
				email = rs.getString("EMAIL");

				MemberDto memberDto = new MemberDto(no, name, email);

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
			String pwd = memberDto.getPassword();
			String name = memberDto.getName();

			String sql = "INSERT INTO MEMBER_GUEST" + " (NO, NAME, EMAIL, PWD)" + " VALUES(NO_GUEST_CHECK.NEXTVAL"
					+ " , ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, pwd);

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
		sql = "DELETE FROM MEMBER_GUEST";
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

		sql = "SELECT *";
		sql += " FROM MEMBER_GUEST";
		sql += " WHERE NO =?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			String mName = "";
			String email = "";

			if (rs.next()) {
				mName = rs.getString("NAME");
				email = rs.getString("EMAIL");

				memberDto = new MemberDto();

				memberDto.setNo(no);
				memberDto.setName(mName);
				memberDto.setEmail(email);
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
		sql = "UPDATE MEMBER_GUEST";
		sql += " SET EMAIL=?, NAME=?";
		sql += " WHERE NO =?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDto.getEmail());
			pstmt.setString(2, memberDto.getName());
			pstmt.setInt(3, memberDto.getNo());

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

		sql += "SELECT *";
		sql += " FROM MEMBER_MANAGER";
		sql += " WHERE EMAIL = ?";
		sql += " AND PWD = ?";

		String name = "";

		try {
			pstmt = conn.prepareStatement(sql);
			int colIndex = 1;

			pstmt.setString(colIndex++, email);
			pstmt.setString(colIndex, pwd);

			rs = pstmt.executeQuery();

			MemberDto memberDto = new MemberDto();

			if (rs.next()) {
				email = rs.getString("email");
				name = rs.getString("name");

				memberDto.setNo(rs.getInt("no"));
				memberDto.setEmail(email);
				memberDto.setName(name);
				memberDto.setPassword(rs.getString("pwd"));

				// 회원 정보 조회 확인
				return memberDto;
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
		}

		// 회원이 조회가 안된 경우
		return null;
	}

	// 사용자 존재 유무 없으면 null 리턴
	public MemberDto guestExist(String email, String pwd) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT *";
		sql += " FROM MEMBER_GUEST";
		sql += " WHERE EMAIL = ?";
		sql += " AND PWD = ?";

		String name = "";

		try {
			pstmt = conn.prepareStatement(sql);
			int colIndex = 1;

			pstmt.setString(colIndex++, email);
			pstmt.setString(colIndex, pwd);

			rs = pstmt.executeQuery();

			MemberDto memberDto = new MemberDto();

			if (rs.next()) {
				email = rs.getString("email");
				name = rs.getString("name");

				memberDto.setNo(rs.getInt("no"));
				memberDto.setEmail(email);
				memberDto.setName(name);
				memberDto.setPassword(rs.getString("pwd"));

				// 회원 정보 조회 확인
				return memberDto;
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
		}

		// 회원이 조회가 안된 경우
		return null;
	}
	
	public int duplecateEmail(String email) {
		int cnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "";

			sql += "SELECT count(email) as cnt";
			sql += " FROM MEMBER_GUEST";
			sql += " WHERE EMAIL = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			
			if (rs.next()) {
				
				cnt = rs.getInt("cnt");
				return cnt;
			}
		} catch (Exception e) {
			System.out.println("아이디 중복 확인 실패 : " + e);
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
		}// try end
		return cnt;
	}// duplecateID end

	public int emailCheck(String email) {
		int cnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "";

			sql += "SELECT count(pwd) as cnt";
			sql += " FROM MEMBER_GUEST";
			sql += " WHERE EMAIL = ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			
			if (rs.next()) {
				
				cnt = rs.getInt("cnt");
				return cnt;
			}
		} catch (Exception e) {
			System.out.println("아이디 중복 확인 실패 : " + e);
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
		}// try end
		return cnt;
	}// duplecateID end
	
	public String findPassWord(String email) {
		String pwdVal = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "";

			sql += "SELECT pwd";
			sql += " FROM MEMBER_GUEST";
			sql += " WHERE EMAIL = ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			
			if (rs.next()) {
				
				pwdVal = rs.getString("pwd");
				return pwdVal;
			}
		} catch (Exception e) {
			System.out.println("아이디 중복 확인 실패 : " + e);
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
		}// try end
		return pwdVal;
	}// duplecateID end
}

