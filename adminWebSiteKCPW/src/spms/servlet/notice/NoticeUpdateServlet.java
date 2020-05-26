package spms.servlet.notice;

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

import spms.dao.NoticeDao;
import spms.dto.MemberDto;
import spms.dto.NoticeDto;

@WebServlet(value="/admin/update")
public class NoticeUpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		RequestDispatcher rd = null;
		
		try {
			
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");
			
			int noticeNo = Integer.parseInt(req.getParameter("noticeNo"));
			
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			
			NoticeDto noticeDto = noticeDao.noticeSelectOne(noticeNo);
			
			req.setAttribute("noticeDto", noticeDto);
			rd = req.getRequestDispatcher("./NoticeUpdateForm.jsp");
			
			rd.forward(req, res);
			
		} catch (Exception e) {
			// TODO: handle exception
			
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
		
		NoticeDto noticeDto = null;
		Connection conn = null;
		
		try {
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");

			int noticeNo = Integer.parseInt(req.getParameter("noticeNo"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			
			noticeDto = new NoticeDto(noticeNo, title, content);
			
			HttpSession session = req.getSession();
			MemberDto me = (MemberDto) session.getAttribute("memberDto");

			String myEmail = me.getEmail();
			
			int result = noticeDao.noticeUpdate(noticeDto, myEmail);
			
			if(result == 0) {
				System.out.println("상세글 수정이 실패하였습니다.");
			}
			res.sendRedirect("./list");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		}
		
	}
	
}
