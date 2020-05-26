package mtp.notice.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mtp.login.dao.MemberDao;
import mtp.login.dto.MemberDto;
import mtp.notice.dao.NoticeDao;
import mtp.notice.dto.NoticeDto;

@WebServlet(value = "/noticeBoard/post")
public class NoticePostServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		
		res.sendRedirect("../noticeBoard/noticeBoardPost.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
				
		Connection conn = null;
		
		try {
			// 연결 
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String context = req.getParameter("context");
			
			NoticeDto noticeDto = new NoticeDto();
			noticeDto.setTitle(title);
			noticeDto.setWriter(writer);
			noticeDto.setContext(context);
			
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			noticeDao.noticeInsert(noticeDto);

			// 메인 페이지로 이동
			res.sendRedirect("./list");
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e);
			RequestDispatcher rd = 
					req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		} // catch End
		
	}
	
}
