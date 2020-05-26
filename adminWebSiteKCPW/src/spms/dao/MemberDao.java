package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import spms.dto.BoardDto;
import spms.dto.MemberDto;

public class MemberDao {

	private Connection conn;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	//멤버 전체 개수 조회
	public int memberTotalCount() {
		int totalNum = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		
		try {
			sql = "SELECT COUNT(*)";
			sql += "FROM MEMBER";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalNum = rs.getInt("COUNT(*)");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("memberTotalCount 에러");
			e.printStackTrace();
		}finally {
			try {
	            if (pstmt != null) {
	               pstmt.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
			
			try {
	            if (rs != null) {
	               rs.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
		}
		
		return totalNum;
	}
		
	public List<MemberDto> selectList() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE, GRADE";
		sql += " FROM MEMBER";
		sql += " ORDER BY MNO ASC";

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();
			int no = 0;
			String name = "";
			String email = "";
			Date creDate = null;
			String grade = "";

			while (rs.next()) {
				no = rs.getInt("MNO");
				name = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");
				grade = rs.getString("GRADE");

				MemberDto memberDto = new MemberDto(no, name, email, creDate, grade);

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

	//게시글 10개 조회 - 게시글번호순서
	public List<MemberDto> memberSelectTen(int pageNum){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberDto> memberList = null;
		String sql = "";
		
		try {                 
			sql =  "SELECT *";
			sql += " FROM (";
			sql += " SELECT MNO, MNAME, EMAIL, CRE_DATE, GRADE, ROWNUM rnum";
			sql += " FROM MEMBER";
			sql += " ORDER BY MNO DESC";
			sql += " )";
			sql += " WHERE rnum BETWEEN ? AND ?";
			
			pstmt = conn.prepareStatement(sql);
	
			int rnum1 = 0;
			int rnum2 = 0;
			if(pageNum == 1) {
				rnum1 = 1;
				rnum2 = 10;
			}else {
				rnum1 = (pageNum-1) * 10 + 1;
				rnum2 = pageNum * 10;
			}
			pstmt.setInt(1, rnum1);
			pstmt.setInt(2, rnum2);
			
			rs = pstmt.executeQuery();
			
			memberList = new ArrayList<MemberDto>();
			
			int no = 0;
			String name = "";
			String email = "";
			Date creDate = null;
			String grade = "";
	
			while (rs.next()) {
				no = rs.getInt("MNO");
				name = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");
				grade = rs.getString("GRADE");
	
				MemberDto memberDto = new MemberDto(no, name, email, creDate, grade);
	
				memberList.add(memberDto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("boardSelectTen 에러");
			e.printStackTrace();
		}finally {
			try {
	            if (pstmt != null) {
	               pstmt.close();
	            }
	
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
			
			try {
	            if (rs != null) {
	               rs.close();
	            }
	
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
		}
		
		return memberList;
	}
	
	// 회원등록
	public void memberInsert(MemberDto memberDto) throws Exception {
		PreparedStatement pstmt = null;

		try {
			String email = memberDto.getEmail();
			String pwd = memberDto.getPassword();
			String name = memberDto.getName();

			String sql = "INSERT INTO MEMBER" + " (MNO, EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE)"
					+ " VALUES(MEMBER_MNO_SEQ.NEXTVAL" + " , ?, ?, ?, SYSDATE, SYSDATE)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);

			pstmt.executeUpdate();

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
	}

	// 회원삭제
	public void memberDelete(int no) throws SQLException {

		PreparedStatement pstmt = null;

		String sql = "";
		sql = "DELETE FROM MEMBER";
		sql += " WHERE MNO = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			pstmt.executeUpdate();

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

	// 회원 상세 정보 조회 update - doGet
	public MemberDto memberSelectOne(int no) throws Exception {

		MemberDto memberDto = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql = "SELECT MNO, EMAIL, MNAME, CRE_DATE, MOD_DATE";
		sql += " FROM MEMBER";
		sql += " WHERE MNO =?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			String mName = "";
			String email = "";
			Date creDate = null;
			Date modDate = null;

			if (rs.next()) {
				mName = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");
				modDate = rs.getDate("MOD_DATE");

				memberDto = new MemberDto();

				memberDto.setNo(no);
				memberDto.setName(mName);
				memberDto.setEmail(email);
				memberDto.setCreatedDate(creDate);
				memberDto.setModifiedDate(modDate);
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

	// 회원 정보 변경 update - doPost
	public int memberUpdate(MemberDto memberDto) throws SQLException {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "";
		sql = "UPDATE MEMBER";
		sql += " SET EMAIL=?, MNAME=?, MOD_DATE=SYSDATE";
		sql += " WHERE MNO =?";

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

	// 이메일로 이름 가져오기
	public String findNameByEmail(String myEmail) {

		String name = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT EMAIL, MNAME";
		sql += " FROM MEMBER";
		sql += " WHERE EMAIL = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, myEmail);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("MNAME");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return name;
	}
	
	// 이메일로 해당 등급 찾기
	public String findGradeByEmail(String myEmail) {

		String grade = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT EMAIL, GRADE";
		sql += " FROM MEMBER";
		sql += " WHERE EMAIL = ?";

		try {
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, myEmail);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				grade = rs.getString("GRADE");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}

		return grade;
	}

	//회원찾기
	public MemberDto memberExist(String email, String pwd) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";
		sql = "SELECT MNAME, EMAIL";
		sql += " FROM MEMBER";
		sql += " WHERE EMAIL ='dd'";
		sql += " AND PWD='dd'";

		String name = "";
		try {
			pstmt = conn.prepareStatement(sql);

			int colIndex = 1;

			pstmt.setString(colIndex++, email);
			pstmt.setString(colIndex, pwd);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	//로그인
	public MemberDto memberLogin(String email, String pwd) {

		PreparedStatement pstmt = null; // 상태
		ResultSet rs = null; // 결과

		String sql = "";
		String name = "";
		String grade = "";
		MemberDto memberDto = null;
		int no = 0;
		Date modifiedDate = new Date();
		Date createdDate = new Date();

		try {

			sql += "SELECT MNAME, EMAIL, GRADE, MNO, CRE_DATE, MOD_DATE";
			sql += " FROM MEMBER";
			sql += " WHERE EMAIL = ?";
			sql += " AND PWD = ?";

			int colIndex = 1;

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(colIndex++, email);
			pstmt.setString(colIndex, pwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				email = rs.getString("EMAIL");
				name = rs.getString("MNAME");
				grade = rs.getString("GRADE");
				no = rs.getInt("MNO");
				modifiedDate = rs.getDate("MOD_DATE");
				createdDate = rs.getDate("CRE_DATE");

				memberDto = new MemberDto();

				memberDto.setEmail(email);
				memberDto.setName(name);
				memberDto.setGrade(grade);
				memberDto.setNo(no);
				memberDto.setCreatedDate(createdDate);
				memberDto.setModifiedDate(modifiedDate);

				// System.out.println("memberDao grade:"+grade );

			} else {
				System.out.println("오류발생됨!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

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

}
