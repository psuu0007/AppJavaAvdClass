<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>

</head>

<body>
<<<<<<< HEAD
	<jsp:include page="/WEB-INF/views/Header.jsp" />
	<h1>회원목록</h1>
	<p>
		<a href='./add.do'>신규 회원</a>
	</p>
	
	<c:forEach var="memberDto" items="${memberList}">
	
		${memberDto.no},
		<a href='./update?no=${memberDto.no}'>${memberDto.name}</a>,
		${memberDto.email},
		${memberDto.createdDate}
		<a href='./delete?no=${memberDto.no}'>[삭제]</a><br>
	</c:forEach>
	<jsp:include page="/WEB-INF/views/Tail.jsp" />
=======
<%-- 	<jsp:include page="/Header.jsp" /> --%>
	<h1>회원목록</h1>
	<p>
		<a href='./add'>신규 회원</a>
	</p>
	
	<c:forEach var="memberDto" items="${memberList}">
	
		${memberDto.no},
		<a href='./update?no=${memberDto.no }'>${memberDto.name}</a>,
		${memberDto.email},
		${memberDto.createdDate}
		<a href='./delete?no=${memberDto.no}'>[삭제]</a><br>
	</c:forEach>
<%-- 	<jsp:include page="/Tail.jsp" /> --%>
>>>>>>> branch 'master' of https://github.com/psuu0007/AppJavaAvdClass.git
</body>
</html>