package spms.servlets;

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

import spms.dao.MemberDao;
import spms.dao.NoticeDao;
import spms.dto.MemberDto;
import spms.dto.NoticeDto;

@WebServlet(value="/notice/add")
public class NoticeWriteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			//jsp로 출력을 위임한다
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("../notice/NoticeWritingView.jsp");
			
			dispatcher.include(req, res);
			
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, res);
			
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		ServletContext sc = this.getServletContext();
		conn = (Connection) sc.getAttribute("conn");
		
		String title = req.getParameter("title");
		String text = req.getParameter("text");
		int writerNo = Integer.parseInt(req.getParameter("writerNo"));
		
		MemberDao memberDao = new MemberDao();
		memberDao.setConnection(conn);
		
		MemberDto writer = new MemberDto();
		
		try {
			writer = memberDao.memberSelectOne(writerNo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		NoticeDto noticeDto = new NoticeDto();
		
		noticeDto.setText(text);
		noticeDto.setTitle(title);
		noticeDto.setWriter(writer);
		
		
		NoticeDao noticeDao = new NoticeDao();
		noticeDao.setConnection(conn);
		try {
			
			int result;
			
			result = noticeDao.addList(noticeDto);
			if(result == 0) {
				System.out.println("등록 실패");
			}else {
				System.out.println(result + "행 등록 완료");
			}

			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			//jsp로 출력을 위임한다
			res.sendRedirect("./list");
			
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, res);
			
		}


	}
	
}
