<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원목록</title>

</head>

<body>

	<h1>회원목록</h1>
	<p>
		<a href='add'>신규 회원</a>
	</p>
<!-- 	스크립틀렛, 릿 (scriptlet) -->
<%-- <% %> --%>
	<%
		ArrayList<MemberDto> memberList = 
			(ArrayList<MemberDto>)request.getAttribute("memberList");
			
		for(MemberDto memberDto : memberList){
	%>
	<%=memberDto.getNo()%>,
	<a href='update?no=<%=memberDto.getNo()%>'>
		<%=memberDto.getName() %>
	</a>,
	<%=memberDto.getEmail()%>,
	<%=memberDto.getCreateDate()%>
	<a href='.delete?no=<%=memberDto.getNo()%>'>[삭제]</a>
	<br/>
	
	<%
		}
	%>
	
</body>

</html>


