<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 1목록</title>

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
<script type="text/javascript">

	function moveBoardListFnc() {
		
		location.href="../member/list";
	}

	
	function moveBoardWriteFnc() {
		
		location.href="./add";
		
		
	}
	
	function focusOutFnc(tdObj) {
		tdObj.parentNode.parentNode.style.backgroundColor = 'white';
		
		tdObj.parentNode.parentNode.style.color = 'black';
		
	}
	
	function focusOverFnc(tdObj) {
			
		tdObj.parentNode.parentNode.style.backgroundColor = 'skyblue';
		
		tdObj.parentNode.parentNode.style.color = 'white';
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

</head>
	<% int pageNo = Integer.parseInt(request.getParameter("pageNo")); 
	   int startNo = (pageNo-1) * 10;
	   int endNo = 10 * pageNo;
		int cnt = 1;
	%>
	
	
<body>

<jsp:include page="/Header.jsp"/>

<jsp:useBean 
	id="board1List"
	scope="request"
	class="java.util.ArrayList"
	type="java.util.ArrayList<spms.dto.Board1Dto>"
/>
<h2>게시판1</h2>
<div id="mainContents">
	<div>
		<table>
			<tr  style="font-weight: bold;">				
				<td style="width: 70px;">번호</td>
				<td style="width: 400px;">제목</td>
				<td style="width: 100px;">작성자</td>
				<td style="width: 200px;">작성날짜</td>
			</tr>
			<c:forEach var="board1Dto" items="${board1List}" begin="<%=startNo%>" end="<%=endNo%>">
			<tr>
				<td>${board1Dto.no}</td>
				<td>
					<a onmouseover="focusOverFnc(this);" onmouseleave="focusOutFnc(this);" href="./contents?no=${board1Dto.no}" style="text-decoration: none; color: black;">
						
						${board1Dto.title}
						
					</a>
				</td>
				<td>${board1Dto.writer}</td>
				<td>${board1Dto.writeDate}</td>
			</tr>
			</c:forEach>
		</table>

		<div style="width: 770px; text-align: center;">
			<c:forEach var="i" begin="1" end="${board1List.size() / 10 +1}">
				<c:if test="${i ne pageNo}">
					<a href="./list?pageNo=${i}">[${i}]</a>
				</c:if>
			</c:forEach>
		</div>		

		<div>
			<input onclick="moveBoardListFnc();" type="button" value="게시판 목록" >
			<input onclick="moveBoardWriteFnc();" type="button" value="글쓰기" style="margin-left: 600px;">
		</div>
	</div>
	
</div>

<jsp:include page="/Tail.jsp"/>

</body>
</html>