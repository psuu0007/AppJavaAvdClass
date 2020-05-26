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
import spms.dto.NoticeDto;

public class NoticeDao {

	private Connection conn;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	// 게시판 목록
	public List<NoticeDto> noticeSelectList() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT NOTICE_NO, TITLE, CONTENT, CRE_EMAIL,";
		sql += " CRE_DATE, MY_NAME, MOD_DATE, MOD_EMAIL";
		sql += " FROM NOTICEBOARD";
		sql += " ORDER BY CRE_DATE DESC";

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			ArrayList<NoticeDto> noticeList = new ArrayList<NoticeDto>();

			int noticeNo = 0;
			String title = "";
			String content = "";
			String creEmail = "";
			Date creDate = null;
			String myName = "";
			Date modDate = null;
			String modEmail = "";

			while (rs.next()) {
				noticeNo = rs.getInt("NOTICE_NO");
				title = rs.getString("TITLE");
				content = rs.getString("CONTENT");
				creEmail = rs.getString("CRE_EMAIL");
				creDate = rs.getDate("CRE_DATE");
				myName = rs.getString("MY_NAME");
				modDate = rs.getDate("MOD_DATE");
				modEmail = rs.getString("MOD_EMAIL");

				NoticeDto noticeDto = new NoticeDto(noticeNo, title, content, creEmail, modEmail, myName, creDate,
						modDate);

				noticeList.add(noticeDto);
			}

			return noticeList;

		} catch (Exception e) {
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

		} // finally 종료

	}

	// 게시글 상세보기
	public NoticeDto noticeSelectOne(int noticeNo) throws Exception {

		NoticeDto noticeDto = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT NOTICE_NO, TITLE, CONTENT, MY_NAME, CRE_EMAIL, CRE_DATE";
		sql += " FROM NOTICEBOARD";
		sql += " WHERE NOTICE_NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, noticeNo);

			rs = pstmt.executeQuery();

			String title = "";
			String content = "";
			String myName = "";
			String creEmail = "";
			Date creDate = null;

			if (rs.next()) {
				title = rs.getString("TITLE");
				content = rs.getString("CONTENT");
				myName = rs.getString("MY_NAME");
				creEmail = rs.getString("CRE_EMAIL");
				creDate = rs.getDate("CRE_DATE");

				noticeDto = new NoticeDto();

				noticeDto.setNoticeNo(noticeNo);
				noticeDto.setTitle(title);
				noticeDto.setContent(content);
				noticeDto.setMyName(myName);
				noticeDto.setCreEmail(creEmail);
				noticeDto.setCreatedDate(creDate);
			} else {
				throw new Exception("해당 번호의 게시글을 찾을 수 없습니다.");
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

		} // finally 종료

		return noticeDto;
	}

	// 게시글 쓰기
	public int noticeInsert(NoticeDto noticeDto, MemberDto memberDto) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;

		String myName = "";
		String myEmail = "";

		try {
			String title = noticeDto.getTitle();
			String content = noticeDto.getContent();

			String sql = "INSERT INTO NOTICEBOARD";
			sql += " (NOTICE_NO, TITLE, CONTENT, CRE_EMAIL, MY_NAME, CRE_DATE, MOD_DATE)";
			sql += " VALUES(NOTICE_NO_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, SYSDATE)";

			pstmt = conn.prepareStatement(sql);

			myEmail = memberDto.getEmail();
			myName = memberDto.getName();

			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, myEmail);
			pstmt.setString(4, myName);

			System.out.println(myName);

			result = pstmt.executeUpdate();

			if (result == 0) {
				System.out.println("공지 추가 실패 sql수행오류");
			}

		} catch (Exception e) {
			// TODO: handle exception
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

	// 게시글 수정
	public int noticeUpdate(NoticeDto noticeDto, String myEmail) throws SQLException {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "UPDATE NOTICEBOARD";
		sql += " SET TITLE = ?, CONTENT = ?, MOD_DATE = SYSDATE";
		sql += " WHERE NOTICE_NO = ? AND CRE_EMAIL = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, noticeDto.getTitle());
			pstmt.setString(2, noticeDto.getContent());
			pstmt.setInt(3, noticeDto.getNoticeNo());
			pstmt.setString(4, myEmail);

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

		} // finally 종료

		return result;
	}

	// 게시글 삭제
	public int noticeDelete(int noticeNo, String myEmail) throws SQLException {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "DELETE FROM NOTICEBOARD";
		sql += " WHERE NOTICE_NO = ? AND CRE_EMAIL = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, noticeNo);
			pstmt.setString(2, myEmail);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
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

		} // finally 종료

		return result;
	}

	// 게시글 전체 개수 조회
	public int boardTotalCount() {
		int totalNum = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {
			sql = "SELECT COUNT(*)";
			sql += "FROM NOTICEBOARD";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totalNum = rs.getInt("COUNT(*)");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("boardTotalCount 에러");
			e.printStackTrace();
		} finally {
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

	// 게시글 10개 조회
	public List<NoticeDto> boardSelectTen(int pageNum) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<NoticeDto> noticeList = null;
		String sql = "";

		try {
			sql = "SELECT *";
			sql += " FROM (";
			sql += " SELECT NOTICE_NO, TITLE, CONTENT, MY_NAME,";
			sql += " CRE_EMAIL, CRE_DATE, MOD_DATE, ROWNUM rnum";
			sql += " FROM NOTICEBOARD";
			sql += " ORDER BY NOTICE_NO DESC";
			sql += " )";
			sql += " WHERE rnum BETWEEN ? AND ?";

			pstmt = conn.prepareStatement(sql);

			int rnum1 = 0;
			int rnum2 = 0;
			if (pageNum == 1) {
				rnum1 = 1;
				rnum2 = 10;
			} else {
				rnum1 = (pageNum - 1) * 10 + 1;
				rnum2 = pageNum * 10;
			}
			pstmt.setInt(1, rnum1);
			pstmt.setInt(2, rnum2);

			rs = pstmt.executeQuery();

			noticeList = new ArrayList<NoticeDto>();

			int noticeNo = 0;
			String title = "";
			String content = "";
			String myName = "";
			String creEmail = "";
			Date creDate = null;
			Date modDate = null;

			while (rs.next()) {
				noticeNo = rs.getInt("NOTICE_NO");
				title = rs.getString("TITLE");
				content = rs.getString("CONTENT");
				myName = rs.getString("MY_NAME");
				creEmail = rs.getString("CRE_EMAIL");
				creDate = rs.getDate("CRE_DATE");
				modDate = rs.getDate("MOD_DATE");

				NoticeDto noticeDto = new NoticeDto();
				noticeDto.setNoticeNo(noticeNo);
				noticeDto.setTitle(title);
				noticeDto.setContent(content);
				noticeDto.setMyName(myName);;
				noticeDto.setCreEmail(creEmail);
				noticeDto.setCreatedDate(creDate);
				noticeDto.setModifiedDate(modDate);

				// System.out.println(boardDto.getBoardNo());

				noticeList.add(noticeDto);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("boardSelectTen 에러");
			e.printStackTrace();
		} finally {
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

		return noticeList;
	}
}
