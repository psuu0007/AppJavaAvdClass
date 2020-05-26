package mtp.servlets;

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

import mtp.login.dao.MemberDao;
import mtp.login.dto.MemberDto;

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

		String sql = "";
		int colIndex = 1;
		
		try {
			String email = req.getParameter("email");
			String pwd = req.getParameter("password");
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");

			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			MemberDto memberDto = new MemberDto();
			
			if(email.equals("admin")) { // 게스트
				memberDto = memberDao.memberExist(email, pwd);
			}else{ // 관리자
				memberDto = memberDao.guestExist(email, pwd);
			}		
			
			// 회원이 없다면 로그인 실패 페이지로 이동
			if(memberDto == null) {
				RequestDispatcher rd = 
						req.getRequestDispatcher("./LoginFail.jsp");
				rd.forward(req, res);
			}else {
				// 회원이 존재한다면 세션에 담고 회원 전체 페이지로 이동
				HttpSession session = req.getSession();
				session.setAttribute("member", memberDto);
				
				res.sendRedirect("../noticeBoard/list");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}

	}

}
