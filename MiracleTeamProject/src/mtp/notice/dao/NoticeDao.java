package mtp.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import mtp.notice.dto.NoticeDto;

public class NoticeDao {
	
	private Connection conn;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public List<NoticeDto> selectList(HashMap<String, Object> listOpt) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String opt = (String)listOpt.get("opt");
		String condition = (String)listOpt.get("condition");
		int start = (Integer)listOpt.get("start");
		
		String sql = "";
		if(opt == null) {
			sql = "SELECT *";
			sql += " FROM (SELECT rownum rnum, NO, TITLE, WRITER, CONTEXT FROM NOTICE_POST)";
			sql += " WHERE rnum>=? and rnum<=?";			
			sql += " ORDER BY NO ASC";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, start+9);
		}else if(opt.equals("0")) {
			sql = "SELECT *";
			sql += " FROM (SELECT rownum rnum, NO, TITLE, WRITER, CONTEXT FROM NOTICE_POST)";
			sql += " WHERE TITLE LIKE ?";
			sql += " AND rnum>=? and rnum<=?";			
			sql += " ORDER BY NO ASC";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + condition + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, start+9);
		}else if(opt.equals("1")) {
			sql = "SELECT *";
			sql += " FROM (SELECT rownum rnum, NO, TITLE, WRITER, CONTEXT FROM NOTICE_POST)";
			sql += " WHERE CONTEXT LIKE ?";
			sql += " AND rnum>=? and rnum<=?";			
			sql += " ORDER BY NO ASC";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + condition + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, start+9);
		}else if(opt.equals("2")) {
			sql = "SELECT *";
			sql += " FROM (SELECT rownum rnum, NO, TITLE, WRITER, CONTEXT FROM NOTICE_POST)";
			sql += " WHERE (TITLE LIKE ?";
			sql += " OR CONTEXT LIKE ?)";
			sql += " AND rnum>=? and rnum<=?";			
			sql += " ORDER BY NO ASC";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + condition + "%");
			pstmt.setString(2, "%" + condition + "%");
			pstmt.setInt(3, start);
			pstmt.setInt(4, start+9);
		}else if(opt.equals("3")) {
			sql = "SELECT *";
			sql += " FROM (SELECT rownum rnum, NO, TITLE, WRITER, CONTEXT FROM NOTICE_POST)";
			sql += " WHERE WRITER LIKE ?";
			sql += " AND rnum>=? and rnum<=?";			
			sql += " ORDER BY NO ASC";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + condition + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, start+9);
		}
		
		
		try {			
			rs = pstmt.executeQuery();
			sql = "";

			ArrayList<NoticeDto> noticeList = new ArrayList<NoticeDto>();
			
			int no = 0;
			String title = "";
			String writer = "";
			String context = "";

			while (rs.next()) {
				no = rs.getInt("NO");
				title = rs.getString("TITLE");
				writer = rs.getString("WRITER");
				context = rs.getString("CONTEXT");

				NoticeDto noticeDto = new NoticeDto(no, title, writer, context);

				noticeList.add(noticeDto);
			}

			return noticeList;
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

		} // finally End

	} // SelectList End
	
	public int listCount(HashMap<String, Object> listOpt) throws Exception {		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String opt = (String)listOpt.get("opt");
		String condition = (String)listOpt.get("condition");
		
		String sql = "";
		if(opt == null) {
			sql = "SELECT COUNT(*)";
			sql += " FROM NOTICE_POST";
			
			pstmt = conn.prepareStatement(sql);			
		}else if(opt.equals("0")) {
			sql = "SELECT COUNT(*)";
			sql += " FROM NOTICE_POST";
			sql += " WHERE TITLE LIKE ?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + condition + "%");
		}else if(opt.equals("1")) {
			sql = "SELECT COUNT(*)";
			sql += " FROM NOTICE_POST";
			sql += " WHERE CONTEXT LIKE ?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + condition + "%");
		}else if(opt.equals("2")) {
			sql = "SELECT COUNT(*)";
			sql += " FROM NOTICE_POST";
			sql += " WHERE TITLE LIKE ?";
			sql += " OR CONTEXT LIKE ?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + condition + "%");
			pstmt.setString(2, "%" + condition + "%");
		}else if(opt.equals("3")) {
			sql = "SELECT COUNT(*)";
			sql += " FROM NOTICE_POST";
			sql += " WHERE WRITER LIKE ?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + condition + "%");
		}		
		
		try {			
			rs = pstmt.executeQuery();
			sql = "";
			
			if(rs.next()) result = rs.getInt(1);

		} catch (Exception e) {
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

		} // finally End
		
		return result;
	}
	
	public int noticeInsert(NoticeDto noticeDto) {
		int result = 0;
		PreparedStatement pstmt = null;
	
		try {
			String title = noticeDto.getTitle();
			String writer = noticeDto.getWriter();
			String context = noticeDto.getContext();
			
			String sql = "INSERT INTO NOTICE_POST"; 
				   sql += " (NO, TITLE, WRITER, CONTEXT)";
				   sql += " VALUES(NO_NOTICE_CHECK.NEXTVAL";
				   sql += ", ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, context);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public NoticeDto noticeSelectOne(int no) throws Exception {		
		NoticeDto noticeDto = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";

		sql = "SELECT TITLE, WRITER, CONTEXT";
		sql += " FROM NOTICE_POST";
		sql += " WHERE NO =?";
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			String title = "";
			String writer = "";
			String context = "";

			if (rs.next()) {
				title = rs.getString("TITLE");
				writer = rs.getString("WRITER");
				context = rs.getString("CONTEXT");

				noticeDto = new NoticeDto();

				noticeDto.setNo(no);
				noticeDto.setTitle(title);
				noticeDto.setWriter(writer);
				noticeDto.setContext(context);
			} else {
				throw new Exception("게시물이 없습니다.");
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
		
		return noticeDto;
	}
	
	public int noticeUpdate(NoticeDto noticeDto) throws SQLException {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "";
		sql = "UPDATE NOTICE_POST";
		sql += " SET TITLE=?, CONTEXT=?";
		sql += " WHERE NO =?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, noticeDto.getTitle());
			pstmt.setString(2, noticeDto.getContext());
			pstmt.setInt(3, noticeDto.getNo());

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
	} // noticeUpdate End
	
	public int noticeDelete(int no) throws SQLException {
		int result = 0;	
		PreparedStatement pstmt = null;

		try {
			String sql = "";
			sql = "DELETE FROM NOTICE_POST";
			sql += " WHERE NO = ?";
			
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
	
}
