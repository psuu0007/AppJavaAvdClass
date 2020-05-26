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

@WebServlet(value="/notice/list")
public class NoticeListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			
			ArrayList<NoticeDto> noticeList = null;
			
			int pageNo = 0;
			try {
				pageNo = Integer.parseInt(req.getParameter("pageNo"));
			} catch (Exception e) {
				// TODO: handle exception
				pageNo = 1;
			}

			int pageCnt = noticeDao.getCount();
			int pageUnit = 10;
			pageCnt = (int)Math.ceil((double)pageCnt / pageUnit);
			
//			if(pageNo == 0) {
//				noticeList = (ArrayList<NoticeDto>)noticeDao.selectList();
//			} else {
				noticeList = (ArrayList<NoticeDto>)noticeDao.selectList(pageUnit, pageNo);
//			}
			
			req.setAttribute("noticeList", noticeList);
			req.setAttribute("pageCnt", pageCnt);
			req.setAttribute("pageNo", pageNo);
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			//jsp로 출력을 위임한다
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("./NoticeView.jsp");
			
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

	}
	
}
