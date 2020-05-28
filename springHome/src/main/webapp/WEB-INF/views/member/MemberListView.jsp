<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>

<style type="text/css">
table {
	border-collapse: collapse;
}

table, tr, th, td{
	border: 1px solid black;
}

</style>

</head>

<body>
	<jsp:include page="/WEB-INF/views/Header.jsp" />
	<h1>회원목록</h1>
	<div>
		<a href='./add.do'>신규 회원</a>
	</div>
	
	
	<table>
		<tr>
			<th>번호</th><th>회원이름</th>
			<th>이메일</th><th>가입일</th>
			<th></th>
		</tr>
	<c:forEach var="memberDto" items="${memberList}">
		<tr>
			<td>${memberDto.no}</td>
			<td>
				<a href='./update.do?no=${memberDto.no}'>
					${memberDto.name}
				</a>
			</td>
			<td>${memberDto.email}</td>
			<td>
				<fmt:formatDate value="${memberDto.createdDate}" 
					pattern="yyyy-MM-dd hh:mm"/>
			</td>
			<td>
				<a href='./deleteCtr.do?no=${memberDto.no}'>[삭제]</a>
			</td>
		</tr>
	</c:forEach>
	</table>
	
	
	<jsp:include page="/WEB-INF/views/common/paging.jsp">
		<jsp:param value="${pagingMap}" name="pagingMap"/>
	</jsp:include>
	
	
	<jsp:include page="/WEB-INF/views/Tail.jsp" />
</body>
</html>