package spms.servlets.board1;

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

import spms.dao.Board1Dao;
import spms.dto.Board1Dto;
import spms.dto.MemberDto;

@WebServlet("/board1/list")
public class Board1ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;

		try {
			ServletContext sc = this.getServletContext();

//			int pageNo = Integer.parseInt(req.getParameter("pageNo"));
			
			conn = (Connection) sc.getAttribute("conn");

			Board1Dao board1Dao = new Board1Dao();

			board1Dao.setConnection(conn);

			ArrayList<Board1Dto> board1List = null;

//			board1List = (ArrayList<Board1Dto>)board1Dao.selectList(pageNo);
			board1List = (ArrayList<Board1Dto>)board1Dao.selectList();

			req.setAttribute("board1List", board1List);

			RequestDispatcher dispatcher = req.getRequestDispatcher("./board1ListView.jsp");

			dispatcher.forward(req, res);

		} catch (Exception e) {
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, res);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
