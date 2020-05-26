package mtp.boardManageServlet;

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

import mtp.boardManageDao.BoardManagementDao;

@WebServlet(value="/boardManagement/delete")
public class BoardManagementDelete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;

		int no = Integer.parseInt(req.getParameter("no"));

		try {
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			BoardManagementDao boardManagementDao = new BoardManagementDao();
			boardManagementDao.setConnection(conn);

			int result = boardManagementDao.boardDelete(no);

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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
