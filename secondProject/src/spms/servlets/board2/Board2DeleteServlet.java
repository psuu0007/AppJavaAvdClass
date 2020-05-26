package spms.servlets.board2;

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

import spms.dao.Board2Dao;
import spms.dao.MemberDao;

@WebServlet(value = "/board2/delete")
public class Board2DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;

		int bno2 = Integer.parseInt(req.getParameter("bno2"));

		try {
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			Board2Dao board2Dao = new Board2Dao();
			board2Dao.setConnection(conn);

			int result = board2Dao.board2Delete(bno2);

			if (result == 0) {
				System.out.println("게시글 삭제가 정상처리 되지 않았습니다");
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
