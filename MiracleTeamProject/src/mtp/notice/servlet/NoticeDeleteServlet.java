package mtp.notice.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mtp.notice.dao.NoticeDao;

@WebServlet(value = "/noticeBoard/delete")
public class NoticeDeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		
		Connection conn = null;
		
		int no = Integer.parseInt(req.getParameter("no"));
		
		try {
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);

			int result = noticeDao.noticeDelete(no);

			if (result == 0) {
				System.out.println("게시물 삭제가 되지 않음");
			}

			res.sendRedirect("./list");
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		
	}
}
