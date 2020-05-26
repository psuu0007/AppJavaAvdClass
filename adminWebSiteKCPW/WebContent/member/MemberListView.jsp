<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	tr {
		text-align: center;
	}
</style>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" type="text/css"
	 href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>
	여긴 아니야 
	<jsp:include page="/Header.jsp" />
	
	<div id='membersTable'>
		<h1 id='pageTitle'>Members</h1>
		<p style="margin: 10px 0px 30px">
			<a href='./add' id='addLink'>신규 회원</a>
		</p>
		
		<table id='table'>
			<colgroup>
				<col width="15%">
				<col width="15%">
				<col width="35%">
				<col width="20%">
				<col width="15%">
			</colgroup>
			<thead>
				<tr>
					<th>회원번호</th>
					<th>이름</th>
					<th>이메일</th>
					<th>가입날짜</th>
					<th>등급</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="memberDto" items="${memberList}">
					<tr>
						<td>${memberDto.no}</td>
						<td>
							<a href="./update?no=${memberDto.no}">${memberDto.name}</a>
						</td>
						<td style='text-align: left;'>
							<p class='textOFlow'>${memberDto.email}</p>
						</td>
						<td>${memberDto.createdDate}</td>
						<td>${memberDto.grade}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<jsp:include page="/Tail.jsp" />
	
</body>

</html>