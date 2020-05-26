package mtp.management;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mtp.dao.MemberDao;
import mtp.dto.MemberDto;

@WebServlet(value="/memberManagement/list")
public class MemberManagement extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		Connection conn = null;
		
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);

			ArrayList<MemberDto> adminList = null;
			adminList = (ArrayList<MemberDto>)memberDao.adminCheck();
			
			ArrayList<MemberDto> memberList = null;
			memberList = (ArrayList<MemberDto>)memberDao.memberCheck();
			
			req.setAttribute("adminList", adminList);
			req.setAttribute("memberList", memberList);
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("./MemberManagementView.jsp");
			
			dispatcher.forward(req, res);
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, res);
		}
	}
	
}
