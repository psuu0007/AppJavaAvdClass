package spms.servlet.board;

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
import javax.servlet.http.HttpSession;

import spms.dao.BoardDao;
import spms.dao.MemberDao;
import spms.dto.BoardDto;
import spms.dto.MemberDto;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

@WebServlet(value="/board/list")
public class BoardListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		Connection conn = null;
		
		ServletContext sc = this.getServletContext();
		conn = (Connection) sc.getAttribute("conn");
		
		BoardDao boardDao = new BoardDao();
		boardDao.setConnection(conn);
		
		ArrayList<BoardDto> boardList = null;	
//		ArrayList<BoardDto> boardListLatest = null;	
		
		//게시글 전체 조회 
		//boardList = (ArrayList<BoardDto>) boardDao.boardSelectList();
		
		int total = 0;
		//게시글 전체 개수 조회
		total = boardDao.boardTotalCount();
		
		int pageNum = 0;	//페이지 개수 
		int currentNo = 0;	//선택 페이지 번호
		if(req.getParameter("currentNo") != null) {			
			currentNo = Integer.parseInt(req.getParameter("currentNo"));
//			System.out.println("get currentNo: "+currentNo);
		}else {
			currentNo = 1;
//			System.out.println("get currentNo: "+currentNo);
		}

		if(total % 10 == 0 ){
			pageNum = total/10;
		}else{
			pageNum = total/10 + 1;
		}
		
//		System.out.println("total : "+total);
//		System.out.println("pageNum : "+pageNum);
		
		//게시글 10개씩 조회 
		boardList = (ArrayList<BoardDto>) boardDao.boardSelectTen(currentNo);
		req.setAttribute("boardList", boardList);
		
		//게시글 10개씩 등록일 순서 조회
//		boardListLatest = (ArrayList<BoardDto>) boardDao.boardSelectTenLatest(currentNo);
//		req.setAttribute("boardList", boardListLatest);
		
		
		int startNum = 1;
		int endNum = pageNum;
		if(pageNum <= 5) {
//			System.out.println("페이지 1-5");
			startNum = 1;
			endNum = pageNum;
		}else if(pageNum > 5 && currentNo == 1) {
//			System.out.println("페이지 1-5");
			startNum = 1;
			endNum = 5;
		}else if(pageNum > 5 && currentNo != 1 && currentNo <= 5) {
//			System.out.println("페이지 23456");
			startNum = 1;
			endNum = 5;
		}else if(pageNum > 5 && pageNum >= currentNo + 5 && currentNo != 1 && currentNo > 5) {
//			System.out.println("페이지 678910");
			startNum = currentNo-2;
			endNum = currentNo+2;
		}else if(pageNum > 5 && pageNum < currentNo + 5 &&  currentNo != 1 && currentNo > 5) {
//			System.out.println("페이지 11 12 13 14 마지막페이지");
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
				req.getRequestDispatcher("./BoardListView.jsp");
		
		dispatcher.forward(req, res);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
	}
	
	
}
