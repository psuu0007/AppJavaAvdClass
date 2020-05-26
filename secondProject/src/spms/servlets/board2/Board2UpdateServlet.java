package spms.servlets.board2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.Board2Dao;
import spms.dao.MemberDao;
import spms.dto.Board2Dto;
import spms.dto.MemberDto;

@WebServlet(value = "/board2/update")
public class Board2UpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		RequestDispatcher rd = null;

		String bno2 = "";
		
		try {
			bno2 = req.getParameter("bno2");
			int no = Integer.parseInt(bno2);

			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");
			
			Board2Dao board2Dao = new Board2Dao();
			board2Dao.setConnection(conn);
			
			Board2Dto board2Dto = board2Dao.board2SelectOne(no);
			
			req.setAttribute("board2Dto", board2Dto);
			rd = req.getRequestDispatcher("./Board2UpdateForm.jsp");
			rd.forward(req, res);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);
			rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		Board2Dto board2Dto = null;
		
		Connection conn = null;
		
		try {
			
			String title2 = req.getParameter("title2");
			String contents2 = req.getParameter("contents2");
			String bno2 = req.getParameter("bno2");
			int no = Integer.parseInt(bno2);
			
			board2Dto = new Board2Dto();
			board2Dto.setTitle2(title2);
			board2Dto.setContents2(contents2);
			board2Dto.setBno2(no);
			
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			Board2Dao board2Dao = new Board2Dao();
			board2Dao.setConnection(conn);
			
			int result = board2Dao.board2Update(board2Dto);

			if(result == 0){
				System.out.println("게시글 수정이 실패하였습니다.");
			}
			
			res.sendRedirect("./list");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		} 

	}
}
