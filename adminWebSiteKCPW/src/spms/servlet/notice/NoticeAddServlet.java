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

@WebServlet(value="/admin/add")
public class NoticeAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.sendRedirect("./NoticeAddForm.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeDto noticeDto = new NoticeDto();
		
		noticeDto.setTitle(title);
		noticeDto.setContent(content);
		
		ServletContext sc = this.getServletContext();

		conn = (Connection) sc.getAttribute("conn");
		
		NoticeDao noticeDao = new NoticeDao();
		
		noticeDao.setConnection(conn);
		
		// 0이면 못 넣음 0이외에는 성공
		int result;
		try {
			if(title.length() != 0 && content.length() != 0 ) {
				HttpSession session = req.getSession();
				MemberDto me = (MemberDto) session.getAttribute("memberDto");
				
				result = noticeDao.noticeInsert(noticeDto, me);
				
				if(result == 0){
					System.out.println("글쓰기 실패");
				}
				res.sendRedirect("./list");
				
			} else {
				
				req.setAttribute("titleStr", title);
				req.setAttribute("contentStr", content);				
				
				RequestDispatcher rd = 
						req.getRequestDispatcher("./NoticeAddForm.jsp");
				rd.forward(req, res);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
