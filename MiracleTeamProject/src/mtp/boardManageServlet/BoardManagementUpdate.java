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
import mtp.boardManageDto.BoardManagementDto;

@WebServlet(value="/boardManagement/update")
public class BoardManagementUpdate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		RequestDispatcher rd = null;

		String mNo = "";

		try {
			mNo = req.getParameter("no");
			int no = Integer.parseInt(mNo);

			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");
			
			BoardManagementDao boardManagementDao = new BoardManagementDao();
			boardManagementDao.setConnection(conn);
			String page = req.getParameter("page");
			
			BoardManagementDto boardManagementDto = boardManagementDao.boardSelectOne(no);
			
			req.setAttribute("boardManagementDto", boardManagementDto);
			req.setAttribute("page", page);
			rd = req.getRequestDispatcher("./BoardUpdateForm.jsp");
			rd.forward(req, res);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);
			rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardManagementDto boardManagementDto = null;
		
		Connection conn = null;
		
		try {
			
			String writer = req.getParameter("writer");
			String title = req.getParameter("title");
			String context = req.getParameter("context");
			String mNo = req.getParameter("no");
			int no = Integer.parseInt(mNo);
			
			boardManagementDto = new BoardManagementDto();
			boardManagementDto.setWriter(writer);
			boardManagementDto.setTitle(title);
			boardManagementDto.setContext(context);
			boardManagementDto.setNo(no);
			
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			BoardManagementDao boardManagementDao = new BoardManagementDao();
			boardManagementDao.setConnection(conn);
			
			int result = boardManagementDao.boardUpdate(boardManagementDto);

			if(result == 0){
				System.out.println("게시글 조회가 실패하였습니다.");
			}
			
			res.sendRedirect("./list");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		} 
	}
}
