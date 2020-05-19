package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/member/delete")
public class MemberDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		ServletContext sc = this.getServletContext();
		
//		사용자의 입력을 받는다
		int mNo = Integer.parseInt(req.getParameter("no"));

		System.out.println("회원 번호 : " + mNo + " 삭제를 한다");
		
		try {
			conn = (Connection)sc.getAttribute("conn");

			String sql = "delete FROM member"; 
			sql += " where mno = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, mNo);

			int resultNum = pstmt.executeUpdate();

			System.out.println("delete 수행결과 : " + resultNum);
			
			res.sendRedirect("./list");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert into member 수행 실패");
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("pstmt 종료 실패");
				}
			}
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 오버라이딩");

	}

}
