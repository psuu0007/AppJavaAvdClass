package mtp.notice.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

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

@WebServlet(value = "/noticeBoard/list")
public class NoticeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		
		Connection conn = null;
				
		try {
			// 연결 
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			// DB 연결( 게시물정보(NoticeDto) )

			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			
			// 게시물 목록 및 검색 데이터 조회	
			int spage = 1;
			String page = req.getParameter("page"); // 페이지번호를 눌렀을 경우 ! 받아서 spage를 변경시킨다
			String opt = req.getParameter("opt");
			String condition = req.getParameter("condition");
			
			if(page != null) {
				spage = Integer.parseInt(page);
			}
			
			HashMap<String, Object> listOpt = new HashMap<String, Object>();
			listOpt.put("opt", opt);
			listOpt.put("condition", condition);
			listOpt.put("start", spage*10-9);			
			
			// 게시물 정보 읽기 ( 			
			ArrayList<NoticeDto> noticeList = null;
			int listCount = noticeDao.listCount(listOpt);
			noticeList = (ArrayList<NoticeDto>)noticeDao.selectList(listOpt);
			
			 // 전체 페이지 수
	        int maxPage = (int)(listCount/10.0 + 0.9);
	        //시작 페이지 번호
	        int startPage = (int)(spage/5.0 + 0.8) * 5 - 4;
	        //마지막 페이지 번호
	        int endPage = startPage + 4;
	        if(endPage > maxPage)    endPage = maxPage;
	        
	        // 4개 페이지번호 저장
	        req.setAttribute("spage", spage);
	        req.setAttribute("maxPage", maxPage);
	        req.setAttribute("startPage", startPage);
	        req.setAttribute("endPage", endPage);

			// 데이터 전달을 위해 request에  데이터 보관
			req.setAttribute("noticeList", noticeList);
			
			// 공지사항게시판폼으로 이동
			RequestDispatcher rd = 
					req.getRequestDispatcher("./noticeBoardForm.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher rd = 
					req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		} // catch End
		
	} // doGet End
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {

	}
	
}
