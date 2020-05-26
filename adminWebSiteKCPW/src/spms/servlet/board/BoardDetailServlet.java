package spms.servlet.board;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.BoardDao;
import spms.dto.BoardDto;

@WebServlet(value="/board/detail")
public class BoardDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Connection conn = null;
		
		ServletContext sc = this.getServletContext();
		conn = (Connection) sc.getAttribute("conn");
		
		BoardDao boardDao = new BoardDao();
		boardDao.setConnection(conn);

		BoardDto boardDto = new BoardDto();	
		int no = Integer.parseInt(req.getParameter("no"));
		boardDto = boardDao.boardSelectOne(no);
		
		req.setAttribute("boardDto", boardDto);
		
		RequestDispatcher rd = req.getRequestDispatcher("./BoardDetailView.jsp");
		rd.forward(req, res);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int no = Integer.parseInt(req.getParameter("no"));
		System.out.println("post no : "+ no);
		
		
		res.sendRedirect("./update?no="+no);
		
	}
	
	
}
