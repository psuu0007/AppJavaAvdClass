<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>게시판</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css">

</head>

<body>
	<div>
		<jsp:include page="/Header.jsp"/>
		<div style='margin-left: 50px; margin-top:20px;'>
		<h1>게시판</h1>
		<table class='bulletin'>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>

		<c:forEach var="bulletinDto" items="${bulletinList}">
			<tr>
				<td>${bulletinDto.no}</td>
				<td><a href="./update?no=${bulletinDto.no}">${bulletinDto.title}</a></td>
				<td>${bulletinDto.writer.nickname}</td>
				<td>${bulletinDto.createdDate}</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="4">
					<input id="hiddenPageNo" type="hidden" value="${pageNo}">
					
					<input class="pageBtn" type="button" value="&lArr;" onclick="pagePreMove(${pageNo}, ${pageCnt})">
					
					<input class="pageBtn" type="button" value="&#8592;" onclick="pageMovePre(${pageNo})">
					
					<fmt:parseNumber value="${((pageNo - 1) / 10)}" type="number" var ="paNo" integerOnly="true"></fmt:parseNumber>
			
					<c:set var="startNo" value="${paNo * 10 + 1}"></c:set>
					<c:set var="endNo" value="${(paNo + 1) * 10}"></c:set>
					<c:if test="${endNo > pageCnt }">
						<c:set var="endNo" value="${pageCnt }"></c:set>
					</c:if>
					
					<c:forEach var="i" begin="${startNo}" end="${endNo}">
						<input class="pageBtn" type="button" value="${i}" onclick="pageMove(${i})">
					</c:forEach>
					
					
					<input class="pageBtn" type="button" value="&#8594;" onclick="pageMoveNext(${pageNo}, ${pageCnt})">
					
					<input class="pageBtn" type="button" value="&rArr;" onclick="pageNextMove(${pageNo}, ${pageCnt} )">
				</td>
			</tr>
		</table>
		
		<c:if test="${member.grade eq '1' || member.grade eq '0'}">
		<form action="./add">
			<button>글쓰기</button>
		</form>
		</c:if>
		</div>
		<jsp:include page="/Tail.jsp"/>
		
	</div>

</body>

<script type="text/javascript" src="../js/common.js"></script>

<script type="text/javascript">
	window.onload = function(){
	navBtnCngFnc();
	pageBtnCngFnc();
}
	
	function addTable() {
		location.href="./add"

	}
	
	function pageMove(obj){
		location.href="./list?pageNo=" + obj;
	}
	
	function pageMovePre(obj){
		obj--;
		if(obj < 1){
			obj = 1;
		}else {
			location.href="./list?pageNo=" + obj;
		}
	}

	function pageMoveNext(obj, pageCnt){
		obj++;
		if(obj > pageCnt){
			obj = pageCnt;
		}
		location.href="./list?pageNo=" + obj;
	}
	
	function pagePreMove(obj, pageCnt){
		obj = (obj - 10) - (obj % 10) + 1;
		if(obj < 1){
			obj = 1;
		}
		location.href="./list?pageNo=" + obj;
	}
	
	function pageNextMove(obj, pageCnt){
		obj = (obj + 10) - (obj % 10) + 1;
		if(obj > pageCnt){
			obj = pageCnt;
		}
		location.href="./list?pageNo=" + obj;
	}
	
	
	
</script>

</html>