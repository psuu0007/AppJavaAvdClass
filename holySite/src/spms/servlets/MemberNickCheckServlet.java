package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.dto.MemberDto;

@SuppressWarnings("serial")
@WebServlet("/member/nicknamecheck")
public class MemberNickCheckServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("./nicknameCheckView.jsp");
		dispatcher.forward(req, res);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MemberDto memberDto = null;
		
		Connection conn = null;
		
		String nickname = req.getParameter("nickname");
		
		memberDto = new MemberDto();
		memberDto.setNickname(nickname);
		
		ServletContext sc = this.getServletContext();
		
		conn = (Connection) sc.getAttribute("conn");
		
		MemberDao memberDao = new MemberDao();
		memberDao.setConnection(conn);
		
		int result = 0;
		
		try {
			result = memberDao.memberCheckNickname(memberDto);
			if(result ==0) {
				System.out.println("사용가능한 회원입니다");
			}
			System.out.println("중복된 회원입니다");
			req.setAttribute("cnt", result);
			req.setAttribute("nickname", nickname);

			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			//jsp로 출력을 위임한다
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("./nicknameCheckView.jsp");
			
			dispatcher.include(req, res);
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, res);
			
		}
		
		
	}
	
	
}
