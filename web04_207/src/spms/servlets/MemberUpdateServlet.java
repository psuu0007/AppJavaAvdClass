package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {

		// 데이터베이스 관련 객체 변수 선언
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 

		// 사용할 jdbc 드라이버:드라이버 타입:서버주소와 포트:db서비스 아이디
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp12";
		
		String mNoStr = req.getParameter("mNo");
		
		int mNo = Integer.parseInt(mNoStr);  
		System.out.println(mNo);
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2 데이터베이스 연결
			conn = DriverManager.getConnection(url, user, password);

//					3 sql 실행 객체 준비
			
			String sql = "SELECT MNO, EMAIL, MNAME, "
					+ "CRE_DATE" 
			+ " FROM MEMBER" 
			+ " WHERE MNO = ?";

			// sql 실행문
			// 4 결과 가져오기
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mNo);
			
			rs = pstmt.executeQuery();

			String mName = "";
			String email = "";
			Date creDate = null;
			
			if(rs.next()) {
				mName = rs.getString("MNAME");
				email = rs.getString("email");
				creDate = rs.getDate("CRE_DATE");
			}
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");

			PrintWriter out = res.getWriter();

			String htmlStr = "";

			htmlStr += "<!DOCTYPE html>";
			htmlStr += "<html>";
			htmlStr += "<head>";
			htmlStr += "<meta charset='UTF-8'>";
			htmlStr += "<title>회원정보</title>";
			htmlStr += "</head>";
			htmlStr += "<body>";
			htmlStr += "<h1>회원정보</h1>";
			htmlStr += "<form action='./update' method='post'>";
			htmlStr += "번호: <input type='text' name='mNo' "
					+ "value='" + mNo + "' ";
			
			htmlStr += "	readonly='readonly'><br>";
			htmlStr += "이름: <input type='text' name='name' "
					+ "value='" + mName + "'><br>";
			htmlStr += "이메일: <input type='text' name='email' "
					+ "value='" + email + "'><br>";
			htmlStr += "가입일: " + creDate + "<br>";
			htmlStr += "<input type='submit' value='저장'>";
			htmlStr += "<input type='button' value='취소' ";
			htmlStr += "	onclick='location.href=\"./list\"'>";
			htmlStr += "</form>";
			htmlStr += "</body>";
			htmlStr += "</html>";

			out.println(htmlStr);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 자원해제

			// 결과셋 해제
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			// 상태 해제
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			// 연결 해제
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		} // finally 종료

	} // doGet end
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String driver = this.getInitParameter("driver");
		String url = this.getInitParameter("url");
		String user = this.getInitParameter("user");
		String password = this.getInitParameter("password");
		
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		int mNo = Integer.parseInt(req.getParameter("mNo"));
		
		String sql = "";
		
		try {
			Class.forName(driver);
			
			System.out.println("오라클 드라이버 로드");
			conn = DriverManager.getConnection(url, user, password);
			
			sql = "UPDATE MEMBER";
			sql += " SET EMAIL = ?, "
					+ "MNAME =?, MOD_DATE=SYSDATE";
			sql += " WHERE MNO = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, name);
			pstmt.setInt(3, mNo);
			
			pstmt.executeUpdate();
			
			res.sendRedirect("./list");
//			
//			res.setContentType("text/html");
//			res.setCharacterEncoding("UTF-8");
//
//			PrintWriter out = res.getWriter();
//
//			String htmlStr = "";
//
//			htmlStr += "<html><head><title>회원정보수정결과</title>";
//			htmlStr += "</head>";
//			
//			htmlStr += "<body>";
//			htmlStr += "<p>수정 성공입니다.!</p>";
//			htmlStr += "</body></html>";
//
//			out.println(htmlStr);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 자원해제
			
			// 상태 해제
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			// 연결 해제
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
	}

}
