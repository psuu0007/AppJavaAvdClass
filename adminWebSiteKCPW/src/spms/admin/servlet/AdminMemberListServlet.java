package spms.admin.servlet;

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
import spms.dto.MemberDto;

@WebServlet(value="/admin/member/list")
public class AdminMemberListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		try {
			
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			ArrayList<MemberDto> memberList = null;
			
			int total = 0;
			//게시글 전체 개수 조회
			total = memberDao.memberTotalCount();
			
			int pageNum = 0;	//페이지 개수 
			int currentNo = 0;	//선택 페이지 번호
			if(req.getParameter("currentNo") != null) {			
				currentNo = Integer.parseInt(req.getParameter("currentNo"));
			}else {
				currentNo = 1;
			}

			if(total % 10 == 0 ){
				pageNum = total/10;
			}else{
				pageNum = total/10 + 1;
			}

			
			//멤버 10개씩 등록일 순서 조회
			memberList = (ArrayList<MemberDto>)memberDao.memberSelectTen(currentNo);
			req.setAttribute("memberList", memberList);
			
			
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
					req.getRequestDispatcher("/admin/AdminMemberListView.jsp");
			
			dispatcher.forward(req, res);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			req.setAttribute("error", e);
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("/Error.jsp");
			
			dispatcher.forward(req, res);
		}
	}

}
