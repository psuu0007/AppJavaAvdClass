package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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

@WebServlet(value="/notice/update")
public class NoticeUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		RequestDispatcher rd = null;

		try {
			int no = Integer.parseInt(req.getParameter("no"));
			

			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");
			
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			
			
			
			NoticeDto noticeDto = noticeDao.noticeSelectOne(no);
			
			req.setAttribute("noticeDto", noticeDto);
			rd = req.getRequestDispatcher("./NoticeUpdateView.jsp");
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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		NoticeDto noticeDto = null;
		
		Connection conn = null;
		
		try {
			
			String title = req.getParameter("title");
			String text = req.getParameter("text");
			String mNo = req.getParameter("no");
			int no = Integer.parseInt(mNo);
			
			noticeDto = new NoticeDto();
			noticeDto.setTitle(title);
			noticeDto.setText(text);
			noticeDto.setNo(no);
			
			
			
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			
			int result = noticeDao.noticeUpdate(noticeDto);

			if(result == 0){
				System.out.println("회원 정보 조회가 실패하였습니다.");
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
