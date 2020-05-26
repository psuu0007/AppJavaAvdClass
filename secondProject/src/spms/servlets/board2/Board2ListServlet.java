package spms.servlets.board2;

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

import spms.dao.Board2Dao;
import spms.dto.Board2Dto;
import spms.dto.MemberDto;

@WebServlet(value = "/board2/list")
public class Board2ListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
			Board2Dao board2Dao = new Board2Dao();
			board2Dao.setConnection(conn);
			
			ArrayList<Board2Dto> board2List = null;
			board2List = (ArrayList<Board2Dto>)board2Dao.selectList();
			req.setAttribute("board2List", board2List);
			RequestDispatcher rd = req.getRequestDispatcher("./Board2ListView.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher rd =
					req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
