package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션
//@WebServlet(
//urlPatterns =  {"/member/list"},
//initParams = {
//	@WebInitParam(name="driver", 
//			value="oracle.jdbc.driver.OracleDriver"),
//	@WebInitParam(name="url", 
//			value="jdbc:oracle:thin:@localhost:1521:xe")
//}
//)

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//데이터베이스 관련 객체 변수 선언
		Connection conn = null; // 연결
		Statement stmt = null; // 상태
		ResultSet rs = null; // 결과
		
		ServletContext sc = this.getServletContext();
		
		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");
		
		try {
//			클래스 로드
//			1 jdbc드라이버 등록
			Class.forName(driver);

			// 2 데이터베이스 연결
			conn = DriverManager.getConnection(url, user, password);
			
//			3 sql 실행 객체 준비
			stmt = conn.createStatement();
			
			String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE"
					+ " FROM MEMBER"
					+ " ORDER BY MNO ASC";
			
			
			// sql 실행문
			// 4 결과 가져오기
			rs = stmt.executeQuery(sql);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("EUC-KR");
					
			PrintWriter out = response.getWriter();
			
			String htmlStr = "";
			
			// 추가
			htmlStr += "<html>";
			htmlStr += "<head>";
			htmlStr += "<title>회원목록</title>";
			htmlStr += "</head>";
			htmlStr += "<body>";
			htmlStr += "<h1>회원목록</h1>";
			htmlStr += "<p>";
			htmlStr += "<a href='./add'>신규 회원</a>";
			htmlStr += "</p>";
			
			while (rs.next()) {
				htmlStr += rs.getInt("MNO") + ", ";
				htmlStr += "<a href='./update?mNo=" 
						+ rs.getInt("MNO") + "'>"
						+  rs.getString("MNAME")+ "</a>"
						+ ", " + rs.getString("EMAIL")
						+ ", " + rs.getDate("CRE_DATE");
				htmlStr += "<a href='./delete?mNo=" 
						+ rs.getInt("MNO") + "'>[삭제]</a>";
				htmlStr += "<br>";
			}
			
			htmlStr += "</body>";
			htmlStr += "</html>";
			
			out.println(htmlStr);
			
//			response.sendRedirect("./list");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 자원해제
			
			// 결과셋 해제
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			// 상태 해제
			if(stmt != null) {
				try {
					stmt.close();
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
			
		} // finally 종료

	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
}
