<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8" >
<title>회원 목록</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css">
<script type="text/javascript" src="../js/common.js"></script>


<style type="text/css">	

	.listBtn {
		margin: auto;
	}
	
	.bottomBtn {
		margin-top: 30px; 
		width: 90px; 
		height: 40px; 
		font-weight: bold; 
		font-size: 15px;"
	}
	
</style>


<script type="text/javascript">

	window.onload = function(){
		navBtnCngFnc();
		pageBtnCngFnc();
	}
	
	function addFnc() {
		location.href='./add';
	}
	function updateFnc(no) {
		location.href='./update?no='+no;
	}
	function deleteFnc(no) {
		const result = confirm('정말 삭제하시겠습니까?')
		if(result){
			location.href='./delete?no='+no;
			alert("삭제되었습니다");
		}else{
			return false;
		}	
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

</head>

<body>

	<div>
	
		<jsp:include page="/Header.jsp"/>
		
		
		<h1>회원목록</h1>
	
		<table>
			<tr>
				<th style="width: 100px;">회원번호</th>
				<th style="width: 200px;">닉네임</th>
				<th style="width: 200px;">이메일</th>
				<th style="width: 100px;">회원등급</th>
				<th style="width: 100px;">수정</th>
				<th style="width: 100px;">삭제</th>
			</tr>
			<c:forEach var="memberDto" items="${memberList}">
				<tr>
					<td>${memberDto.no}</td>
					<td>${memberDto.nickname}</td>
					<td>${memberDto.email}</td>
					<td style="text-align: center;">
						<c:choose>
							<c:when test="${memberDto.grade eq '1'}"><a style="color:#FF3333;" >관리자</a></c:when>
							<c:when test="${memberDto.grade eq '0'}" >회원</c:when>
							<c:otherwise>사장님</c:otherwise>
						</c:choose>

					</td>
					<td style="text-align: center;"><button class ="listBtn" onclick="updateFnc(${memberDto.no})">수정</button></td>
					<td style="text-align: center;"><button class ="listBtn" onclick="deleteFnc(${memberDto.no});">삭제</button></td>
				</tr>	
			</c:forEach>
			<tr>
				<td colspan="6" style="border: none; text-align: center;">
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
		
		<button class="bottomBtn" onclick="addFnc();">회원추가</button>
	
		<jsp:include page="/Tail.jsp"/>
		
	</div>

</body>





</html>