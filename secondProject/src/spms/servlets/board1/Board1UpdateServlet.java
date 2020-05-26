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

import spms.dao.Board1Dao;
import spms.dao.Board1Dao;
import spms.dto.Board1Dto;
import spms.dto.Board1Dto;

@WebServlet("/board1/update")
public class Board1UpdateServlet extends HttpServlet{

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

			Board1Dto board1Dto = board1Dao.board1SelectOne(no);

			req.setAttribute("board1Dto", board1Dto);

			rd = req.getRequestDispatcher("./board1UpdateForm.jsp");

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
		Connection conn = null;

		
		int no = Integer.parseInt(req.getParameter("no"));
		String title = req.getParameter("title");
		String contents = req.getParameter("content");
		

		ServletContext sc = this.getServletContext();
		
		conn = (Connection) sc.getAttribute("conn");

		Board1Dto board1Dto = new Board1Dto();

		board1Dto.setNo(no);
		board1Dto.setTitle(title);
		board1Dto.setContents(contents);

		Board1Dao board1Dao = new Board1Dao();
		
		board1Dao.setConnection(conn);

		try {

			int result = 0;

			result = board1Dao.board1Update(board1Dto);

			if (result == 0) {
				System.out.println("업데이트 실패");
			}

			res.sendRedirect("./list?pageNo=1");
//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
}
