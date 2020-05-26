package spms.servlets;

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

import spms.dao.BulletinDao;
import spms.dao.MemberDao;
import spms.dto.BulletinDto;
import spms.dto.MemberDto;

@WebServlet(urlPatterns = { "/bulletin/update" })
public class BulletinUpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = this.getServletContext();
		Connection conn = null;
		
		conn = (Connection) sc.getAttribute("conn");
		RequestDispatcher rd = null;

		String mNo = "";

		try {
			mNo = req.getParameter("no");
			int no = Integer.parseInt(mNo);

			BulletinDao bulletinDao = new BulletinDao();
			bulletinDao.setConnection(conn);
			
			BulletinDto bulletinDto = bulletinDao.bulletinSelectOne(no);
			
			req.setAttribute("bulletinDto", bulletinDto);
			rd = req.getRequestDispatcher("./BulletinUpdateForm.jsp");
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
	protected void doPost(HttpServletRequest req, 
		HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = this.getServletContext();
		
		Connection conn = null;
		conn = (Connection) sc.getAttribute("conn");
		
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			String title = req.getParameter("title");
			String text = req.getParameter("text");
			
			BulletinDto bulletinDto= new BulletinDto();
			
			bulletinDto.setNo(no);
			bulletinDto.setTitle(title);
			bulletinDto.setText(text);

			BulletinDao bulletinDao = new BulletinDao();
			bulletinDao.setConnection(conn);
			
			int result = bulletinDao.bulletinUpdate(bulletinDto);

			if(result == 0){
				System.out.println("회원 정보 수정이 실패하였습니다.");
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
