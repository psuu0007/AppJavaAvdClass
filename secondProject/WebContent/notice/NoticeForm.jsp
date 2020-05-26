<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>글목록</title>

<style type="text/css">

	table, tr, td {
		border-collapse: collapse;
		text-align: center;
	}
	
	td {
		height: 34px;
	}
	
	tr {
		border-bottom: 1px solid #DAD9FF;
	}
	
	input {
		border: none;
		background-color: #DAD9FF;
		border-radius: 4px;
	}
	
	input:hover {
    	background-color: #4B58E3;
	}

	a:link {text-decoration: none; color: black;}
	a:visited {text-decoration: none; color: black;}
	a:active {text-decoration: none; color: black;}
	a:hover {text-decoration: none; color: #4B58E3;}


</style>

</head>

<script type="text/javascript">
	
	function moveBoardListFnc() {
		
		location.href = '../member/list';
	}
	
	function moveBoardWriteFnc() {
		
	}
	
	
	
</script>

<script type="text/javascript">
	function moveBoardListFnc() {
		location.href="../member/list";
	}
	
	window.onload = function() {
		var firstTr = document.getElementsByTagName("tr")[0];
		firstTr.style.color = '#4B58E3';
		var trArrLengthValue = document.getElementsByTagName("tr").length;
		var lastTr = document.getElementsByTagName("tr")[trArrLengthValue-1];
	}
</script>

<body>

	<jsp:include page="/Header.jsp"></jsp:include>

	<div id="mainContents">
		<div>
		
			<h2>공지사항</h2>
			
			<table style="border-collapse:collapse; margin-bottom: 20px; text-align: center;">
				<tr style="color: #4B58E3; font-weight: bold;">				
					<td style="width: 70px;">번호</td>
					<td style="width: 400px;">제목</td>
					<td style="width: 100px;">작성자</td>
					<td style="width: 200px;">작성날짜</td>
				</tr>
				<c:forEach var="noticeDto" items="${noticeList}">
				<tr style="border-top: 1px solid #DAD9FF;">
					<td>${noticeDto.no}</td>
					<td><a href="./update?no=${noticeDto.no}" style="text-decoration: none; color: black;">${noticeDto.title}</a>
					</td>
	
					<td>관리자</td>
					<td>${noticeDto.writeDate}</td>
				</tr>
				</c:forEach>
			</table>
			<div>
				<form action="./add" method="get">
			
					<input onclick="moveBoardListFnc();" type="button" value="게시판 목록" >
					
					<c:if test="${sessionScope.memberDto.adminCheck eq 'Y'}">
							<input type="submit" value="글쓰기" style="margin-left: 600px;">
					</c:if>
				</form>
			</div>
			
		</div>
		
	</div>

	<jsp:include page="/Tail.jsp"></jsp:include>
	
</body>

</html>