package spms.servlets.notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.NoticeDao;
import spms.dto.NoticeDto;

@WebServlet(urlPatterns = { "/notice/list" })
public class NoticeSelectServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		RequestDispatcher rd = null;
		
		try {
			
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");
			
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
					
			ArrayList<NoticeDto> noticeList = noticeDao.noticeSelect();
			
			req.setAttribute("noticeList", noticeList);
			
			rd= req.getRequestDispatcher("./NoticeForm.jsp");
			
			rd.forward(req, res);
		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
			String nno = req.getParameter("no");
			int no = Integer.parseInt(nno);
			
			noticeDto = new NoticeDto();
			noticeDto.setTitle(title);
			noticeDto.setContents(contents);
			noticeDto.setNo(no);
			
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");
			
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			
			int result = noticeDao.noticeUpdate(noticeDto);
			
			res.sendRedirect("./NoticeForm.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
}
