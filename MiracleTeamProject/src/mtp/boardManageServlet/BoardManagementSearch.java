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

@WebServlet(value="/boardManagement/search")
public class BoardManagementSearch extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
Connection conn = null;
		
		try {
			// 연결 
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			BoardManagementDao boardManagementDao = new BoardManagementDao();
			boardManagementDao.setConnection(conn);
			
			int no = Integer.parseInt(req.getParameter("no"));
			String page = req.getParameter("page");
			
			// no를 활용하여 업데이트 선택된 정보가 출력되게 !
			BoardManagementDto boardManagementDto = new BoardManagementDto();
			
			boardManagementDto = boardManagementDao.boardSearchOne(no);
			
			req.setAttribute("boardManagementDto", boardManagementDto);
			req.setAttribute("page", page);

			// 공지사항게시판폼으로 이동
			RequestDispatcher rd = 
					req.getRequestDispatcher("./BoardSearchForm.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher rd = 
					req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		} // catch End
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
