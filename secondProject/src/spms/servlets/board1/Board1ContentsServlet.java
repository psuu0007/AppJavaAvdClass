package spms.servlets.board1;

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

import spms.dao.Board1Dao;
import spms.dao.MemberDao;
import spms.dto.Board1Dto;
import spms.dto.MemberDto;

@WebServlet("/board1/contents")
public class Board1ContentsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;

		RequestDispatcher rd = null;

		int no = Integer.parseInt(req.getParameter("no"));
		
		ServletContext sc = this.getServletContext();
		
		conn = (Connection) sc.getAttribute("conn");
		
		Board1Dao board1Dao = new Board1Dao();
		
		board1Dao.setConnection(conn);

		try {

			Board1Dto board1Dto = board1Dao.board1ContentsView(no);

			req.setAttribute("board1Dto", board1Dto);

			rd = req.getRequestDispatcher("./board1ContentsForm.jsp");

			rd.forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();

			req.setAttribute("error", e);
			
			rd = req.getRequestDispatcher("/Error.jsp");
			
			rd.forward(req, res);

		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	}
	
	
}
