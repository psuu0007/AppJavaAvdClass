package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dto.MemberDto;

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
		
		String driver = "";
		String url = "";
		String user = "";
		String password = "";
		
		try {
			ServletContext sc = this.getServletContext();
		
			driver = sc.getInitParameter("driver");
			url = sc.getInitParameter("url");
			user = sc.getInitParameter("user");
			password = sc.getInitParameter("password");
			
//			클래스 로드
//			1 jdbc드라이버 등록
			Class.forName(driver);
			System.out.println("오라클 드라이버 로드 성공");
			
			// 2 데이터베이스 연결
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("오라클 드라이버 연결 성공");
			
//			3 sql 실행 객체 준비
			stmt = conn.createStatement();
			
			String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE"
					+ " FROM MEMBER"
					+ " ORDER BY MNO ASC";
			
			
			// sql 실행문
			// 4 결과 가져오기
			rs = stmt.executeQuery(sql);
			
			System.out.println("쿼리 수행 성공");
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			ArrayList<MemberDto> memberList = 
					new ArrayList<MemberDto>();
			
			int mno = 0;
			String mname = "";
			String email = "";
			Date creDate = null;
			
			while (rs.next()) {
				mno = rs.getInt("MNO");
				mname = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");
				
				MemberDto memberDto = new MemberDto();
				memberDto.setNo(mno);
				memberDto.setName(mname);
				memberDto.setEmail(email);
				memberDto.setCreateDate(creDate);
				
				memberList.add(memberDto);
			}
			
			// request에 회원 목록 데이터 보관
			request.setAttribute("memberList", memberList);
			
			// jsp페이지로 출력을 위임한다
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(
							"/member/MemberListView.jsp");
			dispatcher.include(request, response);
			
			System.out.println("나 실행된다?");
			
		} catch (Exception e) {
//			e.printStackTrace();
//			throw new ServletException(e);
			request.setAttribute("error", e);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);
		} finally {
			if(rs != null) {
				try {
					rs.close();
					System.out.println("ResultSet 종료");
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			// 상태 해제
			if(stmt != null) {
				try {
					stmt.close();
					System.out.println("쿼리(질의) 종료");
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			// 연결 해제
			if(conn != null) {
				try {
					conn.close();
					System.out.println("DB연결 종료");
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
