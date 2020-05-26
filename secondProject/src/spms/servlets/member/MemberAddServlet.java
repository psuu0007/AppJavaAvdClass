package spms.servlets.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.dao.MemberDao;
import spms.dto.MemberDto;

@WebServlet(value = "/member/add")
public class MemberAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.sendRedirect("../member/MemberForm.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;

		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		String name = req.getParameter("name");

		MemberDto memberDto = new MemberDto();

		memberDto.setEmail(email);
		memberDto.setPassword(pwd);
		memberDto.setName(name);

		ServletContext sc = this.getServletContext();

		conn = (Connection) sc.getAttribute("conn");

		MemberDao memberDao = new MemberDao();
		memberDao.setConnection(conn);

		try {
			
			int result = memberDao.memberInsert(memberDto);

//			0이면 회원추가 실패 0이외에는 추가 성공
			if(result == 0) {
				System.out.println("회원가입~~~~~ 실패!");
			}
			
			
			HttpSession session = req.getSession();
			
			if(session.getAttribute("memberDto") == null) {
				res.sendRedirect("../auth/login");
			} else {
				res.sendRedirect("./list");
				
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);
			
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, res);
		}

	}

}
