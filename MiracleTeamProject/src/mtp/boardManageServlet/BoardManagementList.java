package mtp.boardManageServlet;

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

import mtp.boardManageDao.BoardManagementDao;
import mtp.boardManageDto.BoardManagementDto;
import mtp.notice.dto.NoticeDto;

@WebServlet(value="/boardManagement/list")
public class BoardManagementList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");

			BoardManagementDao boardManagementDao = new BoardManagementDao();
			boardManagementDao.setConnection(conn);
			
			// 게시물 목록 및 검색 데이터 조회	
			int spage = 1;
			String page = req.getParameter("page"); // 페이지번호를 눌렀을 경우 ! 받아서 spage를 변경시킨다
			String opt = req.getParameter("opt");
			String condition = req.getParameter("condition");
			
			if(page != null) {
				spage = Integer.parseInt(page);
			}
			
			HashMap<String, Object> ListOpt = new HashMap<String, Object>();
			ListOpt.put("opt", opt);
			ListOpt.put("condition", condition);
			ListOpt.put("start", spage*10-9);	
			
			ArrayList<BoardManagementDto> boardManagementList = null;
			int listCount = boardManagementDao.listCount(ListOpt);
			
			// 데이터베이스에서 회원 정보를 가져온다
			boardManagementList = (ArrayList<BoardManagementDto>)boardManagementDao.selectList(ListOpt);
			
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
			
			// request에 회원 목록 데이터 보관한다
			req.setAttribute("boardManagementList", boardManagementList);

			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			//jsp로 출력을 위임한다
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("./BoardListForm.jsp");
			
			dispatcher.forward(req, res);
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, res);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
