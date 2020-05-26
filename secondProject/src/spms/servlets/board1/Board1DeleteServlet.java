package spms.servlets.board1;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.Board1Dao;

@WebServlet("/board1/delete")
public class Board1DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		Connection conn = null;

		ServletContext sc = this.getServletContext();

		int no = Integer.parseInt(req.getParameter("no"));

		System.out.println("회원 번호 : " + no + " 삭제를 한다");
		
		conn = (Connection) sc.getAttribute("conn");

		Board1Dao board1Dao = new Board1Dao();

		board1Dao.setConnection(conn);

		try {
			int result = 0;
			
			result = board1Dao.board1Delete(no);

			if(result == 0) {
				System.out.println("회원 삭제에 실패 했습니다.");
			}
			res.sendRedirect("./list?pageNo=1");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert into member 수행 실패");
		} 

		
		
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}
	
	
}
