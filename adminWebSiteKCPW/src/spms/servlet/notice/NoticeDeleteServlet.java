package spms.servlet.notice;

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

import spms.dao.NoticeDao;
import spms.dto.MemberDto;

@WebServlet(value="/admin/delete")
public class NoticeDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;

		int noticeNo = Integer.parseInt(req.getParameter("noticeNo"));

		try {
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");
			
			HttpSession session = req.getSession();
			MemberDto me = (MemberDto) session.getAttribute("memberDto");

			String myEmail = me.getEmail();

			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);

			int result = noticeDao.noticeDelete(noticeNo, myEmail);

			if (result == 0) {
				System.out.println("회원 삭제가 정상처리 되지 않았습니다");
			}

			res.sendRedirect("./list");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		}

	}

}
