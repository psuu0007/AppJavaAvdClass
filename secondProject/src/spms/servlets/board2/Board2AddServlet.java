package spms.servlets.board2;

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

import spms.dao.Board2Dao;
import spms.dao.MemberDao;
import spms.dto.Board2Dto;
import spms.dto.MemberDto;

@WebServlet(value = "/board2/add")
public class Board2AddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.sendRedirect("../board2/Board2AddForm.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		HttpSession session = req.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("memberDto");
		
		String title2 = req.getParameter("title2");
		String writer2 = memberDto.getName();
		String writerEmail2 = memberDto.getEmail();
		String contents2 = req.getParameter("contents2");

		Board2Dto board2Dto = new Board2Dto();

		board2Dto.setTitle2(title2);
		board2Dto.setWriter2(writer2);
		board2Dto.setWriterEmail2(writerEmail2);
		board2Dto.setContents2(contents2);

		ServletContext sc = this.getServletContext();

		conn = (Connection) sc.getAttribute("conn");

		Board2Dao board2Dao = new Board2Dao();
		board2Dao.setConnection(conn);
		
		try {
			int result = board2Dao.board2Insert(board2Dto);
			
			if(result == 0) {
				System.out.println("회원가입~~~~~ 실패!");
			}
			
			
			if(session.getAttribute("board2Dto") == null) {
				res.sendRedirect("./list");
			} else {
				res.sendRedirect("./list");
			}
			
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
