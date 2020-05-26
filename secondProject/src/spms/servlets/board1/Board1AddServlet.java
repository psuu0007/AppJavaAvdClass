package spms.servlets.board1;

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

import spms.dao.Board1Dao;
import spms.dao.MemberDao;
import spms.dto.Board1Dto;
import spms.dto.MemberDto;

@WebServlet("/board1/add")
public class Board1AddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.sendRedirect("./board1AddForm.jsp");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;

		HttpSession session = req.getSession();

		MemberDto memberDto = (MemberDto)session.getAttribute("memberDto");

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = memberDto.getName();
		String writerEmail = memberDto.getEmail();
		
		Board1Dto board1Dto = new Board1Dto();

		board1Dto.setTitle(title);
		board1Dto.setContents(content);
		board1Dto.setWriter(writer);
		board1Dto.setWriterEmail(writerEmail);

		ServletContext sc = this.getServletContext();

		conn = (Connection) sc.getAttribute("conn");

		Board1Dao board1Dao = new Board1Dao();
		
		board1Dao.setConnection(conn);

		try {
			
			int result = board1Dao.board1Insert(board1Dto);

//			0이면 회원추가 실패 0이외에는 추가 성공
			if(result == 0) {
				System.out.println("글쓰기~~~~~ 실패!");
			}
			
			res.sendRedirect("./list?pageNo=1");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);
			
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, res);
		}
		
		
	}
	
	
}
