package spms.servlets.notice;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.NoticeDao;
import spms.dto.NoticeDto;


@WebServlet("/notice/update")
public class NoticeUpdateServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		try {
			
			int no = Integer.parseInt(req.getParameter("no"));
			
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");
			
			NoticeDao noticeDao = new NoticeDao();
			
			noticeDao.setConnection(conn);
		
			NoticeDto noticeDto = noticeDao.noticeSelectOne(no);

			req.setAttribute("noticeDto", noticeDto);
			
			RequestDispatcher rd = req.getRequestDispatcher("./NoticeContext.jsp");

			rd.forward(req, res);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		NoticeDto noticeDto = null;
		
		Connection conn = null;
		
		try {
			
			
			String title = req.getParameter("title");
		
			String contents = req.getParameter("contents");
		
			String writer = req.getParameter("writer");
			
			String nno = req.getParameter("no");
			
			int no = Integer.parseInt(nno);
		
			
			System.out.println("여기까진 왔다1.2");
			
			noticeDto = new NoticeDto();
			noticeDto.setTitle(title);
			noticeDto.setContents(contents);
			noticeDto.setWriter(writer);
			noticeDto.setNo(no);
			
			System.out.println("여기까진 왔다1.5");
			
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			
			System.out.println("여기까진 왔다2");
			
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			
			int result = noticeDao.noticeUpdate(noticeDto);
			System.out.println(result);
			res.sendRedirect("./list");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
	}
	
}
