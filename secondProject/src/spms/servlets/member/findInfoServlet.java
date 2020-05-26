package spms.servlets.member;

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
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

@WebServlet("/auth/find")
public class findInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = 
				req.getRequestDispatcher("./findInfo.jsp");
		
		rd.forward(req, res);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		try {
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");
			
			String email = req.getParameter("email");
			
			MemberDto memberDto = new MemberDto();
			memberDto.setEmail(email);
			
			
			MemberDao memberDao = new MemberDao();
			
			System.out.println(memberDto.getEmail());
			System.out.println(memberDto.getPassword());
			
			memberDao.setConnection(conn);
			memberDto = memberDao.findInfo(memberDto);
			
			req.setAttribute("memberDto", memberDto);
			
			
			
			RequestDispatcher rd =
					req.getRequestDispatcher("./findInfo.jsp");
			
			rd.forward(req, res);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		
	}
}
