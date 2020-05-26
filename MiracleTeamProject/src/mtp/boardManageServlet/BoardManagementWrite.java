package mtp.boardManageServlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mtp.boardManageDao.BoardManagementDao;
import mtp.boardManageDto.BoardManagementDto;

@WebServlet(value="/boardManagement/write")
public class BoardManagementWrite extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.sendRedirect("../boardManagement/BoardWriteForm.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		String writer = req.getParameter("writer");
		String title = req.getParameter("title");
		String context = req.getParameter("context");
		
		BoardManagementDto boardManagementDto = new BoardManagementDto();
		
		boardManagementDto.setWriter(writer);
		boardManagementDto.setTitle(title);
		boardManagementDto.setContext(context);
		
		ServletContext sc = this.getServletContext();

		conn = (Connection) sc.getAttribute("conn");
		
		BoardManagementDao boardManagementDao = new BoardManagementDao();
		
		boardManagementDao.setConnection(conn);
		
		// 0이면 못 넣음 0이외에는 성공
		int result;
		try {
			result = boardManagementDao.boardManagementWrite(boardManagementDto);
			
			if(result == 0){
				System.out.println("글쓰기 실패");
			}
			
			res.sendRedirect("./list");
			
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, res);
		}
	}
}
