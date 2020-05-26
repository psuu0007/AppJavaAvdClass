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
import mtp.dto.MemberDto;

@WebServlet(value="/memberManagement/update")
public class MemberManagementUpdate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		RequestDispatcher rd = null;

		String mNo = "";
		String aNo = "";

		try {
			mNo = req.getParameter("mmNo");
			aNo = req.getParameter("adNo");
			
			
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			if (mNo != null) {
				int no = Integer.parseInt(mNo);
				MemberDto memberDto = memberDao.memberSelectThis(no);
				req.setAttribute("memberDto", memberDto);
				
			} else if (aNo != null) {
				int abNo = Integer.parseInt(aNo);
				MemberDto adminDto = memberDao.adminSelectThis(abNo);
				req.setAttribute("adminDto", adminDto);
			}
			rd = req.getRequestDispatcher("./MemberManagementUpdateView.jsp");
			rd.forward(req, res);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, 
		HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDto memberDto = null;
		
		Connection conn = null;
		
		String mNo = "";
		String aNo = "";
		
		try {
			String email = req.getParameter("email");
			String name = req.getParameter("name");
			String pwd = req.getParameter("password");
			mNo = req.getParameter("mmNo");
			aNo = req.getParameter("adNo");
			
			HttpSession session = req.getSession();
			mtp.login.dto.MemberDto member = (mtp.login.dto.MemberDto) session.getAttribute("member");
			
			//관리자 일때 실행
			if ("admin".equals(member.getEmail())) {
				if (mNo != null) {
					int no = Integer.parseInt(mNo);
					memberDto = new MemberDto();
					memberDto.setEmail(email);
					memberDto.setName(name);
					memberDto.setPassword(pwd);
					memberDto.setNo(no);
					
					ServletContext sc = this.getServletContext();
					
					conn = (Connection) sc.getAttribute("conn");
					
					MemberDao memberDao = new MemberDao();
					memberDao.setConnection(conn);
					int result = memberDao.memberManagementUpdate(memberDto);
					
					if(result == 0){
						System.out.println("회원 정보 조회가 실패하였습니다.");
					}
					res.sendRedirect("./list");
//					res.sendRedirect("../noticeBoard/list");
					
				} else if (aNo != null) {
					int abNo = Integer.parseInt(aNo);	
					memberDto = new MemberDto();
					memberDto.setEmail(email);
					memberDto.setName(name);
					memberDto.setPassword(pwd);
					memberDto.setNo(abNo);
					
					ServletContext sc = this.getServletContext();
					
					conn = (Connection) sc.getAttribute("conn");
					
					MemberDao memberDao = new MemberDao();
					memberDao.setConnection(conn);
					
					int admin = memberDao.adminManagementUpdate(memberDto);
					
					if(admin == 0) {
						System.out.println("관리자 정보 조회가 실패하였습니다.");
					}
					res.sendRedirect("../noticeBoard/list");
//					res.sendRedirect("./list");
				}
			//회원일때 실행
			} else if (!"admin".equals(member.getEmail())) {
				if (mNo != null) {
					int no = Integer.parseInt(mNo);
					memberDto = new MemberDto();
					memberDto.setEmail(email);
					memberDto.setName(name);
					memberDto.setPassword(pwd);
					memberDto.setNo(no);
					
					ServletContext sc = this.getServletContext();
					
					conn = (Connection) sc.getAttribute("conn");
					
					MemberDao memberDao = new MemberDao();
					memberDao.setConnection(conn);
					int result = memberDao.memberManagementUpdate(memberDto);
					
					if(result == 0){
						System.out.println("회원 정보 조회가 실패하였습니다.");
					}
					res.sendRedirect("../noticeBoard/list");
//					res.sendRedirect("./list");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		} 

	}
}
