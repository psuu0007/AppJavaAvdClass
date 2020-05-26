package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import spms.dto.BulletinDto;
import spms.dto.MemberDto;
import spms.dto.NoticeDto;

public class BulletinDao {

	private Connection conn;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public List<BulletinDto> selectList() throws Exception{
		return this.selectList(0, 1);
	}
	
	public List<BulletinDto> selectList(int pageUnit, int pageNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		String sql = "SELECT * FROM "
//				+ "(SELECT ROWNUM RN, NO, TITLE, WRITER, CRE_DATE FROM "
//				+ "(SELECT * FROM BULLETIN ORDER BY NO DESC)) WHERE RN BETWEEN ? AND ?";

//
//		String sql = "SELECT NO, TITLE, WRITER, CRE_DATE";
//		sql += " FROM BULLETIN";
//		sql += " ORDER BY NO DESC";
		
		int startNo = 0;
		int endNo = 0;
		String sql = "";
		
		if(pageUnit != 0) {
	         sql += "select * from (";
	      }
	      sql += "SELECT ROWNUM rn, NO, TITLE, WRITER, CRE_DATE";
	      sql += " FROM (SELECT * FROM BULLETIN ORDER BY NO DESC)";
	      if(pageUnit != 0) {
	         sql += ") WHERE rn BETWEEN ? AND ?";
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

			ArrayList<BulletinDto> bulletinList = 
				new ArrayList<BulletinDto>();
			
			int no = 0;
			String title = "";
			MemberDto writer = null;
			Date creDate = null;

			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			while (rs.next()) {
				no = rs.getInt("NO");
				title = rs.getString("TITLE");
				writer  = memberDao.memberSelectOne(rs.getInt("WRITER"));
				creDate = rs.getDate("CRE_DATE");
				
				BulletinDto bulletinDto = 
					new BulletinDto(no, title, creDate , writer);

				bulletinList.add(bulletinDto);
			}

			return bulletinList;
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
	public int bulletinInsert(BulletinDto bulletinDto) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		
		MemberDao memberDao = new MemberDao();
		memberDao.setConnection(conn);
		try {
			String title = bulletinDto.getTitle();
			String text = bulletinDto.getText();
			int writer = bulletinDto.getWriter().getNo();

			String sql = "INSERT INTO BULLETIN" 
			+ " (NO, TITLE, TEXT, CRE_DATE, WRITER)"
			+ " VALUES(BULLETIN_NO_SEQ.NEXTVAL"
			+ " , ?, ?, SYSDATE, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, title);
			pstmt.setString(2, text);
			pstmt.setInt(3, writer);

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
	
	public int bulletinDelete(int no) throws SQLException {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "";
		sql = "DELETE FROM bulletin";
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
	public BulletinDto bulletinSelectOne(int no) throws Exception {

		BulletinDto bulletinDto = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql = "SELECT WRITER, TITLE, TEXT, CRE_DATE";
		sql += " FROM BULLETIN";
		sql += " WHERE NO =?";
		
		MemberDao memberDao = new MemberDao();
		memberDao.setConnection(conn);
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			MemberDto writer = null;
			String title = "";
			String text = "";
			Date creDate = null;

			if (rs.next()) {
				writer = memberDao.memberSelectOne(rs.getInt("WRITER"));
				title = rs.getString("TITLE");
				text = rs.getString("TEXT");
				creDate = rs.getDate("CRE_DATE");

				bulletinDto = new BulletinDto();

				bulletinDto.setNo(no); 
				bulletinDto.setWriter(writer);
				bulletinDto.setTitle(title);
				bulletinDto.setText(text);				
				bulletinDto.setCreatedDate(creDate);
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
		return bulletinDto;
	}

	// 회원 정보 변경
	public int bulletinUpdate(BulletinDto bulletinDto) throws SQLException {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "";
		sql = "UPDATE BULLETIN";
		sql += " SET TITLE=?, TEXT=?";
		sql += " WHERE NO =?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bulletinDto.getTitle());
			pstmt.setString(2, bulletinDto.getText());
			pstmt.setInt(3, bulletinDto.getNo());
			
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
		System.out.println(result);
		return result;
	}
	public int getCount() throws SQLException  {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";
		sql = "SELECT COUNT(*)";
		sql += " FROM BULLETIN";
		
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
