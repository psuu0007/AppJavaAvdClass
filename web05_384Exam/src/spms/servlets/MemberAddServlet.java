package spms.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.dto.MemberDto;

@WebServlet(value="/member/add")
public class MemberAddServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 337 1번 문제 입력화면 생성 코드 제거	
		res.sendRedirect("../member/MemberForm.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
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
		
		// 0이면 못 넣음 0이외에는 성공
		int result;
		try {
			result = memberDao.memberInsert(memberDto);
			
			if(result == 0){
				System.out.println("회원가입 실패");
			}
			
			res.sendRedirect("./list");
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, res);
		}
		
	}
	
}
