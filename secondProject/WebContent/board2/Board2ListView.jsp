<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
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
<head>
<title>게시판2 목록</title>

</head>

<body>
	<jsp:include page="/Header.jsp" />
	<h2>게시판2</h2>
	<table>
		<tr style="font-weight: bold;">
			<td style="width: 70px;">번호</td><td style="width: 400px;">제목</td><td style="width: 100px;">작성자</td><td style="width: 200px;">작성날짜</td>
		</tr>
		
		<c:forEach var="board2Dto" items="${board2List}">
			<tr>
				<td>${board2Dto.bno2}</td>
				<td><a href="./update?bno2=${board2Dto.bno2}">${board2Dto.title2}</a></td>
				<td>${board2Dto.writer2}</td>
				<td>${board2Dto.writeDate2}</td>
			</tr>
		</c:forEach>
	</table>
	<form action='./add' method='get'>
		<input type='button' onclick="moveBoardListFnc();" value='게시판 목록' style="margin-top: 20px;">
		<input type='submit' value='글쓰기' style="margin-left: 600px;">
	</form>
	
	<jsp:include page="/Tail.jsp" />
</body>

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

</html>