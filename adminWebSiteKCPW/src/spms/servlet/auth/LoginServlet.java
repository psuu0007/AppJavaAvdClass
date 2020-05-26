package spms.servlet.auth;

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

import javafx.scene.control.Alert;
import spms.dao.MemberDao;
import spms.dto.MemberDto;

@WebServlet(value = "/auth/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String msg = "";
		req.setAttribute("errorMsg", msg);	
		
		RequestDispatcher rd = req.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 데이터베이스 관련 객체 변수 선언
		Connection conn = null; // 연결

		String email = req.getParameter("email");
		System.out.println(email+"email");
		String pwd = req.getParameter("password");
		System.out.println(pwd+"password");
		
		ServletContext sc = this.getServletContext();
		conn = (Connection) sc.getAttribute("conn");

		MemberDao memberDao = new MemberDao();
		memberDao.setConnection(conn);
		
		try {
			if(email.length() != 0 && pwd.length() != 0 ) {
				
				MemberDto memberDto = memberDao.memberLogin(email.trim(), pwd);
	
				if (memberDto != null) {
					HttpSession session = req.getSession();
					session.setAttribute("memberDto", memberDto);
					
					String emailStr = memberDto.getEmail();
					String pwdStr = memberDto.getPassword();
					
					req.setAttribute("emailStr", emailStr);
					req.setAttribute("pwdStr", pwdStr);
					
					System.out.println("나의 등급은 :" + memberDto.getGrade());
					if (memberDto.getGrade().equals("user")) {
						res.sendRedirect("../");
					} else {
						res.sendRedirect("../admin/AdminFunctionPage.jsp");
					}
					
					System.out.println("1");
					
				} else {
					
					String msg = "아이디와 비밀번호를 확인해주세요.";
					
					req.setAttribute("errorMsg", msg);		
					
					RequestDispatcher rd = 
							req.getRequestDispatcher("./LoginForm.jsp");
					rd.forward(req, res);
					
					System.out.println("2");
				}
				
			}else {
				
				RequestDispatcher rd = 
						req.getRequestDispatcher("./LoginForm.jsp");
				rd.forward(req, res);
				
				System.out.println("3");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("여기로 오나?");
	
		}
		
	}

}
