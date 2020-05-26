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

@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("./BoardAddForm.jsp");
		rd.forward(req, res);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	
		Connection conn = null;
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		
		BoardDto boardDto = new BoardDto();
		
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDto.setEmail(email);
		boardDto.setMyName(name);
		
		ServletContext sc = this.getServletContext();
		conn = (Connection) sc.getAttribute("conn");
		
		BoardDao boardDao = new BoardDao();
		boardDao.setConnection(conn);
		
		int result;
		
		try {
			if(title.length() != 0 && content.length() != 0) {
			
			result = boardDao.boardInsert(boardDto);
			
			if(result == 0) {
				System.out.println("글쓰기 추가 실패");
			}
			res.sendRedirect("./list");
			} else {
				req.setAttribute("title", title);
				req.setAttribute("content", content);
				
				RequestDispatcher rd = 
						req.getRequestDispatcher("./BoardAddForm.jsp");
				rd.forward(req, res);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
