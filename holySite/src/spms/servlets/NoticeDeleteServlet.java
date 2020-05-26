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
import spms.dao.NoticeDao;
import spms.dto.MemberDto;

@WebServlet(value="/notice/delete")
public class NoticeDeleteServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;

		int no = Integer.parseInt(req.getParameter("no"));

		try {
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);

			int result = noticeDao.noticeDelete(no);

			if (result == 0) {
				System.out.println("회원 삭제가 정상처리 되지 않았습니다");
			}

			res.sendRedirect("./list");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
