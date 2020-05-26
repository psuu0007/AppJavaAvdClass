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

import spms.dao.BulletinDao;
import spms.dao.MemberDao;

@WebServlet(value = "/bulletin/delete")
public class BulletinDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = this.getServletContext();

		Connection conn = null;
		conn = (Connection) sc.getAttribute("conn");

		int no = Integer.parseInt(req.getParameter("no"));

		try {
			BulletinDao bulletinDao = new BulletinDao();
			bulletinDao.setConnection(conn);
			
			int result = bulletinDao.bulletinDelete(no);

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
}
