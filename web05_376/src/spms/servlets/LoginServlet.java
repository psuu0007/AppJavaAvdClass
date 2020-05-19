package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.dto.MemberDto;

@WebServlet(value = "/auth/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd = 
				req.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(req, res);

	}

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 데이터베이스 관련 객체 변수 선언
		Connection conn = null; // 연결
		PreparedStatement pstmt = null; // 상태
		ResultSet rs = null; // 결과

		String sql = "";
		int colIndex = 1;
		
		try {
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");
			
			String email = req.getParameter("email");
			String pwd = req.getParameter("password");
			String name = "";
			
			sql += "SELECT MNAME, EMAIL";
			sql += " FROM MEMBER";
			sql += " WHERE EMAIL = ?";
			sql += " AND PWD = ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(colIndex++, email);
			pstmt.setString(colIndex, pwd);
			
			rs = pstmt.executeQuery();
			
			// 회원이다
			if(rs.next()) {
				email = rs.getString("EMAIL");
				name = rs.getString("MNAME");
				
				MemberDto memberDto = new MemberDto();
				
				memberDto.setEmail(email);
				memberDto.setName(name);
				
				HttpSession session = req.getSession();
				session.setAttribute("memberDto", memberDto);
				
				res.sendRedirect("../member/list");
			}else {
				RequestDispatcher rd = 
						req.getRequestDispatcher("./LoginFail.jsp");
				rd.forward(req, res);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException(e);
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			// 상태 해제
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}

	}

}
