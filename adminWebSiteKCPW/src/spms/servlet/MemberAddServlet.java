package spms.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.control.Alert;
import spms.dao.MemberDao;
import spms.dto.MemberDto;

@WebServlet(value="/member/add")
public class MemberAddServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 337 1번 문제 입력화면 생성 코드 제거	
		res.sendRedirect("./MemberAddForm.jsp");
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
		
		// 0이면 못 넣음 0이외에는 성공, 유효성 검사
	
			try {
				memberDao.memberInsert(memberDto);
				res.sendRedirect("../auth/login");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//이미 유효성 검사하고 오는 거니까 여기까진 올 일 없다
				e.printStackTrace();
			}
	
		
		
	}
	
}
