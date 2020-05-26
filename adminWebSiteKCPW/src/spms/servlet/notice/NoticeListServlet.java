package spms.servlet.notice;

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

import spms.dao.NoticeDao;
import spms.dto.BoardDto;
import spms.dto.NoticeDto;

@WebServlet(value="/admin/list")
public class NoticeListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		try {
			
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			NoticeDao noticeDao = new NoticeDao();
			
			noticeDao.setConnection(conn);
			
			ArrayList<NoticeDto> noticeList = null;
			ArrayList<NoticeDto> noticeListLatest = null;	
			
			int total = 0;
			//게시글 전체 개수 조회
			total = noticeDao.boardTotalCount();
			
			int pageNum = 0;	//페이지 개수 
			int currentNo = 0;	//선택 페이지 번호
			if(req.getParameter("currentNo") != null) {			
				currentNo = Integer.parseInt(req.getParameter("currentNo"));
//				System.out.println("get currentNo: "+currentNo);
			}else {
				currentNo = 1;
//				System.out.println("get currentNo: "+currentNo);
			}

			if(total % 10 == 0 ){
				pageNum = total/10;
			}else{
				pageNum = total/10 + 1;
			}
			
//			System.out.println("total : "+total);
//			System.out.println("pageNum : "+pageNum);
			
			noticeList = (ArrayList<NoticeDto>)noticeDao.boardSelectTen(currentNo);
			req.setAttribute("noticeList", noticeList);
			
			int startNum = 1;
			int endNum = pageNum;
			if(pageNum <= 5) {
//				System.out.println("페이지 1-5");
				startNum = 1;
				endNum = pageNum;
			}else if(pageNum > 5 && currentNo == 1) {
//				System.out.println("페이지 1-5");
				startNum = 1;
				endNum = 5;
			}else if(pageNum > 5 && currentNo != 1 && currentNo <= 5) {
//				System.out.println("페이지 23456");
				startNum = 1;
				endNum = 5;
			}else if(pageNum > 5 && pageNum >= currentNo + 5 && currentNo != 1 && currentNo > 5) {
//				System.out.println("페이지 678910");
				startNum = currentNo-2;
				endNum = currentNo+2;
			}else if(pageNum > 5 && pageNum < currentNo + 5 &&  currentNo != 1 && currentNo > 5) {
//				System.out.println("페이지 11 12 13 14 마지막페이지");
				startNum = pageNum - 4;
				endNum = pageNum;
			}else {
				System.out.println("조건추가하기");
			}
			
			//페이지 개수 전달
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("startNum", startNum);
			req.setAttribute("endNum", endNum);
			req.setAttribute("currentNo", currentNo);
			
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("/admin/NoticeListView.jsp");
			
			dispatcher.forward(req, res);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			req.setAttribute("error", e);
			
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("/ErrorNoticeView.jsp");
			
			dispatcher.forward(req, res);
		}
	}
	
}
