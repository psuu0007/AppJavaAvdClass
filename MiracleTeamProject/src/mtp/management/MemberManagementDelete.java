package mtp.management;

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
import javax.servlet.http.HttpSession;

import mtp.dao.MemberDao;
import mtp.login.dto.MemberDto;

@WebServlet(value = "/memberManagement/delete")
public class MemberManagementDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection conn = null;

		String mNo = "";
		String aNo = "";
		String email = "";
		String adminTest = "admin";

		try {
			mNo = req.getParameter("mmNo");
			aNo = req.getParameter("adNo");
			email = req.getParameter("email");
			
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			HttpSession session = req.getSession();
			MemberDto member = (MemberDto) session.getAttribute("member");
			
//			 회원일때 실행
			if (!adminTest.equals(member.getEmail())) {
				if (mNo != null) {
					int no = Integer.parseInt(mNo);
					int result = memberDao.MemberDataDelete(no);
					if (result == 0) {
						System.out.println("회원 삭제를 실패하였습니다.");
					}
					res.sendRedirect(req.getContextPath() + "/auth/logout");
				}
			}
//			 관리자일때 실행
			if (adminTest.equals(member.getEmail())) {
					if (mNo != null) {
						int no = Integer.parseInt(mNo);
						int result = memberDao.MemberDataDelete(no);
//						res.sendRedirect("./list");
						if (result == 0) {
							System.out.println("회원 삭제를 실패하였습니다.");
						}
					}
//					else if (aNo != null) {
//						int abNo = Integer.parseInt(aNo);
//						int admin = memberDao.adminDataDelete(abNo);
//						if (admin == 0) {
//							System.out.println("관리자 삭제를 실패하였습니다.");
//						}

//				} 
					res.sendRedirect("./list");
			}

		} catch (SQLException e) {
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
			
		}
	}
}
	
