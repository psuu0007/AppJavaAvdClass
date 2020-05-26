package spms.servlet.board;

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

import spms.dao.BoardDao;
import spms.dto.MemberDto;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		Connection conn = null;
		
		ServletContext sc = this.getServletContext();
		conn = (Connection) sc.getAttribute("conn");

		BoardDao boardDao = new BoardDao();
		boardDao.setConnection(conn);
		
		int result;
		
		try {
			HttpSession session = req.getSession();
			MemberDto memberDto = (MemberDto) session.getAttribute("memberDto");
			
			int no = Integer.parseInt(req.getParameter("no"));

			if(memberDto.getGrade().equals("admin")) {
				result = boardDao.boardAdminDelete(no);
			}else {
				String myEmail = memberDto.getEmail();				
				result = boardDao.boardDelete(no, myEmail);
			}
			
			if (result == 0) {
				System.out.println("게시판글이 삭제되지 않았습니다.");
			}
			res.sendRedirect("./list");
			
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("./Error.jsp");
			rd.forward(req, res);
		}
		
	}

}
