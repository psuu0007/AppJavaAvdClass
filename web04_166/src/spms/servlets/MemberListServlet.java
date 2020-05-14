package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MemberListServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//데이터베이스 관련 객체 변수 선언
		Connection conn = null; // 연결
		Statement stmt = null; // 상태
		ResultSet rs = null; // 결과
		
		// 사용할 jdbc 드라이버:드라이버 타입:서버주소와 포트:db서비스 아이디
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp12";
		
		try {
//			클래스 로드
//			1 jdbc드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2 데이터베이스 연결
			conn = DriverManager.getConnection(url, user, password);
			
//			3 sql 실행 객체 준비
			stmt = conn.createStatement();
			
			String sql = "select mno, mname, email, cre_date"
					+ " from member"
					+ " order by mno asc";
			
			// sql 실행문
			// 4 결과 가져오기
			rs = stmt.executeQuery(sql);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
					
			PrintWriter out = response.getWriter();
			
			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원목록</h1>");
			
			// 5 출력
			while (rs.next()) {
				out.println(
					rs.getInt("mno") + "," + 
					rs.getString("mname") + "," +
					rs.getString("email") + "," +
					rs.getDate("cre_date") + "<br/>"
				);
			}
			out.println("</body></html>");
			
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
		
	} // service end
	
}
