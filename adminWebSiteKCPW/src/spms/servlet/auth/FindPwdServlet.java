package spms.servlet.auth;

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

import spms.dao.AuthDao;
import spms.dao.MemberDao;
import spms.dto.MemberDto;

@WebServlet("/auth/find")
public class FindPwdServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = req.getRequestDispatcher("./FindPwdForm.jsp");
		rd.forward(req, res);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String email = req.getParameter("email");
		
		MemberDto memberDto = new MemberDto(); 
		
		ServletContext sc = this.getServletContext();
		conn = (Connection) sc.getAttribute("conn");
			
		AuthDao authDao = new AuthDao();
		
		authDao.setConnection(conn);
		
		String password="";
		String errorMsg = "";
		
		try {
			password = authDao.findPwdByEmail(email);
			
			req.setAttribute("email", email);
			req.setAttribute("password", password);
			
			if(password == "") {
				System.out.println("가입되지 않은 회원입니다.");
				errorMsg = "가입되지 않은 회원입니다.";
				req.setAttribute("errorMsg", errorMsg);
			}
			
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("./FindPwdForm.jsp");
			dispatcher.forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("어디야 doPost 에러창인가");
		} finally {
			try {
				if(rs != null)
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try {
				if(pstmt != null)
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
	}
	
}

