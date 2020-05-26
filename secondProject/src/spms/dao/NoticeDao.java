package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import spms.dto.MemberDto;
import spms.dto.NoticeDto;

public class NoticeDao {
	
	private Connection connection;

//	주입 -> 의존

	public void setConnection(Connection conn) {
		this.connection = conn;
	}
	
	public ArrayList<NoticeDto> noticeSelect() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String sql = "SELECT nno, ntitle, NCONTENTS, NWRITER, NWRITE_DATE";
		sql	+= " FROM NOTICE_BOARD";
		sql	+= " order by nno desc";
		
		ArrayList<NoticeDto> noticeList = new ArrayList<NoticeDto>();
		
		try {
						
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				int no = rs.getInt("NNO");
				String title = rs.getString("NTITLE");
				String contents = rs.getString("NCONTENTS");
				String writer = rs.getString("NWRITER");
				Date writeDate = rs.getDate("NWRITE_DATE");
				
				NoticeDto noticeDto = new NoticeDto();
				noticeDto.setNo(no);
				noticeDto.setTitle(title);
				noticeDto.setContents(contents);
				noticeDto.setWriter(writer);
				noticeDto.setWriteDate(writeDate);
				noticeList.add(noticeDto);
			}
		
			} catch (Exception e) {
			// TODO: handle exception
		}
		return noticeList;
	}
	
	public int noticeUpdate(NoticeDto noticeDto) throws SQLException {

		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "UPDATE Notice_Board";
		sql += " set ntitle = ?,";  
		sql += " NCONTENTS = ?,";
		sql += " NWRITER = ?";
		sql += " where nno = ?"; 
		
		try {
			
			pstmt = connection.prepareStatement(sql);

			System.out.println(noticeDto.getWriter());
			pstmt.setString(1, noticeDto.getTitle());
			pstmt.setString(2, noticeDto.getContents());
			pstmt.setString(3, noticeDto.getWriter());
			pstmt.setInt(4, noticeDto.getNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		}
		return result;
	}

	public NoticeDto noticeSelectOne(int no) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("noticeSelectOne시작함");
		try {
			

			String sql = "SELECT ntitle, ncontents, nwriter";
			
			sql += " from notice_board"; 
			sql += " where nno = ?"; 

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("ntitle");
				String contents = rs.getString("ncontents");
				String writer = rs.getString("nwriter");
				
				NoticeDto noticeDto = new NoticeDto();
				
				noticeDto.setNo(no);
				noticeDto.setTitle(title);
				noticeDto.setContents(contents);
				noticeDto.setWriter(writer);
				
				return noticeDto;
				
			}

		} catch (Exception e) {
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
		}
		return null;
	}
	
	public int noticeDelete(int no) throws SQLException{
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "";
		
		sql += "DELETE FROM Notice_Board";
		sql += " WHERE NNO = ?";
		
		try {
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally {

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
	
	
	public int noticeAdd(NoticeDto noticeDto) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			String title = noticeDto.getTitle();
			String writer = noticeDto.getWriter();
			String content = noticeDto.getContents();
			String writerEmail = noticeDto.getWriterEmail();
			
			String sql = "INSERT INTO NOTICE_BOARD";
			sql +=	" VALUES(NOTICE_BOARD_NNO_SEQ.NEXTVAL,";
			sql +=	" ?, ?, ?, ?,";
			sql +=	" SYSDATE)";
			
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, writerEmail);
			pstmt.setString(4, content);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
			
		return result;
	}
	
	
	
}
