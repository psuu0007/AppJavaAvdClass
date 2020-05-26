package mtp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mtp.dto.MemberDto;

public class MemberDao {
	private Connection conn;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<MemberDto> adminCheck() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT NO, NAME, EMAIL, PWD";
		sql += " FROM MEMBER_MANAGER";
		sql += " ORDER BY NO ASC";

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			ArrayList<MemberDto> adminList = new ArrayList<MemberDto>();
			int no = 0;
			String name = "";
			String email = "";
			String password = "";

			while (rs.next()) {
				no = rs.getInt("no");
				name = rs.getString("name");
				email = rs.getString("email");
				password = rs.getString("pwd");

				MemberDto adminDto = new MemberDto(no, name, email, password);

				adminList.add(adminDto);
			}

			return adminList;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public ArrayList<MemberDto> memberCheck() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT NO, NAME, EMAIL, PWD";
		sql += " FROM MEMBER_GUEST";
		sql += " ORDER BY NO ASC";

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();
			int no = 0;
			String name = "";
			String email = "";
			String password = "";

			while (rs.next()) {
				no = rs.getInt("no");
				name = rs.getString("name");
				email = rs.getString("email");
				password = rs.getString("pwd");

				MemberDto memberDto = new MemberDto(no, name, email, password);

				memberList.add(memberDto);
			}

			return memberList;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public int adminDataDelete(int no) throws SQLException {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "";
		sql += "DELETE FROM MEMBER_MANAGER";
		sql += " WHERE NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
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
		}
		return result;
	}

	public int MemberDataDelete(int no) throws SQLException {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "";
		sql += "DELETE FROM MEMBER_GUEST";
		sql += " WHERE NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
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
		}
		return result;
	}

	public MemberDto adminSelectThis(int no) throws Exception {

		MemberDto memberDto = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		;

		String sql = "";

		sql = "SELECT NO, EMAIL, NAME, PWD";
		sql += " FROM MEMBER_MANAGER";
		sql += " WHERE NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			String name = "";
			String email = "";
			String pwd = "";

			if (rs.next()) {
				name = rs.getString("NAME");
				email = rs.getString("EMAIL");
				pwd = rs.getString("PWD");

				memberDto = new MemberDto();

				memberDto.setNo(no);
				memberDto.setName(name);
				memberDto.setEmail(email);
				memberDto.setPassword(pwd);
			} else {
				throw new Exception("해당 번호의 관리자를 찾을 수 없습니다.");
			}
		} catch (SQLException e) {
			// TODO: handle exception
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
		return memberDto;
	}

	public MemberDto memberSelectThis(int no) throws Exception {

		MemberDto memberDto = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql = "SELECT NO, EMAIL, NAME, PWD";
		sql += " FROM MEMBER_GUEST";
		sql += " WHERE NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			String name = "";
			String email = "";
			String pwd = "";

			if (rs.next()) {
				name = rs.getString("NAME");
				email = rs.getString("EMAIL");
				pwd = rs.getString("PWD");

				memberDto = new MemberDto();

				memberDto.setNo(no);
				memberDto.setName(name);
				memberDto.setEmail(email);
				memberDto.setPassword(pwd);
			} else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
			}
		} catch (SQLException e) {
			// TODO: handle exception
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
		return memberDto;
	}

	public int adminManagementUpdate(MemberDto memberDto) throws SQLException {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "";
		sql += "UPDATE MEMBER_MANAGER";
		sql += " SET EMAIL=?, NAME=?, PWD=?";
		sql += " WHERE NO=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDto.getEmail());
			pstmt.setString(2, memberDto.getName());
			pstmt.setString(3, memberDto.getPassword());
			pstmt.setInt(4, memberDto.getNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
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
		}
		return result;
	}

	public int memberManagementUpdate(MemberDto memberDto) throws SQLException {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "";
		sql += "UPDATE MEMBER_GUEST";
		sql += " SET EMAIL=?, NAME=?, PWD=?";
		sql += " WHERE NO=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDto.getEmail());
			pstmt.setString(2, memberDto.getName());
			pstmt.setString(3, memberDto.getPassword());
			pstmt.setInt(4, memberDto.getNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
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
		}
		return result;
	}

}
