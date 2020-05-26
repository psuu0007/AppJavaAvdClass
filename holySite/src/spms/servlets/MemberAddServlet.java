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
import javax.servlet.http.HttpSession;

import spms.dao.MemberDao;
import spms.dto.MemberDto;

@WebServlet(value="/member/add")
public class MemberAddServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		// 337 1번 문제 입력화면 생성 코드 제거	
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("../member/memberAddView.jsp");
		dispatcher.forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String nickname = req.getParameter("nickname");
		String grade = req.getParameter("grade");
		
		MemberDto memberDto = new MemberDto();
		
		memberDto.setEmail(email);
		memberDto.setPwd(pwd);
		memberDto.setNickname(nickname);
		memberDto.setGrade(grade);
		
		ServletContext sc = this.getServletContext();

		conn = (Connection) sc.getAttribute("conn");
		
		MemberDao memberDao = new MemberDao();
		
		memberDao.setConnection(conn);
		
		// 0이면 못 넣음 0이외에는 성공
		int result = 0;
		try {
			result = memberDao.memberInsert(memberDto);
			
			if(result == 0){
				System.out.println("회원가입 실패");
				
			}else {
				HttpSession session = req.getSession();
				MemberDto member = (MemberDto)session.getAttribute("member");
				if(member == null) {
					res.sendRedirect("../auth/login");				
				} else if(member.getGrade().equals("1")) {
					res.sendRedirect("./list");
				}
			}
			
			
		} catch (Exception e) {
			req.setAttribute("error", e);
			
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("../Error.jsp");
			dispatcher.forward(req, res);
			
		}
		
	}
	
}
