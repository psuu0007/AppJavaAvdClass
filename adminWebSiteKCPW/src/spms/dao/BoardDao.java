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

public class BoardDao {

	private Connection conn;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	/*
	 * -- 일반 게시판 관리 sql 수행문
	select board_no, title, content, email, cre_date
	from board
	order by board_no desc;
	
	select board_no, title, content, email, cre_date
	from board
	where board_no = 1;
	
	insert into board
	(board_no, title, content, email)
	values(board_no_seq.NEXTVAL, '제목', '내용', 'dd');
	
	update board
	set title='tt', content='content'
	where board_no = 1 and email='dd';
	
	select *
	from board;
	
	delete from board
	where board_no = 2 and email='dd';
	 * 
	 */
	
	
	//게시글 전체 조회
	public List<BoardDto> boardSelectList(){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardDto> boardList = null;
		String sql = "";
		
		try {
			sql = "SELECT BOARD_NO, TITLE, CONTENT, EMAIL, CRE_DATE";
			sql += " FROM BOARD";
			sql += " ORDER BY BOARD_NO DESC";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			boardList = new ArrayList<BoardDto>();
			
			int boardNo = 0;
			String title = "";
			String content = "";
			String email = "";
			Date creDate = null;
			
			while(rs.next()) {
				boardNo = rs.getInt("BOARD_NO");
				title = rs.getString("TITLE");
				content = rs.getString("CONTENT");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");
				
				BoardDto boardDto = new BoardDto();
				boardDto.setBoardNo(boardNo);
				boardDto.setTitle(title);
				boardDto.setContent(content);
				boardDto.setEmail(email);
				boardDto.setCreatedDate(creDate);
				
				//System.out.println(boardDto.getBoardNo());
				
				boardList.add(boardDto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("boardSelectList 에러");
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
		
		return boardList;
	}
	
	//게시글 전체 개수 조회
	public int boardTotalCount() {
		int totalNum = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		
		try {
			sql = "SELECT COUNT(*)";
			sql += "FROM BOARD";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalNum = rs.getInt("COUNT(*)");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("boardTotalCount 에러");
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
	
	//게시글 10개 조회 - 게시글번호순서
	public List<BoardDto> boardSelectTen(int pageNum){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardDto> boardList = null;
		String sql = "";
		
		try {                 
			sql =  "SELECT *";
			sql += " FROM (";
			sql += " SELECT BOARD_NO, TITLE, CONTENT, EMAIL, MY_NAME, CRE_DATE, ROWNUM rnum";
			sql += " FROM BOARD";
			sql += " ORDER BY BOARD_NO DESC";
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
			
			boardList = new ArrayList<BoardDto>();
			
			int boardNo = 0;
			String title = "";
			String content = "";
			String email = "";
			String myName = "";
			Date creDate = null;
			
			while(rs.next()) {
				boardNo = rs.getInt("BOARD_NO");
				title = rs.getString("TITLE");
				content = rs.getString("CONTENT");
				email = rs.getString("EMAIL");
				myName = rs.getString("MY_NAME");
				creDate = rs.getDate("CRE_DATE");
				
				BoardDto boardDto = new BoardDto();
				boardDto.setBoardNo(boardNo);
				boardDto.setTitle(title);
				boardDto.setContent(content);
				boardDto.setEmail(email);
				boardDto.setMyName(myName);
				boardDto.setCreatedDate(creDate);
				
				//System.out.println(boardDto.getBoardNo());
				
				boardList.add(boardDto);
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
		
		return boardList;
	}
	
	//게시글 10개 조회 - 최신순 , 수정일순서??? - 보류
	public List<BoardDto> boardSelectTenLatest(int pageNum){
			
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		ArrayList<BoardDto> boardList = null;
		String sql = "";
			
		try {                 
			sql =  "SELECT *";
			sql += " FROM (";
			sql += " SELECT BOARD_NO, TITLE, CONTENT, EMAIL, MY_NAME, CRE_DATE, ROWNUM rnum";
			sql += " FROM BOARD";
			sql += " ORDER BY CRE_DATE DESC";
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
			
			boardList = new ArrayList<BoardDto>();
			
			int boardNo = 0;
			String title = "";
			String content = "";
			String email = "";
			String myName = "";
			Date creDate = null;
			
			while(rs.next()) {
				boardNo = rs.getInt("BOARD_NO");
				title = rs.getString("TITLE");
				content = rs.getString("CONTENT");
				email = rs.getString("EMAIL");
				myName = rs.getString("MY_NAME");
				creDate = rs.getDate("CRE_DATE");
				
				BoardDto boardDto = new BoardDto();
				boardDto.setBoardNo(boardNo);
				boardDto.setTitle(title);
				boardDto.setContent(content);
				boardDto.setEmail(email);
				boardDto.setMyName(myName);
				boardDto.setCreatedDate(creDate);
				
				//System.out.println(boardDto.getBoardNo());
				
				boardList.add(boardDto);
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
		
		return boardList;
	}
	
	//게시글 한 개 조회
	public BoardDto boardSelectOne(int no){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardDto boardDto = null;
		String sql = "";
		
		try {
			sql = "SELECT BOARD_NO, TITLE, CONTENT, EMAIL, MY_NAME, CRE_DATE, MOD_DATE"; 
			sql += " FROM BOARD";
			sql += " WHERE BOARD_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			String title = "";
	        String content = "";
	        String email = "";
	        String myName = "";
	        Date creDate = null;
	        Date modDate = null;

	        if (rs.next()) {
	        	no = rs.getInt("BOARD_NO");
	        	title = rs.getString("TITLE");
	        	content = rs.getString("CONTENT");
	        	email = rs.getString("EMAIL");
	        	myName = rs.getString("MY_NAME");
	        	creDate = rs.getDate("CRE_DATE");
	        	modDate = rs.getDate("MOD_DATE");
	
	        	boardDto = new BoardDto();
	
	        	boardDto.setBoardNo(no);
	        	boardDto.setEmail(email);
	        	boardDto.setMyName(myName);
	        	boardDto.setTitle(title);
	        	boardDto.setContent(content);
	        	boardDto.setCreatedDate(creDate);
	        	boardDto.setModifiedDate(modDate);
	        	
	        }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
			
		
		return boardDto;
	}
	
	public int boardInsert(BoardDto boardDto) throws Exception {
		
		PreparedStatement pstmt = null;
		
		String title = boardDto.getTitle();
		String content = boardDto.getContent();
		String email = boardDto.getEmail();
		String myName = boardDto.getMyName();
		
		String sql = "";
		
		int result = 0;
	
		try {
			sql  = "INSERT INTO BOARD";
			sql += " (BOARD_NO, TITLE, CONTENT, EMAIL, MY_NAME)";		
			sql += " VALUES(BOARD_NO_SEQ.NEXTVAL, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, email);
			pstmt.setString(4, myName);
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} // finally 종료
	
	return result;

	}
	
	public int boardUpdate(BoardDto boardDto, String myEmail){
		
		int result = 0;
		
		PreparedStatement pstmt = null;
			
		String sql ="";
		sql += "UPDATE BOARD";
		sql += " SET TITLE=?, CONTENT=?, MOD_DATE=sysdate";
		sql += " WHERE BOARD_NO=? AND EMAIL=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardDto.getTitle());
	        pstmt.setString(2, boardDto.getContent());
	        pstmt.setInt(3, boardDto.getBoardNo());
	        pstmt.setString(4, myEmail);
			
	        result = pstmt.executeUpdate();
	        
	        if(result == 0) {
	        	System.out.println("boardUpdate sql 실패");
	        	System.out.println("result:"+result);
	        }
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("작성자 일치 실패 ");
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

	    } // finally 종료
		
		return result;
	}
	
	public int boardDelete(int no, String myEmail){
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "delete from board";
		sql += " where board_no = ?";
		sql += " and email= ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			pstmt.setString(2, myEmail);
			result = pstmt.executeUpdate();

			if(result == 0) {
				System.out.println("이메일 정보가 일치하지 않습니다.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		return result;

	}
	
	//admin이면 삭제 
	public int boardAdminDelete(int no){
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "delete from board";
		sql += " where board_no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();

			if(result == 0) {
				System.out.println("이메일 정보가 일치하지 않습니다.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		return result;

	}
	
	public BoardDto boardExist(String title, String content, String email) {
		
		return null;
	}
}
