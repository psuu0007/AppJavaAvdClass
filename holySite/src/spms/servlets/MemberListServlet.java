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
import spms.dto.MemberDto;
import spms.dto.NoticeDto;

@WebServlet(value="/member/list")
public class MemberListServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			ArrayList<MemberDto> memberList = null;
			
			int pageNo = 0;
			try {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			} catch (Exception e) {
				// TODO: handle exception
				pageNo = 1;
			}

			int pageCnt = memberDao.getCount();
			int pageUnit = 10;
			pageCnt = (int)Math.ceil((double)pageCnt / pageUnit);
			
//			if(pageNo == 0) {
//				noticeList = (ArrayList<NoticeDto>)noticeDao.selectList();
//			} else {
				memberList = (ArrayList<MemberDto>)memberDao.selectList(pageUnit, pageNo);
//			}
			
			// 데이터베이스에서 회원 정보를 가져온다
			//memberList = (ArrayList<MemberDto>)memberDao.selectList();
			
			// request에 회원 목록 데이터 보관한다
			request.setAttribute("memberList", memberList);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("pageNo", pageNo);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			//jsp로 출력을 위임한다
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("./memberListView.jsp");
			
			dispatcher.include(request, response);
		} catch (Exception e) {
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}
	
}
