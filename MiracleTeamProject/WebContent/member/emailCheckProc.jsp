<%@page import="java.sql.Connection"%>
<%@page import="mtp.login.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인 결과</title>
</head>
<body>
	<div style="text-align: center">
		<h3>* 아이디 중복 확인 결과 *</h3>
		<%
			//1) 사용가능한 아이디일 경우, 아이디 입력 폼에 넣기 위함

			String email = request.getParameter("email");

			MemberDao dao = new MemberDao();

			Connection conn = null;
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");

			dao.setConnection(conn);
			int cnt = dao.duplecateEmail(email);
			out.println("입력 Email : <strong>" + email + "</stong>");
			if (cnt == 0) {
				out.println("<p>사용 가능한 이메일입니다.</p>");
				out.println("<p style='color:red'\">주의! 사용하기 선택시 이메일 변경이 불가능합니다.</p>");
				out.println("<p style='color:red'\">변경을 원하시면 이메일 변경 버튼을 눌러주세요</p>");
				out.println("<a href='javascript:apply(\"" + email + "\")'>[사용하기]</a>");
		%>
		<script>
			function apply(email) {
				//2) 중복확인 id를 부모창에 적용
				//부모창 opener
				opener.document.userInfo.email.value = email;
				opener.document.userInfo.email.readOnly = true;
				opener.document.userInfo.emailEqual.value = "emailCheck";
				window.close(); //창닫기
			}//apply () end
		</script>
		<%
			} else {
				out.println("<p style='color: red'>중복되는 이메일이있습니다.</p>");
			} //if end
		%>
		<hr>
		<a href="javascript:history.back()">[이메일 변경]</a> &nbsp; &nbsp; <a
			href="javascript:window.close()">[창닫기]</a>
	</div>
</body>
</html>

