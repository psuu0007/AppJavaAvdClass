package spms.servlets.notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javafx.scene.control.Alert;
import spms.dao.MemberDao;
import spms.dao.NoticeDao;
import spms.dto.MemberDto;
import spms.dto.NoticeDto;

@WebServlet(urlPatterns = { "/notice/add" })
public class NoticeAddServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.sendRedirect("../notice/NoticeAdd.jsp");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 	 
		Connection conn = null;
		 
		
		ServletContext sc = this.getServletContext();
		conn = (Connection) sc.getAttribute("conn");
		
		String contents = req.getParameter("nContents");
		String title = req.getParameter("nTitle");
		
		HttpSession session = req.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("memberDto");
		
		String writer = memberDto.getName();
		String writerEmail = memberDto.getEmail();
		
		NoticeDto noticeDto = new NoticeDto();
		
		noticeDto.setWriterEmail(writerEmail);
		noticeDto.setContents(contents);
		noticeDto.setTitle(title);
		noticeDto.setWriter(writer);
		
		NoticeDao noticeDao = new NoticeDao();
		noticeDao.setConnection(conn);
		
		try {
			int result = noticeDao.noticeAdd(noticeDto);
			
			if (result == 0) {
				System.out.println("추가된 공지사항이 없습니다");
			} else {
				
				res.sendRedirect("./list");
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
			
		
		 
	}
	
}
